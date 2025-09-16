import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private static LinkedList<Integer> queue = new LinkedList<>();
	private static int answer = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] num = new int[M];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			int pos = Integer.parseInt(st.nextToken());
			num[i] = pos;
		}

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		solve(M, num);
		System.out.println(answer);

		// for (int i = 0; i < N; i++) {
		// 	System.out.println(queue.pop());
		// }

	}

	private static void r() {
		int last = queue.removeLast();
		queue.addFirst(last);
		answer++;
	}

	private static void l() {
		int first = queue.removeFirst();
		queue.addLast(first);
		answer++;
	}

	private static void solve(int M, int[] num) {

		int count = 0;

		while (count < M) {
			// System.out.println(queue);
			if (queue.get(0) == num[count]) {
				queue.pollFirst();
				count++;
			} else {
				if (check(num[count])) {
					// System.out.println("왼쪽 회전");
					l();
				} else {
					// System.out.println("오른쪽 회전");
					r();
				}
			}
		}
	}

	private static boolean check(int findNum) {
		int index = queue.indexOf(findNum);

		/*
		만약 큐의 사이즈 절반보다 인덱스가 크다면 오른쪽 회전
		작다면 왼쪽 회전

		큐의 사이즈가 짝수라면 찾을 숫자가 중간이라면 오른쪽, 왼쪽 상관 x
		하지만 큐의 사이즈가 홀수라면 큐의 크기를 1개 늘려서 나누기해야함
		 */
		int halfIndex = 0;
		if (queue.size() % 2 == 0) {
			halfIndex = queue.size() / 2;
		} else {
			halfIndex = (queue.size() / 2) + 1;
		}

		// System.out.println(index);
		// System.out.println(halfIndex);

		return halfIndex > index;
	}
}
