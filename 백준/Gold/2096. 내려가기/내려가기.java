import java.io.*;

import java.util.*;

public class Main {

	static int[][] game = new int[100_000][3];
	static int[][] dp_max = new int[100_000][3];
	static int[][] dp_min = new int[100_000][3];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;


		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				int point = Integer.parseInt(st.nextToken());
				game[i][j] = point;
			}
		}
		int[] answers = dynamic(N);

		bw.write(answers[0] + " " + answers[1] + "\n");
		bw.flush();
		bw.close();
	}

	static int[] dynamic(int N) {

		dp_max[0][0] = dp_min[0][0] = game[0][0];
		dp_max[0][1] = dp_min[0][1] = game[0][1];
		dp_max[0][2] = dp_min[0][2] = game[0][2];
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					dp_max[i][j] = Math.max(dp_max[i - 1][j], dp_max[i - 1][j + 1]) + game[i][j];
					dp_min[i][j] = Math.min(dp_min[i - 1][j], dp_min[i - 1][j + 1]) + game[i][j];
				}

				if (j == 1) {
					dp_max[i][j] = Math.max(Math.max(dp_max[i - 1][j - 1], dp_max[i - 1][j]), dp_max[i - 1][j + 1]) + game[i][j];
					dp_min[i][j] = Math.min(Math.min(dp_min[i - 1][j - 1], dp_min[i - 1][j]), dp_min[i - 1][j + 1]) + game[i][j];
				}

				if (j == 2) {
					dp_max[i][j] = Math.max(dp_max[i - 1][j - 1], dp_max[i - 1][j]) + game[i][j];
					dp_min[i][j] = Math.min(dp_min[i - 1][j - 1], dp_min[i - 1][j]) + game[i][j];
				}
			}
		}

		int max = Arrays.stream(dp_max[N - 1]).max().getAsInt();
		int min = Arrays.stream(dp_min[N - 1]).min().getAsInt();

		return new int[]{max, min};

	}
}
