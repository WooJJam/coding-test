import java.io.*;
import java.util.*;

public class Main {

	static int[][] graph;
	static boolean[][] visited;
	static int[][] distance;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int cost;

		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		public Node(final int x, final int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node n) {
			return this.cost - n.cost;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		graph = new int[N][N];
		visited = new boolean[N][N];
		distance = new int[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			Arrays.fill(distance[i], Integer.MAX_VALUE);

			for (int j = 0; j < N; j++) {
				char c = line.charAt(j);
				if (c == '1') {
					graph[i][j] = 0;
				} else {
					graph[i][j] = 1;
				}
			}
		}

		// dijkstra(N, 0, 0);
		zeroOneBfs(N, 0, 0);

	}

	private static void zeroOneBfs(int N, int sx, int sy) {
		ArrayDeque<Node> dq = new ArrayDeque<>();

		dq.offerFirst(new Node(sx, sy));
		distance[sx][sy] = 0;

		while (!dq.isEmpty()) {

			Node now = dq.pollFirst();
			int nowX = now.x;
			int nowY = now.y;

			if (visited[nowX][nowY]) {
				continue;
			}

			visited[nowX][nowY] = true;

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (0 > nextX || 0 > nextY || nextX >= N || nextY >= N || visited[nextX][nextY]) {
					continue;
				}

				if (distance[nextX][nextY] > distance[nowX][nowY] + graph[nextX][nextY]) {
					distance[nextX][nextY] = distance[nowX][nowY] + graph[nextX][nextY];

					if (graph[nextX][nextY] == 0) {
						dq.offerFirst(new Node(nextX, nextY));
					} else {
						dq.offerLast(new Node(nextX, nextY));
					}
				}
			}
		}

		System.out.println(distance[N-1][N-1]);
	}
}
