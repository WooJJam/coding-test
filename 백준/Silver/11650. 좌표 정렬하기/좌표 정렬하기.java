import java.io.*;
import java.util.*;

public class Main {

	/*
	5
	3 4
	1 1
	1 -1
	2 2
	3 3
	 */

	static class Node {
		int x;
		int y;

		public Node(final int x, final int y) {
			this.x = x;
			this.y = y;
		}

		// @Override
		// public int compareTo(final Node n) {
		//
		// 	if (this.x == n.x) {
		// 		return Integer.compare(this.y, n.y);
		// 	}
		//
		// 	return Integer.compare(this.x, n.x);
		// }
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Node[] list = new Node[N];
		ArrayList<Node> list2 = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// list[i] = (new Node(x, y));
			list2.add(new Node(x, y));
		}

		// sorted(list, N);
		sortedV3(list2, N);
	}

	private static void sortedV3(ArrayList<Node> arr, int N) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		arr.sort((a, b) -> {
			if (a.x == b.x) {
				return Integer.compare(a.y, b.y);
			}
			return Integer.compare(a.x, b.x);
		});

		for (int i = 0; i < N; i++) {
			bw.write(arr.get(i).x + " " + arr.get(i).y);
			bw.write("\n");
		}

		bw.flush();
		bw.close();

	}
}
