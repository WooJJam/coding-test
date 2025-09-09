import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

/*

1. 카드를 오름차순으로 정렬한다. (1, 2, 3, 4)
2. 작은 카드부터 더한 뒤 덮어쓴다
	-> 1 + 2 = 3 : (3, 3, 3, 4)
3. 덮어 쓴 뒤 다스 카드를 오름차순 정렬
4. 횟수가 m번 이라면 현재 카드를 모두 더하고 종료.

 */

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long[] card = new long[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			Arrays.sort(card);
			append(card);
		}

		System.out.println(getAnswer(card));
	}

	private static void append(long[] card) {

		long newCard = card[0] + card[1];
		card[0] = newCard;
		card[1] = newCard;
	}

	private static long getAnswer(long[] card) {

		return Arrays.stream(card).sum();
	}
}
