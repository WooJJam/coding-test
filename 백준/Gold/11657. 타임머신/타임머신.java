import java.io.*;
import java.util.*;

public class Main {

	static List<Node> graph;
	static int MAX = (int)1e9;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		graph = new ArrayList<>();

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			graph.add(new Node(A, B, C));
		}

		bellman_ford(N, M);
	}

	static void bellman_ford(int N, int M) {
		int start = 1;
		long[] distinct = init_distinct(N);
		distinct[start] = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				Node node = graph.get(j);
				int in = node.in;
				int out = node.out;
				int cost = node.cost;
				long D = distinct[in] + cost;

				if (distinct[in] != MAX && distinct[out] > D) {
					distinct[out] = D;
					if (i == N) {
						System.out.println(-1);
						return;
					}
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			System.out.println(distinct[i] != MAX ? distinct[i] : -1);
		}
	}

	static long[] init_distinct(int N) {
		long[] distinct = new long[N + 1];

		for (int i = 0; i <= N; i++) {
			distinct[i] = MAX;
		}

		return distinct;
	}

	static class Node {
		int in;
		int out;
		int cost;

		public Node(final int in, final int out, final int cost) {
			this.in = in;
			this.out = out;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node{" +
				"in=" + in +
				", out=" + out +
				", cost=" + cost +
				'}';
		}
	}
}
