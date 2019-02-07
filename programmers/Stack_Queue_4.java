import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
public class Stack_Queue_4 {
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        for(int i = 0; i < progresses.length; i++) {
            queue.add((100 - progresses[i]) % speeds[i] == 0 ? (100 - progresses[i]) / speeds[i]
                    : (100 - progresses[i]) / speeds[i] + 1
            );
        }
        List<Integer> result = new ArrayList<>();
        int standard = queue.poll();
        int cnt = 1;
        while(!queue.isEmpty()) {
            int num = queue.poll();
            if(standard >= num) {
                cnt++;
            } else {
                result.add(cnt);
                cnt = 1;
                standard = num;
            }
        }
        result.add(cnt);
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    public static void main(String[] args) {
    	int []progresses = {93, 30, 55};
    	int []speeds = {1, 30, 5};
    	System.out.println(solution(progresses, speeds));
    }
}