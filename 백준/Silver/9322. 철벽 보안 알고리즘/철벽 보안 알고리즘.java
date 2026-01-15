import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static HashMap<String, Integer> publicKey;
	static HashMap<Integer, Integer> secret;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			publicKey = new HashMap<>();
			secret = new HashMap<>();

			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			// A B C D
			for (int j = 0; j < n; j++) {
				String word = st.nextToken();
				publicKey.put(word, j);
			}

			st = new StringTokenizer(br.readLine());
			findRule(n, st);

			st = new StringTokenizer(br.readLine());
			decrypt(n, st);
		}
	}

	private static void findRule(int n, StringTokenizer st) {
		
		for (int i = 0; i < n; i++) {
			String word = st.nextToken(); // C
			secret.put(i, publicKey.get(word));
		}
	}

	private static void decrypt(int n, StringTokenizer st) {

		String[] plainText = new String[n];

		for (int i = 0; i < n; i++) {
			String word = st.nextToken();
			plainText[secret.get(i)] = word;
		}

		for (String s : plainText) {
			System.out.print(s + " ");
		}
	}
}
