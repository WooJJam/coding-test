import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];

		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			int min = Integer.MAX_VALUE;

			for (int j = 1; j * j <= i; j++) {
				min = Math.min(min, dp[i - (j * j)]);
			}

			dp[i] = min + 1;
		}

		bw.write(dp[N]+"\n");
		bw.flush();
		bw.close();
	}
}