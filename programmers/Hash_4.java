import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Hash_4 {
	public static int[] solution(String[] genres, int[] plays) {

		int[] answer = new int[genres.length-1]; ;
		int var;
		int i = 0;

		Map<String, Integer> map = new HashMap<>(); // name, 총시간 values
		Map<Integer, Integer> result = new HashMap<>(); // 번호, 각 시간 values
		Map<Integer, String> num = new HashMap<>(); // 각 시간, name key

		for (String gen : genres) {
			if (map.get(gen) == null) {
				var = plays[i];
				map.put(gen, var);
				result.put(i, plays[i]);
				num.put(plays[i], gen);
				i++;
			} else {
				var = map.get(gen) + plays[i];
				map.put(gen, var);
				result.put(i, plays[i]);
				num.put(plays[i], gen);
				i++;
			}
		}

		Iterator tm = sortByValue(map).iterator();
		Iterator tm2 = sortByValue(result).iterator();
		TreeMap<Integer, String> iterator = new TreeMap<Integer, String>(num);
		Iterator<Integer> tm3 = iterator.descendingKeySet().iterator();
		int e = 0;
		int v = map.size();
		
		while (tm.hasNext()) {
			String one = (String) tm.next();// pop, classic
			while (tm3.hasNext()) {
				Integer two = (Integer) tm3.next(); // 2500, 800, 600, 500
				String five = (String) num.get(two); // pop, classic, pop classic
				Integer three = (Integer) tm2.next(); // 4 3 1 0 2 정
				Integer six = (Integer) result.get(three); // 2500 800 600 500 150
				if (five.equals(one)) {
					answer[e] = three;
					e++;
				}
				else {
					if(v >= genres.length-1)
						break;
					answer[v] = three;
					v++;
				}
			}
		}
		for(int r = 0; r < genres.length-1; r++) {
		}

		return answer;

	}

	public static ArrayList<String> sortByValue(final Map map) {

		ArrayList<String> list = new ArrayList<>();
		list.addAll(map.keySet());

		Collections.sort(list, new Comparator() {

			public int compare(Object o1, Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);

				return ((Comparable) v2).compareTo(v1);
			}

		});
		return list;
	}

	public static void main(String[] args) {
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };

		System.out.println(Arrays.toString(solution(genres, plays)));

	}
}
