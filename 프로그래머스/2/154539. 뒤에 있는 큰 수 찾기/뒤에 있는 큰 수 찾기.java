import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Arrays.fill(answer, -1);
        
        solve(numbers, answer);
        return answer;
    }
    
    static void solve(int[] numbers, int[] answer) {
        Stack<Integer> stack = new Stack<>();
        
        stack.push(0);
        
        for (int i = 1; i < numbers.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }
            
            if (numbers[stack.peek()] >= numbers[i]) { // 현재 수보다 크다면 pass
                stack.push(i);
                continue;
            }
            
            // 현재 수보다 stack이 작다면 뒤 큰 수임
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int index = stack.pop();
                answer[index] = numbers[i];
            }
            
            stack.push(i);
        }
    }
}