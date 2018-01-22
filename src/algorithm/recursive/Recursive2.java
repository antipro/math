package algorithm.recursive;

/**
 * 递归求和 计算M和N的乘积
 */
public class Recursive2 {
	static int mult(int m, int n) {
		while (m > 0 && n > 0) {
			if (n == 1)
				return m;
			else
				return m + mult(m, n - 1);
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(mult(3, 1));
	}
}
