import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> answer = solve(arr);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static Stack<Integer> solve(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }
        
        return stack;
    }
}