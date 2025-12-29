import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int value;
		int count;

		public Node(final int value, final int count) {
			this.value = value;
			this.count = count;
		}

		@Override
		public int compareTo(Node n) {
			if(this.count == n.count) {
				return this.value - n.value;
			}

			return this.count - n.count;
		}
	}

	static int[][] A = new int[100][100];
	static int maxR = 3;
	static int maxC = 3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 3; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(r, c, k);

	}

	private static void solve(int r, int c, int k) {

		int time = 0;

		while(time <= 100) {

			if(A[r-1][c-1] == k) {
				break;
			}

			// System.out.println("-------------------------");
			// System.out.println("maxR = " + maxR);
			// System.out.println("maxC = " + maxC);
			// System.out.println("time = " + time);
			// for (int i = 0; i < 10; i++) {
			// 	for (int j = 0; j < 10; j++) {
			// 		System.out.print(A[i][j] + ", ");
			// 	}
			// 	System.out.println();
			// }

			if (maxR >= maxC) { // R 연산
				R();
			} else {
				C();
			}

			time++;

		}

		System.out.println(time > 100 ? "-1" : time);
	}

	private static void R() {

		int[] count = new int[101];
		for (int i = 0; i < maxR; i++) {
			ArrayList<Node> list = new ArrayList<>();
			Arrays.fill(count,0);
			for (int j = 0; j < maxC; j++) {
				count[A[i][j]] += 1;
			}

			for (int j = 1; j < 101; j++) {
				if(count[j] != 0) {
					list.add(new Node(j, count[j]));
				}
			}

			Collections.sort(list);
			maxC = Math.max(maxC, list.size() * 2);

			Arrays.fill(A[i], 0);
			int index = 0;
			for(Node node: list) {
				int v = node.value;
				int c = node.count;
				A[i][index++] = v;
				A[i][index++] = c;
			}

			// for (int k = 1; k < 5; k++) {
			// 	System.out.println("count[" + k + "] = " + count[k]);
			// }
			// System.out.println("------------");
		}
	}

	private static void C() {
		int[] count = new int[101];

		for (int i = 0; i < maxC; i++) {
			ArrayList<Node> list = new ArrayList<>();
			Arrays.fill(count, 0);

			for (int j = 0; j < maxR; j++) {
				count[A[j][i]] += 1;
			}

			for (int j = 1; j < 101; j++) {
				if (count[j] != 0) {
					list.add(new Node(j, count[j]));
				}
			}

			Collections.sort(list);
			maxR = Math.max(maxR, list.size() * 2);

			int index = 0;

			for (int j = 0; j < maxR; j++) {
				A[j][i] = 0;
			}

			for (Node node : list) {
				int v = node.value;
				int c = node.count;
				A[index++][i] = v;
				A[index++][i] = c;
			}
		}
	}

}
