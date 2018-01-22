/*
 * @author antipro
 * 创建于 2009-11-13
 * 各种选择排序方法
 */
package algorithm.sort;

import java.util.Random;

/**
 * 2009-11-13 各种选择排序方法
 * 每一趟从待排序的数据元素中选出最小（或最大）的一个元素， <br/>
 * 顺序放在已排好序的数列的最前，直到全部待排序的数据元素排完。 <br/>
 */
public final class SelectionSort {
	/**
	 * 我的选择排序方法。与书上大同小异Java数据结构P337
	 * @param A 待排序的整数数组
	 * @param m 数组左边界
	 * @param n 数组右边界
	 */
	public static void selectSort1(int[] A, int m, int n) {
		int p;
		int tmp;
		while (m < n) {
			p = m;
			for (int i = m + 1; i <= n; i++) {
				if (A[p] > A[i]) {
					p = i;
				}
			}
			tmp = A[m];
			A[m] = A[p];
			A[p] = tmp;
			m++;
		}
	}

	/**
	 * 测试方法
	 */
	public static void main(String[] args) {
		int[] A = new int[6000];
		Random rand = new Random();
		for (int i = 0; i < A.length; i++) { // 用随机数产生两个相同的[0,100)数组
			A[i] = rand.nextInt(100);
		}

		long t1 = System.currentTimeMillis(); // 比冒泡排序效率稍高
		selectSort1(A, 0, 5999);
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);

	}
}
