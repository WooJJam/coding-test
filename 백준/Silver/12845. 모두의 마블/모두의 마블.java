import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		Integer[] L = new Integer[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(L, Collections.reverseOrder());

		int answer = 0;

		for (int i = 1; i < n; i++) {
			answer += L[0] + L[i];
		}

		bw.write(answer+"\n");
		bw.flush();
		bw.close();
	}
}