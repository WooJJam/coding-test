import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {

        return bfs(target, numbers);
    }
    
    static int bfs(int target, int[] numbers) {
        
        Queue<int[]> q = new LinkedList<int[]>();
        
        q.offer(new int[]{numbers[0], 1});
        q.offer(new int[]{numbers[0] * -1, 1});
        
        while(!q.isEmpty()) {
            
            int[] cur = q.poll();
            int pos = cur[0]; // 4
            int count = cur[1]; // 1
            
            if (count == numbers.length) {
                if (pos == target) {
                    answer += 1;
                }
            } else {
                q.offer(new int[]{pos + numbers[count], count + 1});
                q.offer(new int[]{pos - numbers[count], count + 1 });
                }
        }
        
        return answer;
    }
}