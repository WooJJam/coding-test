import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		char[] L = st.nextToken().toCharArray();
		char[] R = st.nextToken().toCharArray();

		System.out.println(solve(L, R));
	}

	private static int solve(char[] L, char[] R) {

		int count = 0;
		if (L.length != R.length) {
			return count;
		}

		for (int i = 0; i < L.length; i++) {
			if (L[i] == R[i]) {
				if (L[i] == '8') {
					count++;
				}
			} else {
				break;
			}
		}

		return count;
	}
}
