package random_walk;

public final class GlobalField {

	static final int N_SAW = 100000;
	static final int N_T = 10000;
	static final int steps = 40;

	static final int directions2d[][] = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	static final int directions3d[][] = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, 1 },
			{ 0, 0, -1 } };

	static final int directions4d[][] = { { 0, 0, 0, -1 }, { 0, 0, -1, 0 }, { 0, -1, 0, 0 }, { -1, 0, 0, 0 },
			{ 0, 0, 0, 1 }, { 0, 0, 1, 0 }, { 0, 1, 0, 0 }, { 1, 0, 0, 0 } };

}