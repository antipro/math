package algorithm;

import java.util.Random;

/**
 * 蒙特卡罗算法
 * @author antipro
 */
public class MonteCarlo {
	/**
	 * 默认半径为1 总数越大圆周率约接近正确值
	 * @param cnt 总数
	 * @return
	 */
	private static double getPi(int cnt) {
		// 落入圆内的点数
		int hint = 0;
		// 半径
		int r = 1;
		// 面积
		int area = r * r;
		Random random = new Random();
		for (int i = 0; i < cnt; i++) {
			// 随机数在-r 到 r 之间
			double x = random.nextDouble() * 2 * r - r;
			double y = random.nextDouble() * 2 * r - r;
			if (x * x + y * y <= area) {
				hint++;
			}
		}
		return hint * 1.0 / cnt * 4;
	}

	public static void main(String[] args) {
		System.out.println(getPi(50));
		System.out.println(getPi(500));
		System.out.println(getPi(5000));
		System.out.println(getPi(50000));
		System.out.println(getPi(500000));
		System.out.println(getPi(5000000));
		System.out.println(getPi(50000000));
	}

}
