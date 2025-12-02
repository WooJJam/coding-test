import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[] human;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		human = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		solve(N, input);
	}

	/*
	4
	2 1 1 0
	 */
	private static void solve(final int N, final int[] input) {

		for (int i = 0; i < N; i++) {

			int loc = input[i];
			int zeroCnt = 0;

			while (human[loc] != 0) {
				loc++;
			}

			for (int j = 0; j < loc; j++) {
				if (human[j] == 0) {
					zeroCnt++;
				}

				if (zeroCnt == input[i]) {
					break;
				}
			}

			while (zeroCnt != input[i]) {
				loc++;

				if (human[loc] == 0) {
					zeroCnt++;
				}
			}

			human[loc] = i + 1;
		}

		for (int i = 0; i < N; i++) {
			System.out.print(human[i] + " ");
		}
	}
}
