public class Stack_Queue_5 {
	public static int[] solution(int[] heights) {
		int[] answer= {};
		answer = new int[heights.length];

		for(int i = 0; i < heights.length; i++) {
			for(int j = i; j >= 0; j--) {
				if(heights[i] < heights[j]) {
					answer[i]=j+1;
					break;
				}
				
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] heights = { 6, 9, 5, 7, 4 };

		for (int i = 0; i < solution(heights).length; i++) {
			System.out.print(solution(heights)[i]+" ");
		}
	}
}