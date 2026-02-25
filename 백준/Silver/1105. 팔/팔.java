import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		String L = st.nextToken();
		String R = st.nextToken();

		System.out.println(solve(L, R));
	}

	private static int solve(String L, String R) {

		int count = 0;
		if (L.length() != R.length()) {
			return count;
		}

		for (int i = 0; i < L.length(); i++) {
			if (L.charAt(i) == R.charAt(i)) {
				if (L.charAt(i) == '8' && R.charAt(i) == '8') {
					count++;
				}
			} else {
				break;
			}
		}

		return count;
	}
}
