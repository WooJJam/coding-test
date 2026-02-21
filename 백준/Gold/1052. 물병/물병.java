import java.io.*;
import java.util.*;

public class Main {

	/*
	input = 13 2

	2 13
	  6  1
	  3	 0
	  1	 1
	  -> 1 1 0 1 -> 1이 3개..
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int answer = solve(N, K);
		System.out.println(answer);
	}

	private static int solve(int N, int K) {

		int num = 0;
		while(true) {

			String binary = Integer.toBinaryString(N + num);
			int cnt = 0;

			for (int i = 0; i < binary.length(); i++) {
				if ('1' == binary.charAt(i)) {
					cnt++;
				}
			}

			if (cnt <= K) {
				break;
			}

			num++;
		}

		return num;

	}

	private static int divide(int N, int K) {


		int num = 0;
		while(true) {

			String binary = Integer.toBinaryString(N + num);
			int cnt = 0;

			for (int i = 0; i < binary.length(); i++) {
				if ('1' == binary.charAt(i)) {
					cnt++;
				}
			}

			if (cnt <= K) {
				break;
			}

			num++;
		}

		return num;
	}
}
