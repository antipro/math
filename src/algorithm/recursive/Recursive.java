package algorithm.recursive;

/**
 * 递归计算x的N次方
 */
public class Recursive {

	/**
	 * 方法一
	 * @param x 基数
	 * @param n 指数
	 * @return 结果
	 */
	static double power(double x, int n) {
		while (n >= 0) {
			if (n == 0)
				return 1;
			else
				return x * power(x, n - 1);
		}
		return 0;
	}

	/**
	 * 方法二
	 * @param x 基数
	 * @param n 指数
	 * @return 结果
	 */
	static double power2(double x, int n) {
		while (n >= 0) {
			if (n == 0)
				return 1;

			switch (n % 2) {
			case 0:
				return power2(x, (n / 2)) * power2(x, (n / 2));
			case 1:
				return power2(x, (n / 2)) * power2(x, (n / 2)) * x;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(power2(5d, 5));
	}
}
