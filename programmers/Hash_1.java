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
		int val = 1;
		
		Map<String, Integer> result = new HashMap<>();
		
		for (String part : participant) {
			if(result.get(part)==null) {
				result.put(part, val);
			}
			else
				result.put(part, val+1);
		}

		for (String comp : completion) {
			val = result.get(comp);
			result.put(comp, val-1); 
		}
		
		for(String part : participant) {
			if(result.get(part) == 1)
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

		System.out.println(solution2(participant, completion));
		System.out.println(solution2(participant1, completion1));
		System.out.println(solution2(participant2, completion2));
	}
}