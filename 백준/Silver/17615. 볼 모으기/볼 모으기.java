import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		String line = br.readLine();
		char[] ball = new char[line.length()];

		for (int i = 0; i < N; i++) {
			ball[i] = line.charAt(i);
		}

		int answer = solve(N, ball);
		System.out.println(answer);
	}

	private static int solve(int N, char[] ball) {

		int totalB = 0;
		int totalR = 0;

		for (int i = 0; i < N; i++) {
			if(ball[i] == 'B') {
				totalB++;
			} else {
				totalR++;
			}
		}

		int count = 0;

		for (int i = 0; i < N - 1; i++) { // 왼쪽에 B 몰아 넣기
			if (ball[i] == 'B') {
				count++;
			} else {
				break;
			}
		}

		int answer = totalB - count;

		count = 0;
		for (int i = 0; i < N - 1; i++) {
			if (ball[i] == 'R') {
				count++;
			} else {
				break;
			}
		}

		answer = Math.min(answer, totalR - count);

		count = 0;

		for (int i = N - 1; i >= 0; i--) { // 오른쪽으로 모으기
			if (ball[i] == 'B') {
				count++;
			} else {
				break;
			}
		}

		answer = Math.min(answer, totalB - count);
		count = 0;

		for (int i = N - 1; i >= 0; i--) { // 오른쪽으로 모으기
			if (ball[i] == 'R') {
				count++;
			} else {
				break;
			}
		}

		return Math.min(answer, totalR - count);
	}
}

/*
12
BBRRBBBBRRRR
 */
