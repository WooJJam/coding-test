import java.io.*;
import java.util.*;

public class Main {

	/*
	inout =
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String S = br.readLine();
		String T = br.readLine();

		int answer = solve(S, T);
		System.out.println(answer);

	}

	private static int solve(String S, String T) {

		StringBuilder s = new StringBuilder(S);
		StringBuilder t = new StringBuilder(T);

		while(t.length() != s.length()) {
			int lastIndex = t.length() - 1;

			if (t.charAt(lastIndex) == 'A') {
				t.delete(lastIndex, lastIndex + 1);
			}

			else if(t.charAt(lastIndex) == 'B') {
				t.delete(lastIndex, lastIndex + 1);
				t.reverse();
			} else {
				break;
			}
		}

		if (t.compareTo(s) == 0) {
			return 1;
		}

		return 0;
	}
}
