import java.util.Scanner;
import java.util.Arrays;

public class Nine {
	public static void main(String args[]) throws Exception {
		new Nine().solve();
	}

	public void solve() {
		// 팩토리얼 관련 값 초기화.
		init();

		int T;
		int test_case;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			Point[] points = new Point[k + 1];

			for (int i = 0; i < k; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				points[i] = new Point(a, b);
			}

			Point finalPoint = new Point(n, m);
			points[k] = finalPoint;

			Arrays.sort(points);

			int index = Arrays.binarySearch(points, finalPoint);

			int[] pathNumber = new int[index + 1];

			for (int i = 0; i < index + 1; i++) {

				long otherPointPathNumber = 0;

				if (points[i].y > m || points[i].x > n)
					continue;

				for (int j = 0; j < i; j++) {
					if (points[j].y <= points[i].y && points[j].x <= points[i].x) {

						long temp = pathNumber[j];

						temp = (temp * combination(points[i].x - points[j].x + points[i].y - points[j].y,
								points[i].y - points[j].y)) % 1000000007;

						otherPointPathNumber = (otherPointPathNumber + temp) % 1000000007;
					}
				}
				int totalPath = combination(points[i].x + points[i].y - 2, points[i].x - 1);
				totalPath -= (int) otherPointPathNumber;
				totalPath = (1000000007 + totalPath) % 1000000007;

				pathNumber[i] = totalPath;
			}

			System.out.println("Case #" + test_case);
			System.out.println(pathNumber[index]);
		}
	}

	public static int combination(int a, int b) {
		long e = factorial[a];
		e = (e * factorialInverse[b]) % 1000000007;
		e = (e * factorialInverse[a - b]) % 1000000007;
		return (int) e;
	}

	static int[] factorial = new int[200001];
	static int[] factorialInverse = new int[200001];

	// 팩토리얼 및 역수 값 전부 계산해두기.
	public static void init() {
		long o = 1;
		factorial[0] = 1;
		for (int i = 1; i < 200001; i++) {
			o = (o * i) % 1000000007;
			factorial[i] = (int) o;
		}
		long oi = inversefactorial((int) o);
		for (int i = 200000; i >= 0; i--) {
			factorialInverse[i] = (int) oi;
			oi = (oi * i) % 1000000007;
		}
	}

	public static int inversefactorial(int x) {
		return power(x, 1000000005);
	}

	public static int power(int x, int p) {
		if (p == 1)
			return x;
		int t = power(x, p / 2);
		long result = t;
		result = (result * t) % 1000000007;
		if (p % 2 == 1) {
			result = (result * x) % 1000000007;
		}
		return (int) result;
	}

	class Point implements Comparable<Point> {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (x > o.x)
				return 1;
			else if (x < o.x)
				return -1;
			else {
				if (y > o.y)
					return 1;
				else if (y < o.y)
					return -1;
				else
					return 0;
			}
		}
	}
}