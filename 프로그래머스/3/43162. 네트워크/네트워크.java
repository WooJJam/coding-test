import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(int n, int[][] computers) {
        List<ArrayList<Integer>> graph = init_graph(computers);
		boolean[] visited = init_visited(n);

		for (int i = 0; i < n; i++) {
			if(!visited[i]) {
                System.out.println("시작 i = "+ i);
				dfs(i, visited, graph);
				answer += 1;
			}
		}
        
        System.out.println(graph);
        
        return answer;
    }
    
    static List<ArrayList<Integer>> init_graph(int computers[][]) {
		List<ArrayList<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < computers.length; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < computers.length; i++) {
			for (int j = 0; j < computers[i].length; j++) {
				if (computers[i][j] == 1 && i != j) {
					graph.get(i).add(j);
				}
			}
		}

		return graph;
	}

	static boolean[] init_visited(int n) {
		return new boolean[n];
	}

	static void dfs(int index, boolean[] visited, List<ArrayList<Integer>> graph) {

		visited[index] = true;

		for (Integer pos : graph.get(index)) {
			if (!visited[pos]) {
                System.out.println(index + 1);
                System.out.println(pos + 1);
                System.out.println();
				dfs(pos, visited, graph);
			}
		}
        
        System.out.println("index = " + index + " visited = " + visited[index]);
	}
}