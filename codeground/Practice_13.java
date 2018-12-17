import java.util.Scanner;

public class Practice_13 {
	static int Answer;
	public static void main(String args[]) throws Exception	{

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			int num = sc.nextInt();
			int q , w ;
			Answer = 0;
			for(int b = 2; b < num-1; b++){
				q = 0; w = 0;
				q = num % b;
				w = num / b;
				if(q == w){
					Answer = b;
					break;
				}
				else if(b > q){
					if(Answer == 0)
						Answer = b;
				}
			}

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}