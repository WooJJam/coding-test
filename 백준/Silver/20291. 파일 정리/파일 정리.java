import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	private static HashMap<String, Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), ".");
			String file = st.nextToken();
			String extension = st.nextToken();

			map.put(extension, map.getOrDefault(extension, 0) + 1);
		}

		ArrayList<String> keySet = new ArrayList<>(map.keySet());

		Collections.sort(keySet);

		for (String s : keySet) {
			System.out.println(s + " " + map.get(s));
		}
	}

}
