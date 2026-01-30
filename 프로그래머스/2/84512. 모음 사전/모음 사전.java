/*
alp = {A, E, I, O, U, ''}

depth == 5
A:1
AA:2
AAA:3
AAAA:4
AAAAA:5
AAAAE:6
AAAAI:7
AAAAO:8
AAAAU:9
AAAE:10

*/

import java.util.*;

class Solution {
    
    static String[] alp = new String[]{"A", "E", "I", "O", "U", ""};
    static int count = 0;
    static boolean flag = false;
    static Map<String, Boolean> visited = new HashMap<>();
    
    public int solution(String word) {
        dfs(0, word, "");
        int answer = count;
        return answer - 1;
    }
    
    private static void dfs(int depth, String target, String word) {
        
        visited.put(word, true);
        // System.out.println(word);
        count++;
        
        if (word.equals(target)) {
            flag = true;
            return;
        }
        
//          if (flag) {
//                 return;
//             }
        
        if (depth == 5) {
            return;
        }
        
        for(int i = 0; i < 6; i++) {
            
            if (flag) {
                return;
            }
            
            if (!visited.containsKey(word + alp[i])) {
                dfs(depth + 1, target, word + alp[i]);
            }
        }
    }
}