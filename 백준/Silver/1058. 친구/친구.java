import java.io.*;

import java.util.*;

public class Main {

	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		String friends[][] = new String[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			friends[i] = st.nextToken().split("");
		}

		int answer = 0;

		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			answer = Math.max(answer, bfs(i, friends, N));
		}
		System.out.print(answer);
	}

	static int bfs(int start, String[][] friends, int N) {

		Queue<Integer> q = new LinkedList<>();

		// System.out.println("start = " + start);
		// System.out.println("depth = " + depth);
		// System.out.println();

		int count = 0;
		int depth = 0;
		q.offer(start);
		visited[start] = true;

		while(depth < 2) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int index = q.poll();
				for (int j = 0; j < N; j++) {
					if (friends[index][j].equals("Y") && !visited[j]) {
						count++;
						visited[j] = true;
						q.offer(j);
					}
				}
			}

			depth++;
		}

		return count;
	}
}

// 6
// NYYNYN
// YNYNNN
// YYNYNN
// NNYNNN
// YNNNNY
// NNNNYN