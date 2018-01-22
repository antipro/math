package algorithm.sort;

import java.util.Random;

/**
 * 2009-11-13 各种归并排序方法
 */
public final class MergeSort {

	public static void mergeSort(int[] A, int m, int n) {
		// TODO
	}

	public static void main(String[] args) {
		int[] A = new int[10];
		Random rand = new Random();
		for (int i = 0; i < A.length; i++) {
			A[i] = rand.nextInt(100);
		}

		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
		long t1 = System.currentTimeMillis();
		mergeSort(A, 0, 9);
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);

		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}
}
