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
		int X = Integer.parseInt(st.nextToken());

		int[] visitor = new int[N + 1];

		st = new StringTokenizer(br.readLine());

		visitor[0] = 0;

		for (int i = 1; i <= N; i++) {
			visitor[i] = Integer.parseInt(st.nextToken());
		}

		sum(visitor, N);
		solve(visitor, N, X);
	}

	private static void sum(int[] visitor, int N) {

		for (int i = 1; i <= N; i++) {
			visitor[i] = visitor[i-1] + visitor[i];
		}
	}

	/*
	0 1 2 3  4  5
	0 1 5 7 12 13

	2 ~ 5

	2 - 0 -> 5
	3 - 1 -> 6
	4 - 2 -> 7
	5 - 3 -> 6
	 */
	private static void solve(int[] visitor, int N, int X) {

		int maxVisitor = 0;
		int period = 0;

		for (int i = X; i <= N; i++) {
			int count = visitor[i] - visitor[i-X];

			if (count > maxVisitor) {
				maxVisitor = count;
				period = 1;
			} else if(count == maxVisitor) {
				period += 1;
			}
		}
		
		if (maxVisitor == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(maxVisitor);
			System.out.println(period);
		}
	}
}
