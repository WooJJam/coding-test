import java.io.*;

import java.util.*;

public class Main {

	static Map<Integer, Integer> answer = new HashMap<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		init();
		solve(arr, 0, 0, N);

		System.out.println(answer.get(-1));
		System.out.println(answer.get(0));
		System.out.print(answer.get(1));
	}

	static void init() {
		answer.put(-1, 0);
		answer.put(0, 0);
		answer.put(1, 0);
	}

	static void solve(int[][] arr, int si, int sj, int size) {
		// System.out.println("재귀 시작!!");
		// System.out.println("si = " + si + " sj = " + sj + " size = " + size);
		boolean flag = false;
		int number = arr[si][sj];
		for (int i = si; i < si + size; i++) {
			// System.out.println("i = " + i);
			for (int j = sj; j < sj + size; j++) {
				// System.out.println("j = " + j);
				if (number != arr[i][j]) {
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}

		if (flag) {
			int nextSize = size / 3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					solve(arr, si + (i * nextSize), sj + (j * nextSize), nextSize);
				}
			}
		} else {
			answer.put(arr[si][sj], answer.get(arr[si][sj]) + 1);
		}
	}
}