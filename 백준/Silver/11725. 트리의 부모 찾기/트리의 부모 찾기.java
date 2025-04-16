import java.io.*;
import java.util.*;

public class Main {

	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		
		List<ArrayList<Integer>> graph = new ArrayList<>();
		
		int[] parents = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}

		dfs(graph, 1, parents);

		for (int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}
	}

	static void dfs(List<ArrayList<Integer>> graph, int start, int[] parents) {

		visited[start] = true;

		for (int pos : graph.get(start)) {
			if (!visited[pos]) {
				parents[pos] = start;
				dfs(graph, pos, parents);
			}
		}
	}
}
