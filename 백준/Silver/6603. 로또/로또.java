import java.io.*;
import java.util.*;

public class Main {

	/*
	7 1 2 3 4 5 6 7
	8 1 2 3 5 8 13 21 34
	0
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while(true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			if (N == 0) {
				break;
			}

			int[] list = new int[N];
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				list[i] = num;
			}

			int[] answer = new int[6];
			search(list, 1, 0, answer);
			System.out.println();
		}
	}

	private static void search(int[] list, int depth, int index, int[] answer) {

		if (depth > 6) {
			for (int i = 0; i < 6; i++) {
				System.out.printf("%d ", answer[i]);
			}
			System.out.println();
			return;
		}

		if (index >= list.length) {
			return;
		}

		for (int i = index; i < list.length; i++) {
			answer[depth - 1] = list[i];
			search(list, depth + 1, i + 1, answer);
			answer[depth - 1] = -1;
		}
	}
}
