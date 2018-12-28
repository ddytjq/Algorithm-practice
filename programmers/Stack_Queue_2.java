import java.util.LinkedList;
import java.util.Queue;

public class Stack_Queue_2 {
	public static int solution(int[] priorities, int location) {

		Queue<Integer> queue = new LinkedList<>();
		int count = location;

		for (int i : priorities)
			queue.offer(i);

		while (!queue.isEmpty()) {
			int result = queue.poll();
			boolean check = false;
			for (int i : queue) {
				if (result < i) {
					check = true;
				}
			}
			
			if (check) {
				queue.offer(result);
				count--;
				if(count<0) count += priorities.length;
			}
		}
		return count+1;
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
