import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	private static Set<String> answer = new HashSet();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Integer[] arr = new Integer[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		tracking(N, M, arr, 0, new boolean[N]);
	}

	private static void tracking(int N, int M, Integer[] arr, int start, boolean[] selected) {

		if (M == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				if (selected[i]) {
					sb.append(arr[i]).append(" ");
				}
			}

			if (!answer.contains(sb.toString())) {
				answer.add(sb.toString());
				System.out.println(sb);
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			selected[i] = true;
			tracking(N, M - 1, arr, i + 1, selected);
			selected[i] = false;
		}

	}

}
