import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int answer = solve(N, K);
		System.out.println(answer);
	}

	private static int solve(int N, int K) {

		int answer = 0;
		while(Integer.bitCount(N) > K) {

			int idx;
			String binary = Integer.toBinaryString(N);
			// for (int i = binary.length() - 1; i >= 0; i--) {
			// 	if (binary.charAt(i) == '1') {
			// 		idx = i;
			// 		break;
			// 	}
			// }
			// System.out.println(idx);
			idx = Integer.numberOfTrailingZeros(N);
			int add = 1 << idx;
			N += add;
			answer += add;
		}

		return answer;

	}
}
