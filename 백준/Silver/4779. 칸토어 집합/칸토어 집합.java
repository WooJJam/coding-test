import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String str;

		while((str = br.readLine()) != null) {
			st = new StringTokenizer(str);
			int N = Integer.parseInt(st.nextToken());

			int end = (int)Math.pow(3, N);
			char[] bar = new char[end];

			Arrays.fill(bar, '-');

			divide(bar, 0, end);

			System.out.println(bar);
		}
	}

	private static void divide(char[] bar, int start, int end) {

		if (end - start < 3) {
			return;
		}

		int center = (end - start) / 3;

		for (int i = start + center; i < start + center * 2; i++) {
			bar[i] = ' ';
		}

		divide(bar, start, start + center);
		divide(bar, start + center * 2, end);
	}

}
