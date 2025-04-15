import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = 0;
		int X = 0;

		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
		}

		int[] visitor = new int[N];
		int[] sum = new int[N+1];

		String[] input = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			visitor[i] = Integer.parseInt(input[i]);
		}

		sum[0] = 0;
		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i-1] + visitor[i-1];
		}

		int max = 0;
		int count = 0;
		
		for (int i = 0; i + X <= N; i++) {
			int result = sum[i + X] - sum[i];

			if (max != 0 && max == result) {
				count ++;
			}

			if (max < result) {
				max = result;
				count = 1;
			}
		}

		if (max == 0) {
			System.out.print("SAD");
		} else {
			System.out.println(max);
			System.out.print(count);
		}
	}
}