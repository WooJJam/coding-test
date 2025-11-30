import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] rectangle = new int[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();

			for (int j = 0; j < M; j++) {
				rectangle[i][j] = line.charAt(j) - '0';
			}

		}

		if (N == 1 || M == 1) {
			System.out.println(1);
		} else {
			solve(N, M, rectangle);
		}
	}

	private static void solve(int N, int M, int[][] rectangle) {

		int maxSize = Math.min(N, M);

		for (int i = maxSize - 1; i >= 0; i--) { // 최대 크기만큼 반복
			for (int j = 0; j + i < N; j++) {
				for (int k = 0; k + i < M; k++) {

					if (rectangle[j][k] == rectangle[j][k+i]
						&& rectangle[j][k] == rectangle[j+i][k]
						&& rectangle[j][k] == rectangle[j+i][k+i]) {
						System.out.println((int) Math.pow((i+1), 2));
						return;
					}
				}
			}
		}
	}
}
