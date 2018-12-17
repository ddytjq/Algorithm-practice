/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

import java.util.Arrays;
import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Practice_3 {
	static int Answer;
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int n, k;
		int result[];

		for(int test_case = 0; test_case < T; test_case++) {
			n = sc.nextInt();
			k = sc.nextInt();
			result = new int[n];
			
			for(int j = 0; j < n; j++) {
				result[j] = sc.nextInt();
			}
			
			Arrays.sort(result);

			for(int j = 1; j < k+1; j++)
				Answer += result[n-j];

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}