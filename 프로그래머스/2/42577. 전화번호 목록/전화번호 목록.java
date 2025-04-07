import java.util.*;



class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        
        boolean answer = solve(phone_book);
        
        return answer;
    }
    
    static boolean solve(String[] phone_book) {
        Set<String> prefix = new HashSet<>();

		for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
		}
		return true;
    }
}