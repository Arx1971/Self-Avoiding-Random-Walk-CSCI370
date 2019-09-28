package selfavoidingwalk;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class PolygonWalk extends Thread {

	Map<Integer, Integer> dataSet = new ConcurrentHashMap<>();

	int dimensionSize;

	public PolygonWalk(int dimensionSize) {
		this.dimensionSize = dimensionSize;
	}

	public void selfavoidingPolygon() {

		for (int i = 1; i <= GlobalField.steps; i++) {
			dataSet.put(i, 0);
		}

		for (int i = 1; i <= GlobalField.N_SAW; i++) {

			Set<Coordinates> visited = new HashSet<Coordinates>();

			int temp[] = new int[dimensionSize];

			Arrays.fill(temp, 0);

			Coordinates origin = new Coordinates(temp);

			visited.add(origin);

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

				if (tmp == false) {
					visited.add(obj);
				} else if (tmp == true) {
					if (obj.equals(origin)) {
						dataSet.put(j, dataSet.get(j) + 1);
						break;
					} else
						break;
				}

			}

		}

	}

	public void run() {
		selfavoidingPolygon();
	}

}
