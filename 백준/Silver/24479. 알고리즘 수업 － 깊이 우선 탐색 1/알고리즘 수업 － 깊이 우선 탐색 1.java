import java.io.*;
import java.util.*;

public class Main {

	/*
	input)
	5 5 1
	1 4
	1 2
	2 3
	2 4
	3 4
	무방향 그래프
	정점번호는 오름차순!!!!!! 으로 정렬
	 */

	private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	private static int[] visited;
	private static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		visited = new int[N+1];

		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		for (int i = 1; i < N + 1; i++) {
			graph.get(i).sort(Comparator.naturalOrder());
		}

		dfs(R);

		for (int i = 1; i <= N; i++) {
			System.out.println(visited[i]);
		}

	}

	private static void dfs(int r) {

		visited[r] = ++count;

		for(Integer next : graph.get(r)) {
			if(visited[next] == 0) {
				dfs(next);
			}
		}
	}
}
