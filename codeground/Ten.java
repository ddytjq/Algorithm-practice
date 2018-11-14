import java.util.Scanner;

public class Ten {
	public static void main(String args[]) throws Exception	{

		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++){
			int idx = sc.nextInt();
			int num[] = new int[idx+1];
			num[0] = 0;
			for(int i=1; i <= idx; i++)
				num[i] = sc.nextInt();
			int num2[] = new int[num[idx]+1];
			num2[0] = 1;
			for(int i = 1; i <= idx; i++)
				num2[num[i]] = 1;
			for(int i = 1; i <= num[idx]; i++){
				if(num2[i] != 1)
					num2[i] = 0;
			}
			int result = 0;
			int max = sc.nextInt();
			int max2 = max;
			int temp = 0;
			while(max2 < num[idx]){
				if(num2[max2] == 1){
					result++;
					max2 = max2 + max;
					temp = 0;
				}
				else{
					max2 = max2 - 1;
					temp++;
					if(temp == max){
						result = -1;
						break;
					}
				}
			}
			if(result != -1)
				result++;
			System.out.println("Case #" + test_case);
			System.out.println(result);
		}
	}
}