import java.io.*;

import java.util.*;

public class Main {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int M = 0;
			int N = 0;
			int x = 0;
			int y = 0;
			st = new StringTokenizer(br.readLine());

			while(st.hasMoreTokens()) {
				M = Integer.parseInt(st.nextToken());
				N = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
			}

			System.out.println(solve(M, N, x, y));
		}

	}

	static int solve(int M, int N, int x, int y) {

		int answer = x;

		while(answer <= M * N) {
			if (((answer - x) % M == 0) && ((answer - y)) % N == 0) {
				return answer;
			}
			answer += M;
		}

		return -1;
	}
}
