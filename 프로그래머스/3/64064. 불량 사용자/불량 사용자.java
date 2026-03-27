import java.util.*;

class Solution {
    
    static boolean[] visited;
    static HashSet<List<String>> set = new HashSet<>();
    static ArrayList<String[]> answer = new ArrayList<>();
    
    public int solution(String[] user_id, String[] banned_id) {

        String[] candidate = new String[banned_id.length];
        visited = new boolean[user_id.length];
        
        select(user_id, banned_id, 0, candidate);
        
        for(String[] str : answer) {
            Arrays.sort(str);
            set.add(Arrays.asList(str));
        }
        
        return set.size();
    }
    
    private static void select(String[] user_id, String[] banned_id, int depth, String[] candidate) {
        
        if (depth == banned_id.length) {
            if (isCheck(banned_id, candidate)) {
               answer.add(Arrays.copyOf(candidate, candidate.length));
            }
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            
            if (visited[i]) {
                continue;
            }
            
            candidate[depth] = user_id[i];
            visited[i] = true;
            select(user_id, banned_id, depth + 1, candidate);
            visited[i] = false;
        }
        
    }
    
    private static boolean isCheck(String[] banned_id, String[] candidate) {
        
        int index = 0;
        
        for(int i = 0; i < candidate.length; i++) {
            if (candidate[i].length() != banned_id[i].length()) {
                return false;
            }
            
            for (int j = 0; j < banned_id[i].length(); j++) {
                if (banned_id[i].charAt(j) == '*') {
                    continue;
                }
                
                if (banned_id[i].charAt(j) != candidate[i].charAt(j)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private static void print(int size, String[] candidate) {
        
        for (int i = 0; i < size; i++) {
            System.out.printf("%s ", candidate[i]);
        }
        System.out.println();
    }
}
