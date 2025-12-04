import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String line = br.readLine();
		int[] alp = new int[26];

		for (int i = 0; i < line.length(); i++) {
			alp[line.charAt(i) - 'A']++;
		}

		// for (int i = 0; i < line.length(); i++) {
		// 	System.out.println(alp[i]);
		// }

		int count = count(alp);

		if(count > 1) {
			System.out.println("I'm Sorry Hansoo");
		} else {
			makePalindrome(alp, line.length() / 2);
		}
	}

	private static int count(int[] alp) {

		int num = 0;

		for (int i = 0; i < alp.length; i++) {
			if (alp[i] % 2 == 1) {
				num += 1;
			}
		}

		return num;
	}

	private static void makePalindrome(int[] alp, int index) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < alp.length; i++) {
			if (alp[i] > 1) {
				for (int j = 0; j < alp[i] / 2; j++) {
					sb.append((char) (i + 'A'));
				}
			}
		}

		String first = sb.toString();

		StringBuilder sb2 = new StringBuilder(first);

		sb2.append(sb.reverse());

		for (int i = 0; i < alp.length; i++) {
			if (alp[i] % 2 != 0) {
				sb2.insert(index, (char) (i + 'A'));
			}
		}

		System.out.println(sb2);
	}
}
