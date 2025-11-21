import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

	static List<Node>[] graph;
	static boolean[] visited;
	static int[] distance;

	static class Node implements Comparable<Node> {

		int vertex;
		int cost;

		public Node (int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}

		public int compareTo(Node node) {
			return this.cost - node.cost;
		}



		@Override
		public String toString() {
			return "Node = (" +
				vertex +
				", " +
				cost +
				")";
		}
	}


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		distance = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			graph[A].add(new Node(B, C));
			graph[B].add(new Node(A, C));
		}

		dijkstra(1, N);

		System.out.println(distance[N]);

	}

	static void dijkstra(int start, int N) {

		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.offer(new Node(start, 0));
		distance[start] = 0;

		while(!pq.isEmpty()) {

			Node now = pq.poll();
			int nowV = now.vertex;

			if (!visited[nowV]) {
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
		}
	}
}
