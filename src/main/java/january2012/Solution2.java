package january2012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2 {

	public int solution2(int K, int[] a) {

		
		//create index list
		Map<Integer, List<Integer>> list = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < a.length; i++) {
			int c = a[i];
			List<Integer> sublist = list.get(c);
			
			if (sublist == null) {
				sublist = new ArrayList<Integer>();
				list.put(c, sublist);
			}
			
			
			sublist.add(i);
			
			
		}

		for(int key : list.keySet() ){
			System.out.println(key +":"+ list.get(key));
		}
		System.out.println(list.keySet().size());
		
		return -1;
	}

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

		// System.out.println(boundend);
		return boundend;
	}

	public static int[] getArray() {
		int[] a = new int[100000];

		for (int i = 0; i < 100000; i++) {
			 a[i] = (int) (Math.random() * 1000000000);
//			a[i] = 1000000000;
		}

		return a;
	}

	public static void main(String[] arg) {

		int[] large = getArray();

		int[] A = { 3, 5, 7, 6, 3 };

		int[] B = { 1, 5, 2 };

		int[] C = { 4, 5, 8, 5, 1, 4, 6, 8, 7, 2, 2, 5 };

//		long start = System.currentTimeMillis();
//		int results = new Solution().solution(2, A);
//		long finish = System.currentTimeMillis() - start;

		long start2 = System.currentTimeMillis();
		int results2 = new Solution2().solution2(6, C);
		long finish2 = System.currentTimeMillis() - start2;

//		System.out.println("Result: " + results + "\nin time: " + finish);
		System.out.println("Result2: " + results2 + "\nin time2: " + finish2);
	}
}
