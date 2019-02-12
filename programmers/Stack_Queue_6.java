public class Stack_Queue_6 {
	public static int[] solution(int[] prices) {
		int[] answer = {};
		answer = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {
			answer[i] = prices.length - i -1;
			for (int j = i + 1; j < prices.length; j++) {
				if(prices[i] > prices[j]) {
					answer[i] = j-i;
					break;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] prices = { 498, 501, 470, 489 };

		for (int i = 0; i < solution(prices).length; i++)
			System.out.print(solution(prices)[i] + " ");
	}
}