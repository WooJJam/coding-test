import java.io.*;
import java.util.*;

public class Main {

	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			solve(input);
		}

	}

	private static void solve(int input) {

		if (input == 0) {
			System.out.println(!pq.isEmpty() ? pq.poll() : 0);
		} else {
			pq.add(input);
		}
	}
}
