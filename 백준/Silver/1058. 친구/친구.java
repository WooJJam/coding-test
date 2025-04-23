import java.io.*;

import java.util.*;

public class Main {

	static int[][] distance;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		String friends[][] = new String[N][N];
		distance = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				distance[i][j] = 0;
			}
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			friends[i] = st.nextToken().split("");
		}

		solve(friends, N);

		int answer = 0;

		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				sum += distance[i][j];
			}
			answer = Math.max(sum, answer);
		}

		System.out.print(answer);

	}

	static void solve(String friends[][], int N) {

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) {
						continue;
					}
					if (friends[i][j].equals("Y") || (friends[i][k].equals("Y")) && friends[k][j].equals("Y")) {
						distance[i][j] = 1;
					}
				}
			}
		}
	}
}