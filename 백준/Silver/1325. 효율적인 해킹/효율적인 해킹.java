import java.io.*;
import java.util.*;

import org.w3c.dom.Node;

/*
input
5 4
3 1
3 2
4 3
5 3

1: 3
2: 3
3: 4, 5

1 --> 3 --> 4 (3개)
	    --> 5 (3개)
2 --> 3 --> 4
		--> 5

 */
public class Main {

	static int MAX = 0;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] count;
	static int sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		count = new int[N+1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			graph.get(B).add(A);
		}

		solve(N);
	}

	private static void solve(int N) {
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			sum = 1;
			dfs(i);
			MAX = Math.max(MAX, sum);
			count[i] = sum;
		}

		print(N);
	}

	private static void print(int N) {

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (count[i] == MAX) {
				sb.append(i).append(' ');
			}
		}

		System.out.println(sb);
	}

	private static void dfs(int index) {

		ArrayList<Integer> line = graph.get(index);
		visited[index] = true;

		for(Integer num: line) {
			if (!visited[num]) {
				sum += 1;
				dfs(num);
			}
		}
	}
}
