import java.util.*;

class Solution {
    
    static Map<Integer, Integer> in = new HashMap<>();
    static Map<Integer, Integer> out = new HashMap<>();
    
    public int[] solution(int[][] edges) {
        int[] answer = {};
        
        initEdges(edges);
        return solve();
        
    }
    
    static void initEdges(int[][] edges) {
        
        for(int[] edge: edges) {
            int start = edge[0];
            int end = edge[1];
            out.put(start, out.getOrDefault(start, 0) + 1);
            in.put(end, in.getOrDefault(end, 0) + 1);
        }
    }
    
    static int[] solve() {
        
        int[] answer = new int[4];
        
        for(Map.Entry<Integer, Integer> entry: out.entrySet()) {
            if(entry.getValue() > 1) { // 나가는 간선이 2개 이상이면 8자 그래프 or 새로 생성한 정점
                if(!in.containsKey(entry.getKey())) {
                    answer[0] = entry.getKey();
                }
                else { // 나가는 간선 2개 + 들어오는 간선 2개 -> 8자 그래프
                    answer[3] += 1;
                }
            }
        }
        
        for(Map.Entry<Integer, Integer> entry: in.entrySet()) {
            if(entry.getValue() > 0) {
                if(!out.containsKey(entry.getKey())) {
                    answer[2] += 1;
                }
            }
        }
        
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];
        
        return answer;
    }
}