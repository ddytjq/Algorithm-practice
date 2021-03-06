import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hash_1 {
	
	public static String solution2(String[] participant, String[] completion) {
		
		String answer = "";
		
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		answer = participant[participant.length-1];
		
		for(int i = 0; i < completion.length; i++) {
			if(participant[i] != completion[i]) 
				answer = participant[i];
		}
		return answer;
	}
	
	public static String solution(String[] participant, String[] completion) {
		
		String answer = "";

		Map<String, Integer> result = new HashMap<>();
		
		for (String part : participant) {
			if(result.get(part)==null) {
				result.put(part, 1);
			}
			else
				result.put(part, result.get(part)+1);
		}

		for (String comp : completion) {
			result.put(comp, result.get(comp)-1); 
		}
		
		for(String part : participant) {
			if(result.get(part) > 0)
				answer = part;
		}
		return answer;
	}

	public static void main(String[] args) {
		
		String participant[] = { "leo", "kiki", "eden" };
		String completion[] = { "eden", "kiki" };
		String participant1[] = { "marina", "josipa", "nikola", "vinko", "filipa" };
		String completion1[] = { "josipa", "filipa", "marina", "nikola" };
		String participant2[] = { "mislav", "stanko", "mislav", "ana" };
		String completion2[] = { "stanko", "ana", "mislav" };

		System.out.println(solution(participant, completion));
		System.out.println(solution(participant1, completion1));
		System.out.println(solution(participant2, completion2));
	}
}