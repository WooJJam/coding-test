import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import org.w3c.dom.Node;

public class Main {

	private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	private static boolean[] visited;
	private static int[] dist;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		visited = new boolean[N + 1];
		dist = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int ai = Integer.parseInt(st.nextToken());
			int bi = Integer.parseInt(st.nextToken());

			graph.get(ai).add(bi);
			graph.get(bi).add(ai);

		}

		for (int i = 0; i < N + 1; i++) {
			graph.get(i).sort(Comparator.naturalOrder());
		}

		// for (int i = 0; i < N + 1; i++) {
		// 	System.out.println(graph.get(i));
		// }

		bfs(1);

	}

	/*
	queue = (vertex, distance)
	 */
	private static void bfs(int start) {

		int maxDist = 0;
		int count = 1;
		int minV = 1;

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);

		while (!queue.isEmpty()) {

			// System.out.println("queue = " + queue);

			int now = queue.poll();

			visited[now] = true;
			if (dist[now] > maxDist) {
				maxDist = dist[now];
				count = 1;
				minV = now;
			} else if (dist[now] == maxDist) {
				count += 1;
				minV = Math.min(minV, now);
			}

			for (int i = 0; i < graph.get(now).size(); i++) {
				int next = graph.get(now).get(i);

				if (!visited[next]) {
					// System.out.println("next = " + next);
					visited[next] = true;
					queue.offer(next);
					dist[next] = dist[now] + 1;
				}
			}
		}

		System.out.printf("%d %d %d", minV, maxDist, count);
	}
}
