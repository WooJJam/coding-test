import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	private static ArrayList<Integer> answer = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;


		while (true) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken()); // 가로
			int h = Integer.parseInt(st.nextToken()); // 세로

			if (w == 0 && h == 0) {
				break;
			}

			int[][] island = new int[h][w];
			int count = 0;
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < w; j++) {
					int e = Integer.parseInt(st.nextToken());
					island[i][j] = e;
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (island[i][j] == 1) {
						dfs(island, w, h, i, j);
						count += 1;
					}
				}
			}
			answer.add(count);
		}

		printAnswer();
	}

	private static void dfs(int[][] island, int w, int h, int x, int y) {

		island[x][y] = 0;
		
		for (int i = 0; i < 8; i++) {
			int nextX = dx[i] + x;
			int nextY = dy[i] + y;
			
			if (0 <= nextX && nextX < h && 0 <= nextY && nextY < w && island[nextX][nextY] != 0) {
				dfs(island, w, h, nextX, nextY);
			}
		}
	}

	private static void printAnswer() {

		answer.forEach(System.out::println);
	}
}
