import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int N = 0;
		for (int i = 0; i < T; i++) {
			HashMap<String, Integer> map = new HashMap<>();
			N = Integer.parseInt(br.readLine());
			for (int j = 0; j < N; j++) {
				String[] clothes = br.readLine().split(" ");
				map.put(clothes[1], map.getOrDefault(clothes[1], 0) + 1);
			}
			System.out.println(solve(map));
		}
	}

	static int solve(HashMap<String, Integer> map) {
		int answer = 1;
		for (int value: map.values()) {
			answer *= (value + 1);
		}
		return answer - 1;
	}
}
