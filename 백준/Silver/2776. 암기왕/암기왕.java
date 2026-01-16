import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			HashMap<Integer, Boolean> note = new HashMap();

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				note.put(Integer.parseInt(st.nextToken()), true);
			}

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int number = Integer.parseInt(st.nextToken());
				if (note.containsKey(number)) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
			}
		}
		bw.flush();
		bw.close();
	}
}
