import java.util.Scanner;

public class Eleven {
	static int Answer;

	public static int test(int num){
		int q , w ;
		int result = 0;
		for(int b = 2; b < num-1; b++){
			q = 0; w = 0;
			q = num % b;
			w = num / b;
			if(q == w){
				result = b;
				break;
			}
			else if(b > q){
				if(result == 0)
					result = b;
			}
		}
		return result;
	}

	public static void main(String args[]) throws Exception	{

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			int num = sc.nextInt();
			Answer = test(num);

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}