package random_walk;

import java.util.Arrays;

public class Coordinates {

	int[] arr;

	public Coordinates(int[] a) {
		this.arr = a.clone();
	}

	@Override
	public String toString() {
		return Arrays.toString(arr);
	}

	@Override
	public int hashCode() {
		final int prime = 231;
		int result = 1;
		result = prime * result + Arrays.hashCode(arr);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		return Arrays.equals(arr, other.arr);
	}

}
