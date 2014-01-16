package learning;

import java.util.Arrays;

public class PermMissingElem {

	public int solution(int[] A) {

		int lenght = A.length + 1;
		int sum = (lenght * (lenght + 1) / 2);

		for (int a : A) {
			sum = sum - a;
		}

		return sum;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a = { 1, 3, 2, 5 };

		System.out.println(new PermMissingElem().solution(createArray(1)));

		System.out.println("Started");

		for (int x = 0; x < 100000; x++) {
			int result = new PermMissingElem().solution(createArray(x + 1));

			if (result != (x + 1)) {
				System.out.println(x + ": result" + result);
				break;
			}

			if (x % 1000 == 0) {
				System.out.println("line:" + x);
			}
		}
		System.out.println("finish");
	}

	public static int[] createArray(int missing) {
		int[] array = new int[99999];
		int add = 1;

		for (int i = 0; i < 99999; i++) {
			if (i == missing - 1) {
				add++;
			}
			array[i] = i + add;

		}

		return array;
	}
}
