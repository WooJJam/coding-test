import java.util.*;

class Solution {
    
    static Map<Integer, Integer> out = new HashMap<>();
    static Map<Integer, Integer> in = new HashMap<>();
    static Set<Integer> exist = new HashSet<>();
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int fakeVertex = find_fake_vertex(edges);
        init_graph(edges, fakeVertex);
        
        answer[0] = fakeVertex;
        
        int barGraphCount = find_bar_graph(fakeVertex);
        answer[2] = barGraphCount;
        
        int eightGraphCount = find_eight_graph(fakeVertex);
        answer[3] = eightGraphCount;
        
        answer[1] = graph.get(fakeVertex).size() - barGraphCount - eightGraphCount;
        return answer;
    }
    
    private static int find_fake_vertex(int[][] edges) {
        
        set_edge(edges);
        
        int answer = 0;
        for(int[] edge: edges) {
            int vertex = edge[0];
            if (out.get(vertex) >= 2 && in.get(vertex) == null) {
                answer = vertex;
            }
        }
        
        return answer;
    }
    
    private static void set_edge(int[][] edges) {
        for(int[] edge: edges) {
            int start = edge[0];
            int end = edge[1];
            out.put(start, out.getOrDefault(start, 0) + 1);
            in.put(end, in.getOrDefault(end, 0) +1);
        }
        
    }
    
    private static void init_graph(int[][] edges, int fakeVertex) {
        
        remove_fake_vertex(edges, fakeVertex);
        int maxVertex = 0;
        
        for(int[] edge: edges) {
            maxVertex = Math.max(maxVertex, Math.max(edge[0], edge[1]));
        }
        
        for(int i = 0; i <= maxVertex; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge: edges) {
            int start = edge[0];
            int end = edge[1];
            
            graph.get(start).add(end);
            exist.add(start);
            exist.add(end);
        }
    }
    
    private static void remove_fake_vertex(int[][] edges, int fakeVertex) {
        
        for(int[] edge: edges) {
            int start = edge[0];
            int end = edge[1];
            
            if (start == fakeVertex) {
                in.put(end, in.get(end) - 1);
            }
        }
        
        // System.out.println(in);
        // System.out.println(out);
    }
    
    private static int find_bar_graph(int fakeVertex) {
        
        int count = 0;
        
        for(int i = 1; i < graph.size(); i++) {
            if (i == fakeVertex) {
                continue;
            }
            
            if (exist.contains(i) && graph.get(i).isEmpty()) {
                count += 1;
            }
        }
        
        return count;
    }
    
    private static int find_eight_graph(int fakeVertex) {
        int count = 0;
        // System.out.println(graph);
        // System.out.println(in);
        
        for(int i = 1; i < graph.size(); i++) {
            if (i == fakeVertex) {
                continue;
            }
            // && in.get(graph.get(i)) != null && in.get(graph.get(i)) == 2
            if(graph.get(i).size() == 2 && in.get(i) == 2) {
                // System.out.println(i);
                // System.out.println(graph.get(i));
                count += 1;
            }
        }
        
        return count;
    }
}