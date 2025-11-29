import java.util.*;
import java.io.*;

public class Main {

	static class Node implements Comparable<Node> {

		int vertex;
		int cost;

		public Node(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}

		public int compareTo(Node n) {
			return this.cost - n.cost;
		}
	}

	static ArrayList<Node>[] graph;
	static int[] distance;

	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		graph = new ArrayList[N + 1];
		distance = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[s].add(new Node(e, c));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		dijkstra(N, start, end);

	}

	static void dijkstra(int N, int start, int end) {

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(start, 0));
		distance[start] = 0;

		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int nowV = now.vertex;
			int nowC = now.cost;

			if (distance[nowV] < nowC) {
				continue;
			}

			for (Node next : graph[nowV]) {
				int nextV = next.vertex;
				int nextC = next.cost;

				if (distance[nextV] > nowC + nextC) {
					distance[nextV] = nowC + nextC;
					pq.offer(new Node(nextV, distance[nextV]));
				}
			}
		}

		System.out.println(distance[end]);
	}
}
