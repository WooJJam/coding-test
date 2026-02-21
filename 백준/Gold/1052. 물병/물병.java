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

		int num = 0;
		while(true) {
			
			int cnt = Integer.bitCount(N + num);

			if (cnt <= K) {
				break;
			}

			num++;
		}

		return num;

	}
}
