/*
1. 시간을 sec 단위로 변환

15:00 -> 90,000
17:00 -> 102,000

2. 시작 시간 순서로 정렬

int time[60*24]

1: 14:10 ~ 19:30
2: 14:20 ~ 15:30, 16:40 ~ 18:30
3. 15:00 ~ 17:10, 18:20 ~ 21:40

*/

import java.util.*;

class Solution {
    
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static boolean[][] time = new boolean[1000][24 * 60 + 10];
    
    static class Node implements Comparable<Node> {
        int startTime;
        int endTime;
        
        public Node(final int startTime, final int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
        
        @Override
        public int compareTo(final Node n) {
            // if (this.endTime == n.endTime) {
            //     return this.endTime - n.endTime;
            // }
            
            return this.startTime - n.startTime;
        }
    }
    
    public int solution(String[][] book_time) {
        makeQueue(book_time);
        return solve();
    }
    
    private static void makeQueue(String[][] book_times) {
        
        for(String[] book_time : book_times) {
            String start = book_time[0];
            String end = book_time[1];
            
            String[] s = start.split(":");
            String[] e = end.split(":");
            
            int startTime = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
            int endTime = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]);
            
            pq.add(new Node(startTime, endTime + 10));
        }
    }
    
    private static int solve() {
        
        int answer = 0;
        
        while(!pq.isEmpty()) {
            Node reservation = pq.poll();
            int startTime = reservation.startTime;
            int endTime = reservation.endTime;
            int room = 0;
            
            for(int i = 0; i < 1000; i++) {
                if(!time[i][startTime]) { // 해당 시간대 예약가능
                    room = i;
                    break;
                }
            }
            
            for(int i = startTime; i < endTime; i++) {
                time[room][i] = true;
            }
            
            answer = Math.max(answer, room);
        }
        
       return answer + 1;
    }
}