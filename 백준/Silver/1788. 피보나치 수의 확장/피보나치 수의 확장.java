import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		fibonacci(n);
	}

	/*
	f(n) = f(n-1) + f(n-2)

	f(1) = f(0) + f(-1) = 0 + 1
	f(0) = f(-1) + f(-2) = 1 + -1
	f(-1) = f(-2) + f(-3) = -1 + 2
	f(-2) = f(-3) + f(-4) = 2 + -3

	...
	f(4) = 3
	f(3) = 2
	f(2) = 1
	f(1) = 1
	f(0) = 0
	f(-1) = 1
	f(-2) = -1
	f(-3) = 2
	f(-4) = -3

	-> 음수든 양수든 절대값에 따라서 정수가 정해짐
	-> 만약 음수일때
		-> 절대값이 짝수라면 음수
		-> 절대값이 홀수라면 양수
	 */
	private static void fibonacci(int n) {

		int absNum = Math.abs(n);
		int[] f = new int[1_000_001];

		f[0] = 0;
		f[1] = 1;

		for (int i = 2; i <= absNum; i++) {
			f[i] = (f[i-1] + f[i-2]) % 1_000_000_000;
		}

		// 만약 음수일 때
		if (n < 0) {
			// 절대 값이 짝수라면
			if (absNum % 2 == 0) {
				System.out.println(-1);
			} else {
				System.out.println(1);
			}
		} else {
			if (n == 0) {
				System.out.println(0);
			} else {
				System.out.println(1);
			}
		}

		System.out.println(Math.abs(f[absNum]));
	}
}
