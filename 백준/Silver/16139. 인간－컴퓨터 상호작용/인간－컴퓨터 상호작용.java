import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String S = br.readLine();

		int[][] sum = new int[26][S.length() + 1];
		int q = Integer.parseInt(br.readLine());

		prefixSum(S, sum);
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());

			char alpha = st.nextToken().charAt(0);
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			solve(alpha, l, r, sum);
		}
	}

	private static void prefixSum(String S, int[][] sum) {

		sum[S.charAt(0) - 'a'][1] = 1;

		for (int i = 'a'; i <= 'z'; i++) {
			for (int j = 2; j <= S.length(); j++) {
				if (S.charAt(j - 1) == i) {
					sum[i - 'a'][j] = sum[i - 'a'][j-1] + 1;
				} else {
					sum[i - 'a'][j] = sum[i - 'a'][j-1];
				}
			}
		}
	}

	private static void solve(char alpha, int l, int r, int[][] sum) {
		
		System.out.println(sum[alpha - 'a'][r + 1] - sum[alpha - 'a'][l]);
	}
}

