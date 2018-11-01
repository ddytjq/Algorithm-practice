
public class One {
	public static void main(String[] args) throws Exception{
			
			Scanner sc = new Scanner(System.in);
			
			int TC;
			int test_case;
			
			TC = sc.nextInt();
			for(test_case = 1; test_case <= TC; test_case++){
				int result = 0;
				int bit = sc.nextInt();
				for(int i = 0; i < bit; i++){
					int num = sc.nextInt();
					result = result ^ num;
				}
			System.out.println("Case #"+test_case);
			System.out.println(result);
			}
			
		}

	}

}
