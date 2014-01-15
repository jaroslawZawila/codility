package january2012;

import java.util.Arrays;

class Solution {

	public int solution(int K, int[] A) {

		int bounded = 0;

		for (int i = 0; i < A.length; i++) {

			bounded += getBounded(K, Arrays.copyOfRange(A, i, A.length));
		}

		return bounded;
	}

	private int getBounded(int K, int[] a) {

		int max = a[0];
		int min = a[0];
		int boundend = 1;

		boolean isBounded = true;

		for (int i = 1; i < a.length; i++) {

			int c = a[i];

			if (isBounded) {
				if (c >= min && c <= max) {
					boundend++;
					continue;
				} else {
					if (c < min) {
						min = c;
					} else {
						max = c;
					}

					if (max - min <= K) {
						boundend++;
						isBounded = true;
					} else {
						isBounded = false;
					}

				}
			} else {
				break;

			}

			if (boundend == 1000000000) {
				break;
			}
		}

		
		return boundend;
	}

	public static void main(String[] arg) {


		int[] A = { 3, 5, 7, 6, 3 }; // k=2; results=9

		int[] B = { 1, 5, 2 };

		int[] C = { 4, 5, 8, 5, 1, 4, 6, 8, 7, 2, 2, 5 }; //k=6; results=44

		long start = System.currentTimeMillis();
		int results = new Solution().solution(6, C);
		long finish = System.currentTimeMillis() - start;

		System.out.println("Result: " + results + "\nin time: " + finish);
	}
}
