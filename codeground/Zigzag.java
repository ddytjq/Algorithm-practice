import java.util.Scanner;

public class Zigzag {
	public static void main(String args[]){
		int T;
		int test_case;
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int num[][] = new int[x][y];
			num[0][0] = 1;
			num[x-1][y-1] = x * y;
			int q = 0, w = 1, e = 2;

			if(x<y){
				for(int i = 1; i < x; i++){
					num[q][w] = e++;
					for(int j = 0; j < i; j++){
						if(i % 2 != 0){
							w--;
							q++;}
						else{
							w++;
							q--;}
						num[q][w] = e++;}
					if(i % 2 != 0 && q == x-1)
						w++;
					else if(i % 2 == 0 && w != y-1)
						w++;
					else if(i % 2 != 0)
						q++;
					else if(i % 2 == 0)
						w++;
				}
				if(x % 2 == 1 && y % 2 == 0){
					for(int i = 0; i < y-x; i++){
						num[q][w] = e++;
						for(int j = 0; j < x-1; j++){
							if(i % 2 == 0){
								q++;
								w--;}
							else{
								q--;
								w++;}
							num[q][w] = e++;}
						if(w == y-1)
							q++;
						else
							w++;
					}
					for(int i = x; i > 2; i--){
						num[q][w] = e++;
						for(int j = i-2; j >0; j--){
							if(i % 2 != 0){
								q--;
								w++;}
							else{
								q++;
								w--;}
							num[q][w] = e++;}
						if(i % 2 != 0)
							q++;
						else
							w++;
					}
				}
				else if(x % 2 == 0 && y % 2 == 0){
					for(int i = 0; i < y-x; i++){
						num[q][w] = e++;
						for(int j = 0; j < x-1; j++){
							if(i % 2 != 0){
								q++;
								w--;}
							else{
								q--;
								w++;}
							num[q][w] = e++;}
						if(w == y-1)
							q++;
						else
							w++;
					}
					for(int i = x; i > 2; i--){
						num[q][w] = e++;
						for(int j = i-2; j >0; j--){
							if(i % 2 == 0){
								q--;
								w++;}
							else{
								q++;
								w--;}
							num[q][w] = e++;}
						if(i % 2 == 0)
							q++;
						else
							w++;
					}
				}
				else if(x % 2 == 1 && y % 2 == 1){
					for(int i = 0; i < y-x; i++){
						num[q][w] = e++;
						for(int j = 0; j < x-1; j++){
							if(i % 2 == 0){
								q++;
								w--;}
							else{
								q--;
								w++;}
							num[q][w] = e++;}
						if(w == y-1)
							q++;
						else
							w++;
					}
					for(int i = x; i > 2; i--){
						num[q][w] = e++;
						for(int j = i-2; j >0; j--){
							if(i % 2 == 0){
								q--;
								w++;}
							else{
								q++;
								w--;}
							num[q][w] = e++;}
						if(i % 2 == 0)
							q++;
						else
							w++;
					}
				}
				else if(x % 2 == 0 && y % 2 == 1){
					for(int i = 0; i < y-x; i++){
						num[q][w] = e++;
						for(int j = 0; j < x-1; j++){
							if(i % 2 != 0){
								q++;
								w--;}
							else{
								q--;
								w++;}
							num[q][w] = e++;}
						if(w == y-1)
							q++;
						else
							w++;
					}
					for(int i = x; i > 2; i--){
						num[q][w] = e++;
						for(int j = i-2; j >0; j--){
							if(i % 2 != 0){
								q--;
								w++;}
							else{
								q++;
								w--;}
							num[q][w] = e++;}
						if(i % 2 != 0)
							q++;
						else
							w++;
					}
				}
			}
			if(x>y){
				for(int i = 1; i < y; i++){
					num[q][w] = e++;
					for(int j = 0; j < i; j++){
						if(i % 2 != 0){
							w--;
							q++;}
						else{
							w++;
							q--;}
						num[q][w] = e++;}
					if(i % 2 != 0)
						q++;
					else if(i % 2 == 0 && w != y-1)
						w++;
					else if(i % 2 == 0 && w == y-1)
						q++;
				}
				if(x % 2 == 1 && y % 2 == 0){
					for(int i = 0; i < x-y; i++){
						num[q][w] = e++;
						for(int j = 0; j < y-1; j++){
							if(i % 2 != 0){
								q++;
								w--;}
							else{
								q--;
								w++;}
							num[q][w] = e++;}
						if(q == x-1)
							w++;
						else
							q++;
					}
					for(int i = y; i > 2; i--){
						num[q][w] = e++;
						for(int j = i-2; j >0; j--){
							if(i % 2 != 0){
								q--;
								w++;}
							else{
								q++;
								w--;}
							num[q][w] = e++;}
						if(i % 2 != 0)
							q++;
						else
							w++;
					}
				}
				else if(x % 2 == 0 && y % 2 == 0){
					for(int i = 0; i < x-y; i++){
						num[q][w] = e++;
						for(int j = 0; j < y-1; j++){
							if(i % 2 != 0){
								q++;
								w--;}
							else{
								q--;
								w++;}
							num[q][w] = e++;}
						if(q == x-1)
							w++;
						else
							q++;
					}
					for(int i = y; i > 2; i--){
						num[q][w] = e++;
						for(int j = i-2; j >0; j--){
							if(i % 2 == 0){
								q--;
								w++;}
							else{
								q++;
								w--;}
							num[q][w] = e++;}
						if(i % 2 == 0)
							q++;
						else
							w++;
					}
				}
				else if(x % 2 == 1 && y % 2 == 1){
					for(int i = 0; i < x-y; i++){
						num[q][w] = e++;
						for(int j = 0; j < y-1; j++){
							if(i % 2 == 0){
								q++;
								w--;}
							else{
								q--;
								w++;}
							num[q][w] = e++;}
						if(q == x-1)
							w++;
						else
							q++;
					}
					for(int i = y; i > 2; i--){
						num[q][w] = e++;
						for(int j = i-2; j >0; j--){
							if(i % 2 == 0){
								q--;
								w++;}
							else{
								q++;
								w--;}
							num[q][w] = e++;}
						if(i % 2 == 0)
							q++;
						else
							w++;
					}
				}
				else if(x % 2 == 0 && y % 2 == 1){
					for(int i = 0; i < x-y; i++){
						num[q][w] = e++;
						for(int j = 0; j < y-1; j++){
							if(i % 2 == 0){
								q++;
								w--;}
							else{
								q--;
								w++;}
							num[q][w] = e++;}
						if(q == x-1)
							w++;
						else
							q++;
					}
					for(int i = y; i > 2; i--){
						num[q][w] = e++;
						for(int j = i-2; j >0; j--){
							if(i % 2 != 0){
								q--;
								w++;}
							else{
								q++;
								w--;}
							num[q][w] = e++;}
						if(i % 2 != 0)
							q++;
						else
							w++;
					}
				}
			}
			if(x == y && x % 2 == 0){
				for(int i = 1; i < y; i++){
					num[q][w] = e++;
					for(int j = 0; j < i; j++){
						if(i % 2 != 0){
							w--;
							q++;}
						else{
							w++;
							q--;}
						num[q][w] = e++;}
					if(i % 2 != 0 && q != x-1)
						q++;
					else if(i % 2 != 0 && q == x-1)
						w++;
					else if(i % 2 == 0 && w != y-1)
						w++;
					else if(i % 2 == 0 && w == y-1)
						q++;
				}
				for(int i = y; i > 2; i--){
					num[q][w] = e++;
					for(int j = i-2; j >0; j--){
						if(i % 2 == 0){
							q--;
							w++;}
						else{
							q++;
							w--;}
						num[q][w] = e++;}
					if(i % 2 == 0)
						q++;
					else
						w++;
				}
			}
			else if(x == y &&x % 2 != 0){
				for(int i = 1; i < y; i++){
					num[q][w] = e++;
					for(int j = 0; j < i; j++){
						if(i % 2 != 0){
							w--;
							q++;}
						else{
							w++;
							q--;}
						num[q][w] = e++;}
					if(i % 2 != 0)
						q++;
					else if(i % 2 == 0 && w != y-1)
						w++;
					else if(i % 2 == 0 && w == y-1)
						q++;
				}
				for(int i = y; i > 2; i--){
					num[q][w] = e++;
					for(int j = i-2; j >0; j--){
						if(i % 2 == 0){
							q--;
							w++;}
						else{
							q++;
							w--;}
						num[q][w] = e++;}
					if(i % 2 == 0)
						q++;
					else
						w++;
				}
			}
			for(int i = 0; i < x; i++){
				for(int j = 0; j < y; j++){
					System.out.print(num[i][j] + "\t");
				}
				System.out.println(" ");
			}
		}
	}
}
