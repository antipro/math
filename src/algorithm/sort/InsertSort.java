package algorithm.sort;

import java.util.*;

/**
 * 2009-11-13 各种插入排序方法
 */
public final class InsertSort {
	/**
	 * 书上的选择排序，Java数据结构P347.
	 * @param A 待排序数组
	 * @param m 数组左边界
	 * @param n 数组右边界
	 */
	public static void insertSort2(int[] A, int m, int n) {
		int i, j;
		int tmp;
		boolean notFinished;

		for (i = m + 1; i < n; i++) { // 遍历无序数组A[m+1:n]
			tmp = A[i]; // 保存待排数字
			j = i;
			notFinished = (A[j - 1] - tmp) > 0;
			while (notFinished) { // 遍历有序数组
				A[j] = A[j - 1];
				j--;
				if (j > m)
					notFinished = (A[j - 1] - tmp) > 0;
				else
					notFinished = false;
			}
			A[j] = tmp;
		}
	}

	/**
	 * 我自己的选择排序，不足之处在于使用了标签跳转，效率差不多。
	 * @param A 待排序数组
	 * @param m 数组左边界
	 * @param n 数组右边界
	 */
	public static void insertSort1(int[] A, int m, int n) {
		int p = m;
		int tmp; // 以p为界A[m:p]为有序数组，A[p+1:n]为无序数组。
		label: while (p < n) {
			for (int j = m; j <= p; j++) {
				if (A[p + 1] < A[j]) { // 当发现有序数组中的A[j]>待排序数时
					tmp = A[p + 1]; // 将A[j:p]右移,将A[p+1]插入有序数组
					for (int k = p + 1; k > j; k--) {
						A[k] = A[k - 1];
					}
					A[j] = tmp;
					p++; // 边界右移
					continue label; // ~退出重新开始遍历有序数组
				}
			}
			p++; // 如未找到，则简单移动边界，重新开始遍历有序数组
		}
	}

	/**
	 * 测试方法
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = new int[40000], B = new int[40000];
		Random rand = new Random();
		for (int i = 0; i < A.length; i++) {
			A[i] = B[i] = rand.nextInt(100);
		}

		long t1 = System.currentTimeMillis();
		insertSort1(A, 0, 39999);
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);

		long t3 = System.currentTimeMillis();
		insertSort2(B, 0, 39999);
		long t4 = System.currentTimeMillis();
		System.out.println(t4 - t3);
	}
}
