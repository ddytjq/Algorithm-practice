import java.util.LinkedList;
import java.util.Queue;

public class Heap_1 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        Queue queue = new LinkedList();

        for (int sco : scoville) {
            if (sco < K)
                queue.add(sco);
        }

        while(!queue.isEmpty()){
            if(queue.size() > 1){
                int value = (int) queue.poll() + ((int) queue.poll() * 2);
                if (value < K) {
                    queue.add(value);
                }
                answer++;
            }
            else {
                if((int)queue.poll() < K)
                    answer = -1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(solution(scoville, K));
    }

}
