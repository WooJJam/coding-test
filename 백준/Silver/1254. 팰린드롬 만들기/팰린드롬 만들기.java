import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		String s = st.nextToken();

		find(s);
	}

	private static void find(String s) {

		int left = 0;
		int start = left;
		int right = s.length() - 1;
		boolean check = false;

		while(left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				start++;
				left = start;
				right = s.length() - 1;
				check = false;
				continue;
			}

			left++;
			right--;
			check = true;
		}

		if (check) {
			System.out.println(s.length() + start);
		} else {
			System.out.println(s.length() * 2 - 1);
		}
	}
}
