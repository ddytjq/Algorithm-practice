import java.util.*;

public class Heap_2 {
    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int day = stock;
        int index = 0;

        Queue queue = new PriorityQueue<Integer>(Collections.reverseOrder());

        while(day < k){
            for(int i = index; i < dates.length; i++){
                if(dates[i] <= day){
                    queue.offer(supplies[i]);
                    index = i + 1;
                }
            }
            day += (int) queue.poll();
            answer++;
        }
        return answer ;
    }

    public static void main(String[] args) {

        int stock = 4;
        int[] dates = {4, 10, 15};
        int[] supplies = {20, 5, 10};
        int k = 30;

        System.out.println(solution(stock, dates, supplies, k));
    }
}
