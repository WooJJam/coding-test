import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private static ArrayList<Node> nodes;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		nodes = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			nodes.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		int[] dist = new int[10_001];

		for (int i = 0; i < 10_001; i++) {
			dist[i] = i;
		}

		dynamic(N, D, dist);

	}

	private static void dynamic(int N, int D, int[] dist) {

		for (int i = 1; i <= D; i++) {
			dist[i] = Math.min(dist[i - 1] + 1, dist[i]);

			for (int j = 0; j < N; j++) {
				Node node = nodes.get(j);
				int start = node.start;
				int end = node.end;
				int cost = node.cost;

				// 현재 지점이 지름길이 있는 부분일 경우 최소값 갱신
				if (i == end) {
					// System.out.println("end = " + end + ", dist[start] = " + dist[start] + ", cost = " + cost);
					dist[end] = Math.min(dist[end], dist[start] + cost);
				}
			}
		}

		System.out.println(dist[D]);
	}

	static class Node {
		int start;
		int end;
		int cost;

		public Node(final int start, final int end, final int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}

}
