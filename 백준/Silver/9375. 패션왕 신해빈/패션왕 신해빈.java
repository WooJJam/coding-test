import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main { ;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			HashMap<String, Integer> clothes = new HashMap<>();

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				String item = st.nextToken();
				String category = st.nextToken();
				clothes.put(category, clothes.getOrDefault(category, 0) + 1);
			}
			
			solve(clothes);
		}


	}

	private static void solve(HashMap<String, Integer> clothes) {
		int answer = 1;
		
		for (String key : clothes.keySet()) {
			answer *= clothes.get(key) + 1;
		}

		System.out.println(answer - 1);
	}
}
