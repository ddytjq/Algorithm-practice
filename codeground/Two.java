import java.util.Arrays;
import java.util.Scanner;

public class Two {
	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;
 
		TC = sc.nextInt();
		for(test_case = 1; test_case <= TC; test_case++){
			int bit = sc.nextInt();
			int result = 0;
			int max = 0;
			int score[] = new int [bit];
			for(int i = 0; i < bit; i ++){
				score[i] = sc.nextInt();
			}
			Arrays.sort(score);
			
			for(int i = bit-1; i >= 0 ; i--){
				if(score[i]+bit-i>max)
					max = (score[i]+bit-i);
			}
			for(int i = 0; i < bit; i ++){
				if(score[i] + bit >= max)
					result++;
			}
			System.out.println("Case #" + test_case);
			System.out.println(result);
			}
		}
	}
