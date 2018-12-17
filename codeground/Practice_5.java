import java.util.Scanner;

public class Practice_5 {
	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;
		TC = sc.nextInt();
		int result[] = new int[2000001];
		result[0] = 1;
		for(int i = 1; i < 2000001; i++){
			long j = result[i-1];
			j = (j * i) % 1000000007;
			result[i] = (int)j;
		}

		for(test_case = 1; test_case <= TC; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			long c1 = result[n+m+2];
			int c2 = result[m+1];
			int c3 = result[n+1];
			int c4 = mod(c2, 1000000005);
			int c5 = mod(c3, 1000000005);

			long combination = (c1 * c4) % 1000000007;
			combination = (combination * c5) % 1000000007;
			combination = (combination - 1) % 1000000007;
			System.out.println("Case #" + test_case);
			System.out.println(combination);
		}
	}
	static int mod(int x, int k){
		if(k == 1)
			return x;
		int t = mod(x, k/2);
		long r = t;
		r = (r * t) % 1000000007;
		if(k % 2 == 1)
			r = (r * x) % 1000000007;
		return (int)r;
	}
}