/*
 * @author antipro
 * 创建于 2009-11-13
 * 各种快速排序方法
 * 
 * 已知一组无序数据a[1]、a[2]、……a[n]，需将其按升序排列。
 * 首先任取数据a[x]作为基准。
 * 比较a[x]与其它数据并排序，使a[x]排在数据的第k位，
 * 并且使a[1]~a[k-1]中的每一个数据<a[x]，a[k+1]~a[n]中的每一个数据>a[x]，
 * 然后采用分治的策略分别对a[1]~a[k-1]和a[k+1]~a[n]两组数据进行快速排序。
 */
package algorithm.sort;

import java.util.*;

/**
 * 2009-11-13 各种快速排序方法
 */
public final class QuickSort {
	/**
	 * <br>
	 * 书上的快速排序方法：Java数据结构P342
	 * @param A 待排序整数数组
	 * @param i 数组左边界
	 * @param j 数组右边界
	 */
	public static void quickSort1(int[] A, int i, int j) {
		if (i < j) {
			int pivot, temp;
			int k, middle, p;

			middle = (i + j) / 2; // 选择中间关键字为轴

			pivot = A[middle];
			A[middle] = A[i];
			A[i] = pivot; // 将pivot放入第一个位置
			p = i; // 指向第一个位置

			for (k = i + 1; k <= j; k++) { // 扫描A[i+1:j]中剩下的关键字
				if (A[k] < pivot) { // 小于pivot的A[k]
					temp = A[++p];
					A[p] = A[k];
					A[k] = temp; // 移动到A[++p]
				} // 以p为界,p右边的元素全部大于pivot
			}

			temp = A[i];
			A[i] = A[p];
			A[p] = temp; // 将pivot放入A[p]中,也就是中间分界位置

			quickSort1(A, i, p - 1);
			quickSort1(A, p + 1, j);
		}
	}

	/**
	 * <br>
	 * 我的快速排序方法
	 * @param A 待排序整数数组
	 * @param m 数组左边界
	 * @param n 数组右边界
	 */
	public static void quickSort2(int[] A, int m, int n) {
		if (m < n) {
			int p = m; // 选择第一个元素为轴关键字
			int i = m, j = n;
			while (i < j) { // 当i==j时即一次排序完毕
				int tmp = 0;
				while ((A[j] >= A[p]) && (j > i)) { // 从数组末尾开始查找小于A[p]的元素
					j--;
				}
				tmp = A[j];
				A[j] = A[p];
				A[p] = tmp; // 找到后调换位置
				p = j; // 指向轴关键字
				while ((A[i] <= A[p]) && (i < j)) { // 从数组开头开始查找大于A[p]的元素
					i++;
				}
				tmp = A[i];
				A[i] = A[p];
				A[p] = tmp; // 找到后调换位置
				p = i; // 指向轴关键字
				// 特别的:当j==i且仍未离开循环时,p=i=j,此时交换数据不会有任何作用
			}
			quickSort2(A, m, p - 1);
			quickSort2(A, p + 1, n);
		}
	}

	/**
	 * 测试方法
	 */
	public static void main(String[] args) {
		int[] A = new int[400000], B = new int[400000]; // 数组够大才能显示出消耗时间
		Random rand = new Random();
		for (int i = 0; i < B.length; i++) { // 用随机数产生两个相同的数组
			A[i] = B[i] = rand.nextInt(100);
		}

		long t1 = System.currentTimeMillis();
		quickSort1(A, 0, 399999); // 测试第一种快排消耗时间
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);

		System.out.println();

		long t3 = System.currentTimeMillis();
		quickSort2(B, 0, 399999); // 测试第二种快排消耗时间
		long t4 = System.currentTimeMillis();
		System.out.println(t4 - t3);

		// 结论:两个快速排序时间差不多
	}
}
