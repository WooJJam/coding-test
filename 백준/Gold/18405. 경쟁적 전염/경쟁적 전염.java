import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int virus;
		int timer;

		public Node(final int x, final int y, final int virus, final int timer) {
			this.x = x;
			this.y = y;
			this.virus = virus;
			this.timer = timer;
		}

		@Override
		public int compareTo(final Node n) {
			// if (this.timer != n.timer) {
			// 	return this.timer - n.timer;
			// }

			return this.virus - n.virus;
		}

		@Override
		public String toString() {
			return "Node{" +
				"timer=" + timer +
				", x=" + x +
				", y=" + y +
				", virus=" + virus +
				'}';
		}
	}

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static Queue<Node> q = new LinkedList<>();


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] room = new int[N][N];
		ArrayList<Node> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				int virus = Integer.parseInt(st.nextToken());
				room[i][j] = virus;

				if (virus != 0) {
					// pq.offer(new Node(i, j, virus, 0));
					list.add(new Node(i, j, virus, 0));
					// q.offer(new Node(i, j, virus, 0));
				}
			}
		}

		list.sort(
			Comparator.comparingInt((Node n) -> n.virus)
		);

		for(Node n : list) {
			q.offer(n);
		}

		st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken()); // S초 뒤에
		int X = Integer.parseInt(st.nextToken()); // X 좌표
		int Y = Integer.parseInt(st.nextToken()); // Y 좌표

		bfs_q(N, room, S, X, Y);

	}

	// private static void bfs_pq(int N, int[][] room, int S, int X, int Y) {
	//
	// 	while(!pq.isEmpty()) {
	// 		Node cur = pq.poll();
	// 		// System.out.println("cur = " + cur);
	//
	// 		if (cur.timer >= S) {
	// 			break;
	// 		}
	//
	// 		for (int i = 0; i < 4; i++) {
	// 			int nextX = dx[i] + cur.x;
	// 			int nextY = dy[i] + cur.y;
	//
	// 			if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N && room[nextX][nextY] == 0) {
	// 				room[nextX][nextY] = cur.virus;
	// 				pq.offer(new Node(nextX, nextY, cur.virus, cur.timer + 1));
	// 			}
	//
	// 		}
	// 	}
	//
	// 	System.out.println(room[X-1][Y-1]);
	// }

	private static void bfs_q(int N, int[][] room, int S, int X, int Y) {

		while(!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.timer >= S) {
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = dx[i] + cur.x;
				int nextY = dy[i] + cur.y;

				if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N && room[nextX][nextY] == 0) {
					room[nextX][nextY] = cur.virus;
					q.offer(new Node(nextX, nextY, cur.virus, cur.timer + 1));
				}

			}
		}

		System.out.println(room[X-1][Y-1]);

	}
}

/*
3 3
1 0 2
0 0 0
3 0 0
2 1 1
 */
