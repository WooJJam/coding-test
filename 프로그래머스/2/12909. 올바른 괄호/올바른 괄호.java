import java.util.*;

class Solution {
    boolean solution(String s) {
        
        char[] arrays = s.toCharArray();
        
        boolean answer = solve(arrays);
        
        return answer;
    }
    
    static void print(Object s) {
        System.out.println(s);
    }
    
    static boolean solve(char[] arrays) {
        
        Stack<Character> stack = new Stack<Character>();
        
        for(char c : arrays) {
            if (c == '(') {
                stack.push(c);
            }
            
            if (c == ')') {
                if (stack.size() > 0) {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        
        return !(stack.size() > 0);
    }
}