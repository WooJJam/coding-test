import java.io.*;

import java.util.*;

public class Main {

	static boolean[] visited;

	static String[] operations = {"D", "S", "L", "R"};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			visited = new boolean[10_000];

			String answer = bfs(A, B);
			bw.write(answer + "\n");
		}

		bw.flush();
		bw.close();
	}

	static String bfs(int A, int B) {
		String answer = "";
		String[] command = new String[10_000];
		Queue<Integer> q = new LinkedList<>();

		q.offer(A);
		command[A] = "";

		int d, s, l, r;
		while (!q.isEmpty()) {
			int num = q.poll();

			if (num == B) {
				answer = command[num];
				break;
			}

			for (String operation : operations) {
				if (operation.equals("D")) {
					d = (num * 2) % 10000;
					if (command[d] == null) {
						command[d] = command[num] + "D";
						q.offer(d);
					}
				}

				if (operation.equals("S")) {
					s = (num + 9999) % 10000;
					if (command[s] == null) {
						command[s] = command[num] + "S";
						q.offer(s);
					}
				}

				if (operation.equals("L")) {
					l = (num % 1000) * 10 + num / 1000;
					if (command[l] == null) {
						command[l] = command[num] + "L";
						q.offer(l);
					}
				}

				if (operation.equals("R")) {
					r = (num / 10) + (num % 10) * 1000;
					if (command[r] == null) {
						command[r] = command[num] + "R";
						q.offer(r);
					}
				}
			}
		}

		return answer;
	}
}
