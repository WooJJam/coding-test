import java.io.*;
import java.util.*;

public class Main {

	static int[] rain;
	static int answer = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		rain = new int[W];

		for (int i = 0; i < W; i++) {
			rain[i] = Integer.parseInt(st.nextToken());
		}

		solve(W);
		System.out.println(answer);

	}

	private static void solve(int W) {

		for (int i = 1; i < W; i++) {

			int leftMax = 0;
			int rightMax = 0;


			for (int j = i; j >= 0; j--) {
				leftMax = Math.max(rain[j], leftMax);
			}

			for (int k = i; k < W; k ++) {
				rightMax = Math.max(rain[k], rightMax);
			}

			int amount = Math.min(leftMax, rightMax);

			answer += amount - rain[i];
		}
	}
}
