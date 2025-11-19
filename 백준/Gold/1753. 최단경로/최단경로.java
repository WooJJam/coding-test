import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static List<Node>[] graph;
	static int[] distance;

	static class Node implements Comparable<Node> {
		int vertex;
		int cost;

		public Node(final int vertex, final int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}

		@Override
		public int compareTo(final Node o) {
			return this.cost - o.cost;
		}

		@Override
		public String toString() {
			return "Node{" +
				"cost=" + cost +
				", vertex=" + vertex +
				'}';
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int start = Integer.parseInt(br.readLine());

		graph = new ArrayList[V + 1];
		distance = new int[V + 1];

		for (int i = 0; i <= V; i++) {
			graph[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u].add(new Node(v, w));
		}

		dijkstra(V, start);

	}

	static void dijkstra(int V, int start) {

		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V + 1];
		distance[start] = 0;

		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			int nowC = now.cost;
			int nowV = now.vertex;

			if (visited[nowV]) {
				continue;
			}

			visited[nowV] = true;

			for (Node next : graph[nowV]) {
				int nextV = next.vertex;
				int nextC = next.cost;

				if (!visited[nextV] && distance[nowV] + nextC < distance[nextV]) {
					distance[nextV] = distance[nowV] + nextC;
					pq.offer(new Node(nextV, distance[nextV]));
				}
			}

		}

		for (int i = 1; i < V + 1; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(distance[i]);
			}
		}
	}
}

