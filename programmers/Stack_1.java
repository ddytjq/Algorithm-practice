import java.util.Scanner;
import java.util.Stack;

public class Stack_1 {
	public static int solution(String arrangement) {
		int answer = 0;
		Stack st = new Stack();

		for (int i = 0; i < arrangement.length(); i++) {
			if (arrangement.charAt(i) == '(') {
				st.push(1);
			} else {
				st.pop();
				answer += st.size();
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		String result = "()(((()())(())()))(())";
		System.out.println(solution(result));
	}
}