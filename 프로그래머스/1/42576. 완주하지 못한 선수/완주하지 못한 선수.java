import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
       
		String answer = "";
		HashMap<String, Integer> hashMap = new HashMap<>();

		for (String person : participant) {
			hashMap.put(person, hashMap.getOrDefault(person, 0) + 1);
		}

		for (String completion_person : completion) {
			hashMap.put(completion_person, hashMap.get(completion_person) - 1);
		}
        
		for (String person : participant) {
			if (hashMap.get(person) > 0) {
				answer = person;
			}
		}
        
        return answer;
    }
}