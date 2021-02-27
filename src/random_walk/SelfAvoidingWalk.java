package random_walk;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class SelfAvoidingWalk extends Thread {

	Map<Integer, Simulator> dataSet = new ConcurrentHashMap<>();

	int dimensionSize;

	public SelfAvoidingWalk() {

	}

	public SelfAvoidingWalk(int dimensionSize) {
		this.dimensionSize = dimensionSize;
	}

	public void selfAvoidingWalk() {

		for (int i = 1; i <= GlobalField.steps; i++) {
			dataSet.put(i, new Simulator(0.0, 0));
		}

		for (int i = 1; i <= GlobalField.N_SAW; i++) {

			Set<Coordinates> visited = new HashSet<>();

			int temp[] = new int[dimensionSize];
			Arrays.fill(temp, 0);

			visited.add(new Coordinates(temp));

			for (int j = 1; j <= GlobalField.steps; j++) {

				if (dimensionSize == 2) {
					int r = ThreadLocalRandom.current().nextInt(4);
					for (int k = 0; k < dimensionSize; k++) {
						temp[k] += GlobalField.directions2d[r][k];
					}
				}

				else if (dimensionSize == 3) {
					int r = ThreadLocalRandom.current().nextInt(6);
					for (int k = 0; k < dimensionSize; k++) {
						temp[k] += GlobalField.directions3d[r][k];
					}

				}

				else if (dimensionSize == 4) {
					int r = ThreadLocalRandom.current().nextInt(8);
					for (int k = 0; k < dimensionSize; k++) {
						temp[k] += GlobalField.directions4d[r][k];
					}
				}

				Coordinates obj = new Coordinates(temp);

				boolean tmp = visited.contains(obj);

				if (!tmp) {

					visited.add(obj);

					double mean = 0.0;

					for (int l = 0; l < obj.arr.length; l++)
						mean += (Math.pow(obj.arr[l], 2));

					Simulator objSimulator = dataSet.get(j);

					double dt = objSimulator.rSquare + mean;

					int sz = objSimulator.size + 1;

					dataSet.put(j, new Simulator(dt, sz));

				} else {
					break;
				}

			}

		}

	}

	public void run() {
		selfAvoidingWalk();
	}

}
