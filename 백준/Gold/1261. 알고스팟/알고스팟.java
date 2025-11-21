import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

	static int[][] miro;
	static int[][] distance;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	static class Node implements Comparable<Node> {
		int i;
		int j;
		int c;

		@Override
		public int compareTo(Node node) {
			return this.c - node.c;
		}

		public Node(int i, int j, int c) {
			this.i = i;
			this.j = j;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		miro = new int[M][N];
		distance = new int[M][N];
		visited = new boolean[M][N];

		for(int i = 0; i < M; i++) {
			String line = br.readLine();
			Arrays.fill(distance[i], Integer.MAX_VALUE);

			for(int j = 0; j < N; j++) {
				miro[i][j] = line.charAt(j) - '0';
			}
		}

		dijkstra(N, M);
	}

	static void dijkstra(int N, int M) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();

		pq.offer(new Node(0, 0, 0));
		distance[0][0] = 0;

		while(!pq.isEmpty()) {

			Node now = pq.poll();
			int nowI = now.i;
			int nowJ = now.j;

			if (visited[nowI][nowJ]) {
				continue;
			}

			visited[nowI][nowJ] = true;

			for (int i = 0; i < 4; i++) {
				int nextX = dx[i] + nowI;
				int nextY = dy[i] + nowJ;

				if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N && !visited[nextX][nextY]) {
					if (miro[nextX][nextY] == 1) {
						if (distance[nextX][nextY] > distance[nowI][nowJ] + 1) {
							distance[nextX][nextY] = distance[nowI][nowJ] + 1;
							pq.offer(new Node(nextX, nextY, distance[nextX][nextY]));
						}
					} else {
						distance[nextX][nextY] = distance[nowI][nowJ];
					}

					pq.offer(new Node(nextX, nextY, distance[nextX][nextY]));
				}
			}
		}

		System.out.println(distance[M-1][N-1]);
	}
}
