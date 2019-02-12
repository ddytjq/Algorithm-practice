import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Stack_Queue_4 {
	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer= {};
		Vector<Integer> vec = new Vector<Integer>();
		Queue queue = new LinkedList();
			
		for(int i = 0; i < progresses.length; i++) {
			queue.add((100-progresses[i])/speeds[i]);
		}
		
		int max = (int)queue.poll();
		int count = 1;
		while(!queue.isEmpty()) {
			if(max >= (int)queue.peek()) {
				queue.poll();
				count++;
			}
			else {
				max = (int)queue.poll();
				vec.add(count);
				count = 1;
			}
		}
		vec.add(count);
		answer = new int[vec.size()];
		for(int k = 0; k < vec.size(); k++)
			answer[k] = vec.get(k);
		return answer;
	}

	public static void main(String[] args) {
    	int []progresses = {93, 30, 55};
    	int []speeds = {1, 30, 5};
    	solution(progresses, speeds);
		for (int i = 0; i < solution(progresses, speeds).length; i++) {
			System.out.print(solution(progresses, speeds)[i]+" ");
		}
    }
}