import java.io.*;

import java.util.*;

public class Main {

	static int[] A;
	static int MAX = (int) -1e9;
	static int MIN = (int) 1e9;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		A = new int[N];
		int[] operator = new int[4];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			A[i] = num;
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		calculate(1, A[0], N, operator);

		System.out.println(MAX);
		System.out.println(MIN);

	}

	static void calculate(int depth, int result, int n, int[] operator) {

		if (depth == n) {
			MAX = Math.max(result, MAX);
			MIN = Math.min(result, MIN);
			return;
		}

		if (operator[0] > 0) {
			operator[0] -= 1;
			calculate(depth + 1, result + A[depth], n, operator);
			operator[0] += 1;
		}

		if (operator[1] > 0) {
			operator[1] -= 1;
			calculate(depth + 1, result - A[depth], n, operator);
			operator[1] += 1;
		}

		if (operator[2] > 0) {
			operator[2] -= 1;
			calculate(depth + 1, result * A[depth], n, operator);
			operator[2] += 1;
		}

		if (operator[3] > 0) {
			operator[3] -= 1;
			calculate(depth + 1, result / A[depth], n, operator);
			operator[3] += 1;
		}

	}
}
