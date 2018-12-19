import java.util.HashMap;
import java.util.Map;

public class Hash_3 {
	public static int solution(String[][] clothes) {
		int answer = 0;
		int var;
		int result = 1;

		Map<String, Integer> map = new HashMap<>();

		for (String[] name : clothes) {
				if (map.get(name[1]) == null)
					map.put(name[1], 1);
				else {
					var = map.get(name[1]) + 1;
					map.put(name[1], var);
				}
		}
		
		for(String name : map.keySet()) {
			result += result*map.get(name);
		}
		answer = result-1;
		
		return answer;
	}

	public static void main(String[] args) {
		String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

		System.out.println(solution(clothes));
		System.out.println(solution(clothes2));
	}

}
