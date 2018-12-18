import java.util.Arrays;

public class Hash_2 {
	public static boolean solution(String[] phone_book) {
		
		boolean answer = true;

		Arrays.sort(phone_book);
		
		for(int i=1;i<=phone_book.length;i++) {
			if(phone_book[i].contains(phone_book[0])) 
				answer = false;
			break;
		}
		return answer;
	}

	public static void main(String[] args) {
		
		String[] phone_book1 = {"119","97674223","1195524421"};
		String[] phone_book2 = {"123","456","789"};
		String[] phone_book3 = {"12","123","1235","567","88"};
		

		System.out.println(solution(phone_book1));
		System.out.println(solution(phone_book2));
		System.out.println(solution(phone_book3));
	}

}
