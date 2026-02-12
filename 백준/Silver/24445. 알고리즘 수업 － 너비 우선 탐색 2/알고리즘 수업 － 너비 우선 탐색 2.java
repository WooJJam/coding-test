import java.io.*;
import java.util.*;

public class Main {

	/*
	5 5 1
	1 4
	1 2
	2 3
	2 4
	3 4

	1 -> 4, 2
	2 -> 3, 4, 1
	3 -> 4, 2
	4 -> 1, 2, 3

	int visited[N + 1] 생성

	1. 무방향 그래프를 설정한다.
		- u와 v를 입력받으면 양방향으로 연결
		- 각 정점별 간선은 내림차순으로 정렬
	2. bfs탐색
		- visited[i] != 0 -> 방문된 노드
		- 방문하지 않았다면 현재 방문 순서를 visited에 저장

	5 5 1
	1 4
	1 2
	2 3
	2 4
	3 4
	 */

	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		visited = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		for (int i = 0; i <= N; i++) {
			graph.get(i).sort(Comparator.reverseOrder());
		}

		bfs(N, M, R);

		for (int i = 1; i <= N; i++) {
			System.out.println(visited[i]);
		}
	}

	private static void bfs(int N, int M, int R) {
		int start = 1;
		Queue<Integer> q = new LinkedList<>();
		q.offer(R);
		visited[R] = start;

		while(!q.isEmpty()) {
			int num = q.poll();

			for (Integer v : graph.get(num)) {
				if (visited[v] == 0) { // 방문하지 않음
					visited[v] = ++start;
					q.offer(v);
				}
			}
		}
	}
}
