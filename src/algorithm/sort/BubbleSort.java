package algorithm.sort;

import java.util.*;

/**
 * 2009-11-13 各种冒泡排序方法 <br/>
 * 已知一组无序数据a[1]、a[2]、……a[n]，需将其按升序排列。 <br/>
 * 首先比较a[1]与a[2]的值，若a[1]大于a[2]则交换两者的值，否则不变。 <br/>
 * 再比较a[2]与a[3]的值，若a[2]大于a[3]则交换两者的值，否则不变。 <br/>
 * 再比较a[3]与a[4]，以此类推，最后比较a[n-1]与 a[n]的值。 <br/>
 * 这样处理一轮后，a[n]的值一定是这组数据中最大的。 <br/>
 * 再对a[1]~a[n-1]以相同方法处理一轮，则a[n-1]的值一定是 a[1]~a[n-1]中最大的。 <br/>
 * 再对a[1]~a[n-2]以相同方法处理一轮，以此类推。 <br/>
 * 共处理n-1轮后a[1]、a[2]、……a[n]就以升序排列了 <br/>
 */
public final class BubbleSort {
	/**
	 * 采用递归的方式进行冒泡排序，当数组过大时，由于递归过深，会产生StackOverflowError。
	 * @param A 待排序的整数数组
	 * @param m 数组左边界
	 * @param n 数组右边界
	 */
	public static void bubbleSort1(int[] A, int m, int n) {
		if (m < n) {
			int tmp = 0;
			for (int i = m; i < n; i++) {
				if (A[i] > A[i + 1]) {
					tmp = A[i];
					A[i] = A[i + 1];
					A[i + 1] = tmp;
				}
			}
			bubbleSort1(A, m, n - 1);
		}
		return;
	}

	/**
	 * 采用循环的方式进行冒泡排序，当数组过大时，等待时间过长。
	 * @param A 待排序的整数数组
	 * @param m 数组左边界
	 * @param n 数组右边界
	 */
	public static void bubbleSort2(int[] A, int m, int n) {
		int tmp;
		while (m < n) {
			for (int i = m; i < n; i++) {
				if (A[i] > A[i + 1]) {
					tmp = A[i];
					A[i] = A[i + 1];
					A[i + 1] = tmp;
				}
			}
			n--;
		}
	}

	/**
	 * 书上的冒泡排序，由于每次循环都遍历整个数组，等待时间最长。Java数据结构P367
	 * @param A 待排序的整数数组
	 * @param m 数组左边界
	 * @param n 数组右边界
	 */
	public static void bubbleSort3(int[] A, int m, int n) {
		int i;
		int tmp;
		boolean notDone;
		do {
			notDone = false;
			for (i = 0; i < n - 1; i++) {
				if (A[i] > A[i + 1]) {
					tmp = A[i];
					A[i] = A[i + 1];
					A[i + 1] = tmp;
					notDone = true;
				}
			}
			// n--;//添加此句后速度提高，与bubbleSort1和bubbleSort2基本相同。
		} while (notDone);
	}

	/**
	 * 测试方法
	 */
	public static void main(String[] args) {
		int[] A = new int[6000], B = new int[6000], C = new int[6000];
		Random rand = new Random();
		for (int i = 0; i < A.length; i++) { // 用随机数产生两个相同的[0,100)数组
			A[i] = B[i] = C[i] = rand.nextInt(100);
		}

		long t1 = System.currentTimeMillis(); // 递归方法比循环稍占优势，但需求空间太大。
		bubbleSort1(A, 0, 5999);
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);

		long t3 = System.currentTimeMillis();
		bubbleSort2(B, 0, 5999);
		long t4 = System.currentTimeMillis();
		System.out.println(t4 - t3);

		long t5 = System.currentTimeMillis();
		bubbleSort3(C, 0, 5999);
		long t6 = System.currentTimeMillis();
		System.out.println(t6 - t5);
	}
}
