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

			String[] input = br.readLine().split(" ");

			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);

			visited = new boolean[10_000];

			String answer = bfs(A, B);
			bw.write(answer + "\n");
		}

		bw.flush();
		bw.close();
	}

	static class QueueType {
		int num;
		String answer;

		public QueueType(final int num, final String answer) {
			this.num = num;
			this.answer = answer;
		}
	}

	static void markVisited(int num, String order, Queue<QueueType> queue){
		if (!visited[num]) {
			visited[num] = true;
			queue.offer(new QueueType(num, order));
		}
	}

	static String bfs(int A, int B) {
		String answer = "";
		Queue<QueueType> q = new LinkedList<>();

		q.offer(new QueueType(A, answer));

		while (!q.isEmpty()) {
			int push = 0;
			QueueType queueType = q.poll();
			int num = queueType.num;
			String order = queueType.answer;

			visited[num] = true;

			if (num == B) {
				answer = order;
				break;
			}

			for (String operation : operations) {
				if (operation.equals("D")) {
					push = (num * 2) % 10000;
					markVisited(push, order + "D", q);
				}

				if (operation.equals("S")) {
					push = (num + 9999) % 10000;
					markVisited(push, order + "S", q);
				}

				if (operation.equals("L")) {
					push = (num % 1000) * 10 + num / 1000;
					markVisited(push, order + "L", q);
				}

				if (operation.equals("R")) {
					push = (num / 10) + (num % 10) * 1000;
					markVisited(push, order + "R", q);
				}

				if (!visited[push]) {
					q.offer(new QueueType(push, answer));
				}
			}
		}

		return answer;
	}
}
