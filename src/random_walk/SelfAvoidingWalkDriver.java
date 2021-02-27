package random_walk;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SelfAvoidingWalkDriver {

	int dimensionSize;

	public SelfAvoidingWalkDriver(int dimensionSize) {
		this.dimensionSize = dimensionSize;
		calculation();
	}

	public void calculation() {
		long start = System.currentTimeMillis();

		SelfAvoidingWalk[] threads = new SelfAvoidingWalk[GlobalField.N_T];

		for (int i = 0; i < GlobalField.N_T; i++) {
			threads[i] = new SelfAvoidingWalk(dimensionSize);
			threads[i].start();
		}

		for (int i = 0; i < GlobalField.N_T; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Map<Integer, Simulator> simulatorConcurrentHashMap = new ConcurrentHashMap<>();

		for (int i = 1; i <= GlobalField.steps; i++) {
			simulatorConcurrentHashMap.put(i, new Simulator(0.0, 0));
		}

		for (int i = 0; i < GlobalField.N_T; i++) {

			Map<Integer, Simulator> localSimulatorMap = threads[i].dataSet;

			for (int j = 10; j <= GlobalField.steps; j++) {

				Simulator localObj = localSimulatorMap.get(j);
				Simulator globalObj = simulatorConcurrentHashMap.get(j);

				double dt = localObj.rSquare + globalObj.rSquare;
				int sz = localObj.size + globalObj.size;

				simulatorConcurrentHashMap.put(j, new Simulator(dt, sz));

			}
		}

		for (int i = 10; i <= 40; i++) {

			Simulator obj = simulatorConcurrentHashMap.get(i);

			double dt = obj.rSquare;
			int sz = obj.size;
			double fSaw = (double) (sz) / (GlobalField.N_T * GlobalField.N_SAW);
			System.out.println(i + "\t" + dt / sz + "\t" + fSaw);

		}

		long end = System.currentTimeMillis();
		double time = (end - start) / 1000.0;
		System.out.println("Total Time to Execute " + dimensionSize + "D: " + time + " Seconds");
	}

}
