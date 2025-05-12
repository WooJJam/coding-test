import java.io.*;

import java.util.*;

public class Main {

	static int[] dp_max = {0, 0, 0};
	static int[] dp_min = {0, 0, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;


		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int middle = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());

			if (i == 0) {
				dp_max[0] = dp_min[0] = left;
				dp_max[1] = dp_min[1] = middle;
				dp_max[2] = dp_min[2] = right;
			} else {
				dynamic(left, middle, right);
				}
		}

		bw.write(Arrays.stream(dp_max).max().getAsInt() + " ");
		bw.write(Arrays.stream(dp_min).min().getAsInt() + "\n");
		bw.flush();
		bw.close();
	}

	static void dynamic(int left, int middle, int right) {

		int before_max_0 = dp_max[0];
		int before_max_1 = dp_max[1];

		dp_max[0] = Math.max(dp_max[0], dp_max[1]) + left;
		dp_max[1] = Math.max(Math.max(before_max_0, dp_max[1]), dp_max[2]) + middle;
		dp_max[2] = Math.max(before_max_1, dp_max[2]) + right;

		int before_min_0 = dp_min[0];
		int before_min_1 = dp_min[1];

		dp_min[0] = Math.min(dp_min[0], dp_min[1]) + left;
		dp_min[1] = Math.min(Math.min(before_min_0, dp_min[1]), dp_min[2]) + middle;
		dp_min[2] = Math.min(before_min_1, dp_min[2]) + right;

	}
}
