import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			Queue<String> q = new LinkedList<>();
			ArrayDeque<String> answer = new ArrayDeque<>();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			String s = st.nextToken();
			answer.offerFirst(s);

			for (int j = 0; j < N-1; j++) {
				String input = st.nextToken();
				q.offer(input);
			}

			while (!q.isEmpty()) {
				String alpha = q.poll();
				if (answer.peekFirst().compareTo(alpha) >= 0) {
					answer.offerFirst(alpha);
				} else {
					answer.offerLast(alpha);
				}
			}

			for (int j = 0; j < N; j++) {
				bw.write(answer.pollFirst());
			}

			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}