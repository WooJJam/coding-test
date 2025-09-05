import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		pq = new PriorityQueue<>(
			(a, b) -> {
				int compareNum = Integer.compare(Math.abs(a), Math.abs(b));

				if (compareNum == 0) {
					return Integer.compare(a, b);
				}

				return compareNum;
			});

		solve(input);
	}

	private static void solve(int[] input) {

		for (int i = 0; i < input.length; i++) {
			if (input[i] == 0) {
				if (pq.size() > 0) {
					System.out.println(pq.poll());
				} else {
					System.out.println(0);
				}
			} else {
				pq.add(input[i]);
			}
		}
	}
}