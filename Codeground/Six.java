import java.util.Scanner;

public class Six {
	public static void main(String args[]) throws Exception	{

		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++){
			int idx = sc.nextInt();
			int num[] = new int[idx];
			for(int i=0; i<idx; i++)
				num[i] = sc.nextInt();
			boolean boo[] = new boolean[400002];
			int result = 0;
			for(int i = 0; i < idx; i++){
				boolean found = false;
				for(int j = 0; j < i; j++){
					if(boo[num[i]-num[j]+200000]) //음수때매 +200000
						found = true;
				}
				for(int k = 0; k <= i; k++)
					boo[num[i]+num[k]+200000] = true;
				if(found) //만약 found가 true면 
					result++; //result +1
			}
			System.out.println("Case #" + test_case);
			System.out.println(result);
		}
	}
}