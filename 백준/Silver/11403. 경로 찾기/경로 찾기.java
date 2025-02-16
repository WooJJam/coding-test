import java.util.*;
import java.io.*;

public class Main {

	static ArrayList<ArrayList<Integer>> graph;
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				int point = Integer.parseInt(st.nextToken());
				if (point == 1) {
					graph.get(i).add(j);
				}
			}
		}

		int[][] answer = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer[i][j] = 0;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				boolean[] visited = initVisited(N);
				if (bfs(i, j, visited)) {
					answer[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}

	static boolean bfs(int start, int end, boolean visited[]) {
		queue.offer(start);

		while (!queue.isEmpty()) {
			int x = queue.poll();

			if (x == end && visited[end]) {
				queue.clear();
				return true;
			}

			for (int node : graph.get(x)) {
				if (!visited[node]) {
					queue.offer(node);
					visited[node] = true;
				}
			}
		}
		return false;
	}

	static boolean[] initVisited(int N) {
		boolean[] visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			visited[i] = false;
		}

		return visited;
	}
}