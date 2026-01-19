import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] weight = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				weight[j] = Integer.parseInt(st.nextToken());
			}

			solve(N, M, weight);
		}

	}

	private static void solve(int N, int M, int[] weight) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

		Queue<Node> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			pq.offer(weight[i]);
			q.add(new Node(i, weight[i]));
		}

		int answer = 1;
		boolean flag = false;

		while (!pq.isEmpty()) {
			int num = pq.poll();

			while(!q.isEmpty()) {
				Node node = q.poll();
				int index = node.index;
				int value = node.value;

				if (num == value) {
					if (index == M) {
						flag = true;
					}
					break;
				} else {
					q.add(node);
				}

			}

			if (flag) {
				System.out.println(answer);
				break;
			}

			answer ++;
		}
	}

	static class Node {
		int index;
		int value;

		public Node(final int index, final int value) {
			this.index = index;
			this.value = value;
		}

	}
}
