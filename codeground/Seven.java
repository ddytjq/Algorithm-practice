import java.util.Scanner;

public class Seven {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();
		for(test_case = 1; test_case <= TC; test_case++){
			int idx = sc.nextInt();
			int num[] = new int[idx];
			int temp[] = new int[idx];
			int number = 0;
			int result = 0;
			for(int i = 0; i < idx; i++)
				num[i] = sc.nextInt();
			do{
				number++;
				result=0;
				temp[0] = 0;
				temp[idx-1] = 0;
				for(int i = 1; i < idx-1; i++){
					if(num[i-1]>num[i]){
						if(num[i] == 0)
							temp[i] = 0;
						if(num[i]!=0&&num[i]>num[i+1])
							temp[i]=num[i+1];
						if(num[i]!=0&&num[i]<=num[i+1])
							temp[i]=num[i]-1;
					}
					if(num[i-1]==num[i]){
						if(num[i] == 0)
							temp[i] = 0;
						if(num[i]!=0&&num[i]>num[i+1])
							temp[i]=num[i+1];
						if(num[i]!=0&&num[i]<=num[i+1])
							temp[i]=num[i]-1;
					}
					if(num[i-1]<num[i]){
						if(num[i] == 0)
							temp[i] = 0;
						if(num[i]!=0&&num[i-1]>num[i+1])
							temp[i]=num[i+1];
						if(num[i]!=0&&num[i-1]<=num[i+1])
							temp[i]=num[i-1];
					}
				}
				for(int i = 0; i < idx; i++){
					num[i] = temp[i];
					result = result + num[i];}
			}while(result != 0);
			System.out.println("Case #" + test_case);
			System.out.println(number);
		}
	}
}