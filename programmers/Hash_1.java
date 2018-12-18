import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hash_1 {

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		int val = 0;

		Map<String, Integer> result = new HashMap<>();

		for (String part : participant) {
			result.put(part, val);

			System.out.println("1.part : "+result.get(val));
			val += 1;
		}

		for (String comp : completion) {
			val -= 1;
			result.put(comp, val);
			System.out.println("2.comp : "+result.get(val));
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