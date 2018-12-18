import java.util.HashMap;
import java.util.Map;

public class Hash_1 {
	
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		Map<String, Integer> result = new HashMap<>();
		int val = 1;

		for (String part : participant) {
			if(result.containsKey(part)) {
				result.put(part, val+1);
				continue;
			}
			result.put(part, val);
		}

		for (String comp : completion) {
			val = result.get(comp);
			result.put(comp, val-1); 
		}
		
		for(String a : participant) {
			if(result.get(a) == 1)
				answer = a;
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