import java.util.Scanner;

public class Three {
	public static void main(String args[]){
		int T;
		int test_case;
		int[] score = {6,13,4,18,1,20,5,12,9,14,11,8,16,7,19,3,17,2,15,10};
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			int e = sc.nextInt();
			
			int n = sc.nextInt();
			
			int sum = 0;
			for(int i=0; i<n; i++){
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				double r = Math.sqrt(x*x+y*y);
				if(r<a){
					sum+=50;
					continue;
				}
				if(r>e){
					continue;
				}
				
				int m = 1;
				if(r>b && r<c)
					m=3;
				if(r>d && r<e)
					m=2;

				
				double theta = Math.atan(y/(double)x);
				theta *= (180/Math.PI);
				if(x<0)
					theta+=180;
				theta +=9;
				theta = (theta + 360) % 360;
				int t = (int)(theta/18);
				int add = m*score[t];
				sum+=(add);
			}
			
			System.out.println("Case #" + test_case);
			System.out.println(sum);
		}
	}
}
