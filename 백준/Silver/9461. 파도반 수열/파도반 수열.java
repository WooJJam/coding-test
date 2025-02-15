import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		long[] P = new long[101];

		P[0] = 0;
		P[1] = 1;
		P[2] = 1;
		P[3] = 1;
		P[4] = 2;

		for (int i = 5; i <= 100; i++) {
			P[i] = P[i-1] + P[i-5];
		}

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			bw.write(P[N]+"\n");
		}

		bw.flush();
		bw.close();
	}
}