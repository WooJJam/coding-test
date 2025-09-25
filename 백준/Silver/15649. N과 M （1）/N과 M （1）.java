import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[M];
		tracking(N, M, arr, new boolean[N], 0);
	}

	private static void tracking(int N, int M, int[] arr, boolean[] selected, int depth) {

		if (depth == M) {
			StringBuilder sb = new StringBuilder();

			for (int num : arr) {
				sb.append(num).append(" ");
			}

			System.out.println(sb);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!selected[i]) {
				selected[i] = true;
				arr[depth] = i + 1;
				tracking(N, M, arr, selected, depth + 1);
				selected[i] = false;
			}
		}
	}

}
