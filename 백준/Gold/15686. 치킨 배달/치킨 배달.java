import java.io.*;
import java.util.*;

public class Main {

	static class Node {
		int x;
		int y;

		public Node(final int x, final int y) {
			this.x = x;
			this.y = y;
		}
	}

	static ArrayList<Node> home = new ArrayList<>();
	static ArrayList<Node> chicken = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;

	static int[] order;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] city = new int[N][N];
		order = new int[M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());


			for (int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				city[i][j] = value;
				if (value == 1) {
					home.add(new Node(i, j));
				}

				if (value == 2) {
					chicken.add(new Node(i, j));
				}
			}
		}

		combination(0, M, 0);

		System.out.println(answer);
	}

	private static void combination(int depth, int M, int start) {

		if (depth == M) {
			answer = Math.min(answer, getDistance(order));
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			order[depth] = i;
			combination(depth + 1, M, i + 1);
		}
	}

	private static int getDistance(int[] order) {

		int sum = 0;

		for (int i = 0; i < home.size(); i++) {
			int result = Integer.MAX_VALUE;
			Node homePos = home.get(i);

			for(int o : order) {
				Node chickenPos = chicken.get(o);
				result = Math.min(result, Math.abs(homePos.x - chickenPos.x) + Math.abs(homePos.y - chickenPos.y));
			}

			sum += result;

		}

		return sum;
	}
}
