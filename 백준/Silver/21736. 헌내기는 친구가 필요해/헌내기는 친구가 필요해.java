import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

	static int[] nx = {-1, 0, 1, 0};
	static int[] ny = {0, 1, 0, -1};
	static int answer = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int M = Integer.parseInt(inputs[1]);

		char[][] school = new char[N+1][M+1];
		int startX = 0;
		int startY = 0;

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				school[i][j] = line.charAt(j);
				if (school[i][j] == 'I') {
					startX = i;
					startY = j;
				}
			}
		}

		boolean[][] visited = new boolean[N][M];

		dfs(startX, startY, N, M, visited, school);

		if (answer == 0) {
			bw.write("TT\n");
		} else {
			bw.write(answer + "\n");
		}

		bw.flush();
		bw.close();
	}

	static void dfs(int x, int y, int N, int M, boolean[][] visited, char[][] school) {

		if (school[x][y] == 'P') {
			answer += 1;
		}

		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nextX = x + nx[i];
			int nextY = y + ny[i];

			if (0 <= nextX && nextX < N
				&& 0 <= nextY && nextY < M
				&& !visited[nextX][nextY]
				&& school[nextX][nextY] != 'X') {
				dfs(nextX, nextY, N, M, visited, school);
			}
		}
	}
}