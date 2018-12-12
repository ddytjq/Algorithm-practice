import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Battery{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Battery().f();
	}
	
	public void f(){
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int leftMax = 0;
			int leftMin = 100000000;
			int rightMax = 0;
			int rightMin = 100000000;
			int upMax = 0;
			int upMin = 100000000;
			int downMax = 0;
			int downMin = 100000000;
			int[] xx = new int[2*n];
			Point[] xP = new Point[n];
			int[] yy = new int[2*n];
			Point[] yP = new Point[n];
			
			for(int i=0; i<n; i++){
				int x1 = sc.nextInt();
				int y1 = sc.nextInt();
				int x2 = sc.nextInt();
				int y2 = sc.nextInt();
				
				if(x1<=x2){
					if(leftMin > x1){
						leftMin = x1;
					}
					if(leftMax < x1){
						leftMax = x1;
					}
					if(rightMin > x2){
						rightMin = x2;
					}
					if(rightMax < x2){
						rightMax = x2;
					}
				} else{
					if(leftMin > x2){
						leftMin = x2;
					}
					if(leftMax < x2){
						leftMax = x2;
					}
					if(rightMin > x1){
						rightMin = x1;
					}
					if(rightMax < x1){
						rightMax = x1;
					}
				}
				
				xx[2*i] = x1;
				xx[2*i+1] = x2;
				xP[i] = new Point(x1, x2);
				
				if(y1<=y2){
					if(upMin > y1){
						upMin = y1;
					}
					if(upMax < y1){
						upMax = y1;
					}
					if(downMin > y2){
						downMin = y2;
					}
					if(downMax < y2){
						downMax = y2;
					}
				} else{
					if(upMin > y2){
						upMin = y2;
					}
					if(upMax < y2){
						upMax = y2;
					}
					if(downMin > y1){
						downMin = y1;
					}
					if(downMax < y1){
						downMax = y1;
					}
				}
				
				yy[2*i] = y1;
				yy[2*i+1] = y2;

				yP[i] = new Point(y1, y2);
			}


			Arrays.sort(xx);
			Arrays.sort(yy);
			
			
			ArrayList<Integer> xSet = new ArrayList<Integer>();
			int left = 0;
			while(left<2*n && xx[left] <= rightMin){
				int right = 2*n-1;
				int leftVal = xx[left];
				while(right>=0 && xx[right] >= leftMax){
					int rightVal = xx[right];
					if(rightVal < leftVal){
						right--;
						continue;
					}
					boolean mosun = false;
					for(int i=0; i<n && !mosun; i++){
						if((xP[i].p1 < leftVal || xP[i].p1 > rightVal) && (xP[i].p2 < leftVal || xP[i].p2 > rightVal))
							mosun = true;
					}
					if(!mosun){
						xSet.add(rightVal - leftVal);
					}
					right--;
				}

				left++;
				
			}
			Collections.sort(xSet);
			
			ArrayList<Integer> ySet = new ArrayList<Integer>();
			int up = 0;
			while(up<2*n && yy[up] <= downMin){
				int down = 2*n-1;
				int upVal = yy[up];
				while(down>=0 && yy[down] >= upMax){
					int downVal = yy[down];
					if(downVal < upVal){
						down--;
						continue;
					}
					boolean mosun = false;
					for(int i=0; i<n && !mosun; i++){
						if((yP[i].p1 < upVal || yP[i].p1 > downVal) && (yP[i].p2 < upVal || yP[i].p2 > downVal))
							mosun = true;
					}

					if(!mosun){
						ySet.add(downVal - upVal);
					}
					down--;
				}
				up++;
			}
			Collections.sort(ySet);
			
			int width = xSet.get(0);
			int height = ySet.get(0);
			
			System.out.println("Case #" + test_case);
			int result = Math.max(width, height);
			
			if(result%2 == 0)
				System.out.println(result/2);
			else
				System.out.println(result/2+".5");
		}
	}
	
	class Point{
		int p1;
		int p2;
		public Point(int a, int b){
			p1 = a;
			p2 = b;
		}
	}

}