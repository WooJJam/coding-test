import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	/*

	(2, 4), (4, 6), (5, 3), (8, 10), (11, 4), (13, 6), (15, 8)



	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] polygons = new int[1_001];
		int max_index = 0;
		int max_h = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());

			polygons[L] = H;

			if (H > max_h) {
				max_h = H;
				max_index = L;
			}
		}

		solve(polygons, max_h, max_index);
	}

	private static void solve(int[] polygons, int max_h, int max_index) {

		int left = 0;
		int right = 0;
		int answer = 0;

		for (int i = 0; i <= max_index; i++) {
			left = Math.max(left, polygons[i]);
			answer += left;
		}
		
		for (int i = 1_000; i > max_index ; i--) {
			right = Math.max(right, polygons[i]);
			answer += right;
		}

		System.out.println(answer);
	}

}
