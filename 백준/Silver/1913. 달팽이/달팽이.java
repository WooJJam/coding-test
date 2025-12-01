import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[][] snail;
	static int[] loc = new int[] {0, 0};
	static int point;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());
		point = N * N;

		snail = new int[N][N];

		draw(N);
		findTarget(N, target);

	}

	private static void draw(int N) {

		while(point > 0) {
			down(N, loc[0], loc[1]);
			right(N, loc[0], loc[1]);
			up(loc[0], loc[1]);
			left(loc[0], loc[1]);
		}

		print(N);
	}

	private static void down(int N, int x, int y) {

		int i = x;
		int temp = 0;

		while(i < N) {
			if(snail[i][y] < point) {
				snail[i][y] = point--;
				temp = i;
			}
			i++;
		}

		loc[0] = temp;
		loc[1] = y + 1;
	}

	private static void right(int N, int x, int y) {

		int i = y;
		int temp = 0;

		while(i < N) {
			if(snail[x][i] < point) {
				snail[x][i] = point--;
				temp = i;
			}
			i++;
		}

		loc[0] = x - 1;
		loc[1] = temp;
	}

	private static void up( int x, int y) {

		int i = x;
		int temp = 0;

		while(i >= 0) {
			if(snail[i][y] < point) {
				snail[i][y] = point--;
				temp = i;
			}
			i--;
		}

		loc[0] = temp;
		loc[1] = y - 1;
	}

	private static void left(int x, int y) {

		int i = y;
		int temp = 0;

		while(i >= 0) {
			if(snail[x][i] < point) {
				snail[x][i] = point--;
				temp = i;
			}
			i--;
		}

		loc[0] = x + 1;
		loc[1] = temp;
	}

	private static void print(int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(snail[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void findTarget(int N, int target) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (snail[i][j] == target) {
					System.out.printf("%d %d", i + 1, j + 1);
					return;
				}
			}
		}
	}
}
