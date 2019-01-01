import java.util.LinkedList;
import java.util.Queue;

public class Stack_Queue_3 {
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		int temp;
		Queue<Integer> que = new LinkedList();
		Queue<Integer> result = new LinkedList();

		for (int i : truck_weights)
			que.offer(i);
		result.offer(que.poll());
		answer++;

		while (!result.isEmpty()) {
			if (result.size() < bridge_length) {
				temp = 0;
				for (int i : result)
					temp += i;

				if (temp > weight)
					result.poll();
				else {
					if (!que.isEmpty()) {
						result.offer(que.poll());
					} else {
						if (result.size() == 1) {
							if (truck_weights.length > 1) {
								answer += bridge_length - result.size();
								break;
							} else {
								answer += bridge_length - result.size() + 1;
								break;
							}
						} else {
							result.poll();
							answer--;
							if (result.size() == 1)
								answer++;
						}
					}
				}
			} else {
				result.poll();
			}
			answer++;
		}
		return answer;
	}

	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7, 4, 5, 6 };

		int bridge_length2 = 100;
		int weight2 = 100;
		int[] truck_weights2 = { 10 };

		int bridge_length3 = 100;
		int weight3 = 100;
		int[] truck_weights3 = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };

		System.out.println(solution(bridge_length, weight, truck_weights));
		System.out.println(solution(bridge_length2, weight2, truck_weights2));
		System.out.println(solution(bridge_length3, weight3, truck_weights3));
	}
}
