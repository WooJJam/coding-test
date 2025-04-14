import java.util.*;

class Solution {
    
    static ArrayList<Node>[] graph;
    
    public int solution(int n, int[][] edge) {
        
        int[] dist = new int[n+1];

		graph = new ArrayList[n+1];

		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < edge.length; i++) {
			graph[edge[i][0]].add(new Node(edge[i][1], 1));
			graph[edge[i][1]].add(new Node(edge[i][0], 1));
		}

		return dijkstra(1, dist);
    }
    
    static int dijkstra(int start, int[] dist) {
		PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));

		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int vertex = now.v; // 정점
			int cost = now.cost; // 비용

			if (dist[vertex] < cost) {
				continue;
			}

			for (Node next : graph[vertex]) {
				if (dist[next.v] > dist[vertex] + next.cost) {
					dist[next.v] = dist[vertex] + next.cost;

					pq.offer(new Node(next.v, dist[next.v]));
				}
			}
		}

		int max = Arrays.stream(dist)
            .filter(d -> d != Integer.MAX_VALUE)
            .max().orElse(0);

        int answer = 0;
        for (int d : dist) {
	        if (d == max) answer++;
        }

		return answer;
	}

	static class Node {
		int v;
		int cost;

		public Node(final int v, final int cost) {
			this.v = v;
			this.cost = cost;
		}
	}
}