import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		Integer[] time = new Integer[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int t = Integer.parseInt(st.nextToken());

			time[i] = t;
		}

		solve(time);
	}

	private static void solve(Integer[] time) {

		Arrays.sort(time, Collections.reverseOrder());

		int maxDays = 0;

		for (int i = 0; i < time.length; i++) {
			int days = i + 1 + time[i];

			if (maxDays < days) {
				maxDays = days;
			}
		}

		System.out.println(maxDays + 1);
	}
}
