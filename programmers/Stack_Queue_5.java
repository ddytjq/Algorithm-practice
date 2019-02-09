import java.util.Stack;

public class Stack_Queue_5 {
	public static int[] solution(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int[] answer = new int[heights.length];

		for (int i = 0; i < heights.length; i++) {
			for (int j = i + 1; j < heights.length; j++) {
				if (heights[i] > heights[j])
					answer[j] = i + 1;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] heights = { 6, 9, 5, 7, 4 };

		for (int i = 0; i < solution(heights).length; i++) {
			System.out.print(solution(heights)[i]);
		}
	}
}