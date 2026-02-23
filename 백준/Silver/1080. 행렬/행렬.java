import java.io.*;
import java.util.*;

public class Main {

	/*
	input
	3 4
	0000
	0010
	0000
	1001
	1011
	1001

	실패 조건
	1. N < 3 or M < 3
	2. 바꿔야하지만 사이즈가 안나오는 경우
		- i + 2 < N or j + 2 < M
	 */

	static char[][] A;
	static char[][] B;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		A = new char[N][M];
		B = new char[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				A[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				B[i][j] = line.charAt(j);
			}
		}

		System.out.println(isValid(N, M) ? answer : -1);

	}

	private static boolean isValid(int N, int M) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j]) {
					if (i + 2 >= N || j + 2 >= M) {
						return false;
					} else {
						swap(i, j);
					}
				}
			}
		}

		return true;
	}

	private static void swap(int x, int y) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (A[x + i][y + j] == '1') {
					A[x + i][y + j] = '0';
				} else {
					A[x + i][y + j] = '1';
				}
			}
		}

		answer++;
	}
}

/*
3 42
011001011111111100101000111111001010010111
111111011001011001001011000111011110111011
100101110101010111110100001001100110111110
011001010110000110010000111001100111000110
010010001100100111100010101000101101010100
101111100111000010111000110011001111100011
 */
