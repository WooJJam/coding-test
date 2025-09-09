import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private static int minus = 0;
	private static int zero = 0;
	private static int plus = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] paper = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		div(paper, 0, 0, N);

		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);

	}

	private static void div(int[][] paper, int x, int y, int size) {

		if (isSame(paper, x, y, size)) {
			if (paper[x][y] == -1) {
				minus++;
			}

			if (paper[x][y] == 0) {
				zero++;
			}

			if (paper[x][y] == 1) {
				plus++;
			}
		} else {
			int volume = size / 3;

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					div(paper, x + volume * i, y + volume * j, volume);
				}
			}
		}
	}

	private static boolean isSame(int[][] paper, int x, int y, int size) {

		int num = paper[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (paper[i][j] != num) {
					return false;
				}
			}
		}

		return true;
	}
}
