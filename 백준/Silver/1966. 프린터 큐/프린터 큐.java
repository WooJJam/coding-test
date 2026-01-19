import java.io.*;
import java.util.*;

import org.w3c.dom.Node;

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
		Deque<Node> dq = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			pq.offer(weight[i]);
			dq.add(new Node(i, weight[i]));
		}

		// System.out.println(dq);

		int answer = 1;
		boolean flag = false;
		while (!pq.isEmpty()) {
			int num = pq.poll();

			while(!dq.isEmpty()) {
				Node node = dq.pollFirst();
				int index = node.index;
				int value = node.value;

				// System.out.printf("num = %d\n", num);
				// System.out.printf("index = %d, value = %d\n", index, value);

				if (num == value) {
					if (index == M) {
						flag = true;
					}
					break;
				} else {
					dq.addLast(node);
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

		// @Override
		// public int compareTo(Node n) {
		// 	// if (n.value == this.value) {
		// 	// 	return this.index - n.index;
		// 	// }
		// 	return n.value - this.value;
		// }

		@Override
		public String toString() {
			return "Node{" +
				"index=" + index +
				", value=" + value +
				'}';
		}
	}
}

/*
1
6 3
1 1 9 1 1 1
-- > 2

deque = 1, 1, 9, 1, 1, 1
pq = 9, 1, 1, 1, 1, 1

가중치 == 9
(2,9) (3,1) (4,1) (5,1), (0,1), (1,1)

가중치 == 1
(3,1) (4,1) (5,1), (0,1), (1,1)
 */
