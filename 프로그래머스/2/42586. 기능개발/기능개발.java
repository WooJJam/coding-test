import java.util.*;

class Solution {
    public List<?> solution(int[] progresses, int[] speeds) {
        
        List<Integer> answer = solve(progresses, speeds);
        return answer;
    }
    
    static List<Integer> solve(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue_speed = new LinkedList<>();
        int count = 0;
        List<Integer> answer = new ArrayList<Integer>();
        
        for(int i = 0; i < progresses.length; i++) {
            queue.offer(progresses[i]);
            queue_speed.offer(speeds[i]);
        }
        
        while(queue.size() > 0) {
            progressJob(progresses, queue, queue_speed); // progress 와 speed를 더한 값을 queue에 담기
            
            if(queue.peek() >= 100) {
                count = deploy(queue, queue_speed);
                answer.add(count);
            }
        }
        
        return answer;
    }
    
    static void progressJob(int[] progresses, Queue<Integer> queue, Queue<Integer> queue_speed) {
        for(int i = 0; i < queue.size(); i++) {
            int progress = queue.poll();
            int speed = queue_speed.poll();
            progress += speed;
            queue.offer(progress);
            queue_speed.offer(speed);
        }
        
    }
    
    static int deploy(Queue<Integer> queue, Queue<Integer> queue_speed) {
        int count = 0;
        int size = queue.size();
        for(int i = 0; i < size; i++) {
            if(queue.peek() >= 100) {
                queue.poll();
                queue_speed.poll();
                count += 1;
            } else {
                break;
            }
        }
        
        return count;
    }
    
    static void print(Object o) {
        System.out.println(o);
    }
    
}

// progresses = 93, 30, 55;
// speeds = 1, 30, 5;

// progresses를 Queue에 담자. -> Queue
//     93, 30, 55 -> 94, 60, 60 -> 95, 90, 65, -> 96, 120, 70 ... -> 100, X, 90
    
//     peek의 수가 100이상인지 검증한다.
//     크다면 pop하고, count를 증가시킨다.
//     총 count수를 answer에 추가한다.
//         if peek >= 100:
//             queue.pop
        
    