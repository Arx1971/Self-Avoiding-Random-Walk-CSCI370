package random_walk;

public class PolygonWalkDriver {

	int dimensionSize;

	public PolygonWalkDriver(int dimensionSize) {
		this.dimensionSize = dimensionSize;
		calculation();
	}

	public void calculation() {

		long start = System.currentTimeMillis();

		PolygonWalk[] thread = new PolygonWalk[GlobalField.N_T];

		for (int i = 0; i < GlobalField.N_T; i++) {
			thread[i] = new PolygonWalk(dimensionSize);
			thread[i].start();
		}

		for (int i = 0; i < GlobalField.N_T; i++) {
			try {
				thread[i].join();
			} catch (Exception e) {

			}
		}

		for (int i = 10; i <= GlobalField.steps; i += 2) {

			int N_SAW_POLYGON = 0;

			for (int j = 0; j < GlobalField.N_T; j++) {

				N_SAW_POLYGON += thread[j].dataSet.get(i);

			}

			double fSaw = (double) (N_SAW_POLYGON) / (GlobalField.N_T * GlobalField.N_SAW);

			System.out.println(i + "\t" + fSaw);

		}

		long end = System.currentTimeMillis();

		double time = (end - start) / 1000.0;

		System.out.println("Total Time to Execute " + dimensionSize + "D: " + time + " Seconds");

	}

}
