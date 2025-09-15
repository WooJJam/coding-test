import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private static PriorityQueue<Integer> gift = new PriorityQueue<>(Collections.reverseOrder());

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());

			if (a == 0) {
				sendGift();
			} else {

				for (int j = 0; j < a; j++) {
					int v = Integer.parseInt(st.nextToken());
					addGift(v);
				}
			}
		}
	}

	private static void sendGift() {

		if (gift.isEmpty()) {
			System.out.println(-1);
		} else {
			System.out.println(gift.poll());
		}
	}

	private static void addGift(int v) {
		gift.add(v);
	}

}
