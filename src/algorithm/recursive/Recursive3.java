package algorithm.recursive;

/**
 * 递归 求M与N的最大公约数
 */
public class Recursive3 {
	
	static int gcd(int m, int n) {
		if (m < n)
			return gcd(n, m);
		while (n >= 0) {
			if (n == 0)
				return m;
			else
				return gcd(n, m % n);
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(gcd(7, 21));
	}
}
