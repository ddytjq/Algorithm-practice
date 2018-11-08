import java.util.Scanner;

public class Five {
	public static void main(String args[]) throws Exception	{

		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();        
		int result[] = new int [TC];
		for(test_case = 1; test_case <= TC; test_case++) {
			int n = sc.nextInt();
			int idx = sc.nextInt();
			String enter = sc.next();
			int num[][] = new int[n][n];
			num[0][0] = 1;
			num[n-1][n-1] = n * n;
			int a = 0;
			int b = 1;
			int c = 2;
			{
			if(n % 2 == 0){
				for(int i = 1; i <n; i++){
					num[a][b] = c++;
					for(int j = 0; j < i; j++){
						if(i % 2 != 0){
							a++;
							b--;
						}
						else{
							a--;
							b++;
						}
						num[a][b] = c++;
					}
					if(i % 2 != 0 && a != n-1)
						a++;
					else if(i%2!=0 && a == n-1)
						b++;
					else if(i%2==0 && b != n-1)
						b++;
					else if(i%2==0 && b == n-1)
						a++;
				}
				for(int i = n; i > 2; i--){
					num[a][b] = c++;
					for(int j = i-2; j > 0; j--){
						if(i % 2 == 0){
							a--;
							b++;}
						else{
							a++;
							b--;
						}
						num[a][b] = c++;
					}
					if(i % 2 == 0)
						a++;
					else
						b++;
				}
			}
				if(n % 2 == 1){
					for(int i = 1; i <n; i++){
						num[a][b] = c++;
						for(int j = 0; j < i; j++){
							if(i % 2 != 0){
								a++;
								b--;
							}
							else{
								a--;
								b++;
							}
							num[a][b] = c++;
						}
						if(i % 2 != 0 && a != n-1)
							a++;
						else if(i%2==0 && b == n-1)
							a++;
						else if(i%2==0 && b != n-1)
							b++;
					}
					for(int i = n; i > 2; i--){
						num[a][b] = c++;
						for(int j = i-2; j > 0; j--){
							if(i % 2 == 0){
								a--;
								b++;}
							else{
								a++;
								b--;
							}
							num[a][b] = c++;
						}
						if(i % 2 == 0)
							a++;
						else
							b++;
					}
				}
			}
			int q = 0;
			int w = 0;
			int result1 = 0;
			for(int i = 0; i < idx; i++){
				char ch = enter.charAt(i);
				if(ch == 'D')
					q++;
				else if(ch == 'R')
					w++;
				else if(ch == 'U')
					q--;
				else if(ch == 'L')
					w--;
				result1 = result1 + num[q][w];
			}
			result[test_case-1] = result1;
		}
		for(int i = 0; i < TC; i++){
		System.out.println("Case #" + (i+1));
		System.out.println(result[i]+1);
		}
	}
}