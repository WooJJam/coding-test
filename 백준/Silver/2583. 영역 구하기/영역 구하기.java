import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	private static int[][] land;
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {-1, 0, 1, 0};
	private static ArrayList<Integer> answer = new ArrayList<>();
	private static int count = 0;

	/*
	M = 5 -> 세로
	N = 7 -> 가로
	K = 3 -> K개의 줄
	
	(왼쪽 아래부터) x1, y1, x2, y2	
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		land = new int[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			// 초기 땅에 대해서 색칠하기
			setLand(x1, y1, x2, y2);
		}

		for (int j = 0; j < M; j++) {
			for (int k = 0; k < N; k++) {
				if (land[j][k] == 0) {
					count = 1;
					dfs(j, k, M, N);
					answer.add(count);
				}
			}
		}

		answer.sort(Comparator.naturalOrder());

		System.out.println(answer.size());
		for (int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
	}

	private static void setLand(int x1, int y1, int x2, int y2) {
		for (int j = y1; j < y2; j++) {
			for (int k = x1; k < x2; k++) {
				land[j][k] = 1;
			}
		}
	}

	// x는 가로, y는 세로
	private static void dfs(int y, int x, int M, int N) {

		land[y][x] = 1;

		for (int i = 0; i < 4; i++) {
			int nextY = dy[i] + y;
			int nextX = dx[i] + x;

			if (0 <= nextY && nextY < M && 0 <= nextX && nextX < N && land[nextY][nextX] == 0) {
				count++;
				dfs(nextY, nextX, M, N);
			}
		}
	}
}
