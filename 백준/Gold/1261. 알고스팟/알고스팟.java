import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int[][] miro;
	static int[][] distance;

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	static class Node {
		int i;
		int j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
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

		for (int i = 0; i < M; i++) {
			String line = br.readLine();
			Arrays.fill(distance[i], Integer.MAX_VALUE);

			for (int j = 0; j < N; j++) {
				miro[i][j] = line.charAt(j) - '0';
			}
		}

		zeroOneBfs(N, M);

	}

	static void zeroOneBfs(int N, int M) {
		Deque<Node> dq = new ArrayDeque<Node>();

		dq.addFirst(new Node(0, 0));
		distance[0][0] = 0;

		while (!dq.isEmpty()) {

			Node now = dq.pollFirst();
			int nowI = now.i;
			int nowJ = now.j;

			for (int i = 0; i < 4; i++) {
				int nextX = nowI + dx[i];
				int nextY = nowJ + dy[i];

				if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N) {
					if (miro[nextX][nextY] == 1 && distance[nextX][nextY] > distance[nowI][nowJ] + 1) {
						distance[nextX][nextY] = distance[nowI][nowJ] + 1;
						dq.addLast(new Node(nextX, nextY));
					}

					if (miro[nextX][nextY] == 0 && distance[nextX][nextY] > distance[nowI][nowJ]) {
						distance[nextX][nextY] = distance[nowI][nowJ];
						dq.addFirst(new Node(nextX, nextY));
					}
				}
			}
		}

		System.out.println(distance[M - 1][N - 1]);
	}

	// static void dijkstra(int N, int M) {
	// 	PriorityQueue<Node> pq = new PriorityQueue<Node>();
	//
	// 	pq.offer(new Node(0, 0, 0));
	// 	distance[0][0] = 0;
	//
	// 	while (!pq.isEmpty()) {
	//
	// 		Node now = pq.poll();
	// 		int nowI = now.i;
	// 		int nowJ = now.j;
	// 		int nowC = now.c;
	//
	// 		if (distance[nowI][nowJ] < nowC) {
	// 			continue;
	// 		}
	//
	// 		for (int i = 0; i < 4; i++) {
	// 			int nextX = dx[i] + nowI;
	// 			int nextY = dy[i] + nowJ;
	//
	// 			if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N) {
	// 				if (distance[nextX][nextY] > distance[nowI][nowJ] + miro[nextX][nextY]) {
	// 					distance[nextX][nextY] = distance[nowI][nowJ] + miro[nextX][nextY];
	// 					pq.offer(new Node(nextX, nextY, distance[nextX][nextY]));
	// 				}
	// 			}
	// 		}
	// 	}
	// 	System.out.println(distance[M - 1][N - 1]);
	// }
}
