import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {

	/*
	input:
	4
	23 32 25 28
	10
	5 27 10 16 24 20 2 32 18 7
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Integer[] crane = new Integer[N];
		for (int i = 0; i < N; i++) {
			crane[i] =  Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Integer[] box = new Integer[M];
		for (int i = 0; i < M; i++) {
			box[i] =  Integer.parseInt(st.nextToken());
		}

		int answer = solve(crane, box);
		System.out.println(answer);
	}

	private static int solve(Integer[] crane, Integer[] box) {
		Arrays.sort(crane, Comparator.reverseOrder());
		Arrays.sort(box, Comparator.reverseOrder());

		int time = 0;
		int index = 0;

		if(crane[0] < box[0]) {
			return -1;
		}

		while (!isZero(box)) {
			int craneCnt = 0;
			time++;

			for (int i = 0; i < box.length; i++) {
				if (craneCnt >= crane.length) {
					break;
				}

				for (int j = 0; j < crane.length; j ++) {
					if (crane[craneCnt] < box[i]) {
						break;
					}

					if (box[i] != 0) {
						box[i] = 0;
						craneCnt++;
						break;
					}
				}
			}
		}

		return time;
	}

	private static boolean isZero(Integer[] box) {

		int answer = 0;
		for(Integer value : box) {
			answer += value;
		}

		return answer == 0;
	}
}
