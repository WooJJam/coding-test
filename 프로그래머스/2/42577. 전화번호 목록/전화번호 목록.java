import java.util.*;



class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book, new LengthComparator());
        
        boolean answer = solve(phone_book);
        
        return answer;
    }
    
    static boolean solve(String[] phone_book) {
        Set<String> prefix = new HashSet<>();

		for (String phone : phone_book) {
			StringBuilder compare = new StringBuilder();
			for (int i = 0; i < phone.length(); i++) {
				char c = phone.charAt(i);
				compare.append(c);

				if (prefix.contains(compare.toString())) {
					return false;
				}
			}
			prefix.add(compare.toString());
		}
		return true;
    }
}

class LengthComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.length() - o2.length();
	}
}