import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        return solve(clothes);
    }
    
    static int solve(String[][] clothes) {

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < clothes.length; i++) {
            Integer value = map.getOrDefault(clothes[i][1], 1);
            System.out.println(clothes[i][0] + " " + clothes[i][1] + " " + value);
			map.put(clothes[i][1], value + 1);
		}
        
        System.out.println(map);

		int answer = 1;
		for (String key : map.keySet()) {
			answer *= map.get(key);
		}
		
		return answer - 1;

	}
}