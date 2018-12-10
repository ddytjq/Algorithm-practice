import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Robot {

		private static int N;
		private static int[] x = new int[100000];
		private static int r;
		private static int L;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			r = Integer.parseInt(input[0]);
			L = Integer.parseInt(input[1]);
			input = br.readLine().split(" ");
			
			for (int j = 0; j < N; j++) {
				x[j] = Integer.parseInt(input[j]);
			}
			System.out.println("Case #" + (i + 1));
			System.out.println(solve());
		}
	}

	static boolean decision(int gap){	
		int rightLimit = 0;		
		for (int i = 0; i < N; i++) {
			int left = x[i] - gap - r;	// 가능한 경우 두 가지
			int right = x[i] + gap + r;
			
			if (left > rightLimit) 	return false;
			if (right > rightLimit) {
				rightLimit = Math.min(rightLimit + 2 * r, right);
			}		
			if (rightLimit >= L)
				return true;
		}
		return false;
	}
	
	private static int solve() {
		
		if (2 * r*N < L) return -1;
		int hi = 0, lo = Integer.MAX_VALUE;
		int mid = 0;
		
		for (int i = 0; i < 100; i++) {
			mid = (hi + lo) / 2;
			if (decision(mid)) {
				hi = mid;
			}
			else {
				lo = mid + 1;
			}
		}
		return mid;
	}
}