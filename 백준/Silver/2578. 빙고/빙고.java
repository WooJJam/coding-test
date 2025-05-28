import java.io.*;
import java.util.*;

public class Main {

	static int bingo = 0;
	static int[][] game = new int[5][5];
	static int[][] mc = new int[5][5];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				game[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				mc[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve();
	}

	private static void solve() {

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				playGame(i, j);

				if (bingo >= 3){
					System.out.println(i * 5 + j + 1);
					return;
				}
			}
		}
	}

	private static void playGame(int x, int y) {

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				// 철수의 숫자와 사회자가 부른 숫자가 같은 칸
				if (game[i][j] == mc[x][y]) {
					game[i][j] = 0;
					checkBingo(i, j);
					return;
				}
			}
		}

	}

	private static void checkBingo(int i, int j) {

		// System.out.println();
		// System.out.println("i = " + i);
		// System.out.println("j = " + j);
		// System.out.println(i * 5 + j);
		// System.out.println("bingo = " + bingo);

		checkLeftDiagonal(i, j);
		checkRightDiagonal(i, j);
		checkVertical(j);
		checkRow(i);


		// if (bingo == 3) {
		// 	System.out.println("i = " + i);
		// 	System.out.println("j = " + j);
		// 	System.out.println(i * 5 + j);
		// }
	}

	private static void checkLeftDiagonal(int i,  int j) {
		int result = 0;

		// 왼쪽 대각선
		if ((i == 0 && j ==0) || (i == 1 && j ==1) || (i == 2 && j ==2) || (i == 3 && j == 3) || (i == 4 && j ==4)) {
			for (int k = 0; k < 5; k++) {
				result += game[k][k];
			}

			if (result == 0) {
				bingo += 1;
			}
		}
	}

	private static void checkRightDiagonal(int i, int j) {

		int x = 0;
		int y = 4;

		int result = 0;

		// 오른쪽 대각선
		if ((i == 0 && j == 4) || (i == 1 && j == 3) || (i == 2 && j ==2) || (i == 3 && j == 1) || (i == 4 && j == 0)) {
			for (int k = 0; k < 5; k++) {
				result += game[x++][y--];
			}

			if (result == 0) {
				bingo += 1;
			}
		}
	}

	private static void checkVertical(int j) {

		int result = 0;

		for (int k = 0; k < 5; k++) {
			result += game[k][j];
		}

		if (result == 0) {
			bingo += 1;
		}
	}

	private static void checkRow(int i) {

		int result = 0;

		for (int k = 0; k < 5; k++) {
			result += game[i][k];
		}

		if (result == 0) {
			bingo += 1;
		}
	}
}
