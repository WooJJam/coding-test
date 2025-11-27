import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] distance;
	static ArrayList<Node>[] graph;
	static final int MAX_VALUE = 200_000 * 1_000;

	static class Node implements Comparable<Node>{
		int v;
		int c;

		public Node(int v, int c) {
			this.v = v;
			this.c = c;
		}

		@Override
		public int compareTo(Node n) {
			return this.c - n.c;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		distance = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
			distance[i] = MAX_VALUE;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine());
		int u = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		// 경로 1 번: 1 -> u -> v -> N
		int firstWay = dijkstra(N, 1, u) + dijkstra(N, u, v) + dijkstra(N, v, N);

		// 경로 2번: 1 -> v -> u -> N
		int secondWay = dijkstra(N, 1, v) + dijkstra(N, v, u) + dijkstra(N, u, N);

		if (firstWay >= MAX_VALUE && secondWay >= MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(Math.min(firstWay, secondWay));
		}


	}

	static int dijkstra(int N, int start, int end) {

		boolean[] visited = new boolean[N + 1];
		Arrays.fill(distance, MAX_VALUE);

		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.offer(new Node(start, 0));
		distance[start] = 0;

		while(!pq.isEmpty()) {

			Node now = pq.poll();
			int nowV = now.v;

			if (visited[nowV]) {
				continue;
			}

			if (nowV == end) {
				break;
			}
			visited[nowV] = true;

			for (Node next: graph[nowV]) {

				if(!visited[next.v] && distance[nowV] + next.c < distance[next.v]) {
					distance[next.v] = distance[nowV] + next.c;
					pq.offer(new Node(next.v, distance[next.v]));
				}
			}
		}

		return distance[end];
	}
}
