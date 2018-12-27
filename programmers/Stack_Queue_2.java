import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Stack_Queue_2 {
	public static int solution(int[] priorities, int location) {
		int answer = 0;
		int count = 0;
		int num = 1;
		Map<Integer, Integer> map;
		Queue<Map<Integer, Integer>> que1 = new LinkedList();
		Queue<Integer> que2 = new LinkedList();

		for (int i : priorities) {
			map = new HashMap<>();
			map.put(num, i);
			que2.offer(i);
			que1.offer(map);
			num++;
		}

		num = 1;

		for (int j = 0; j < priorities.length; j++) {
			int result = que2.poll();
			count = 0;
			for (int k = 0; k < priorities.length - 1; k++) {
				int temp = que2.poll();
				if (result < temp) {
					count++;
					que2.offer(temp);
				} else {
					que2.offer(temp);
				}
			}
			if (count == 0) {
				break;
			}
			map = new HashMap<>();
			map.put(num, result);
			que1.poll();
			que1.offer(map);
			num++;
			que2.offer(result);
		}

		int result = 0;
		
		for (int a = 0; a < priorities.length; a++) {
			Set<Integer> set = que1.remove().keySet();
			Iterator<Integer> num1 = set.iterator();
			result++;
			if (num1.next() == location + 1) {
				answer = result;
				break;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] priorities = { 2, 1, 3, 2 };
		int location = 2;
		int[] priorities2 = { 1, 1, 9, 1, 1, 1 };
		int location2 = 0;

		System.out.println(solution(priorities, location));
		System.out.println(solution(priorities2, location2));
	}
}
