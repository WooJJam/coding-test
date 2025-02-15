import java.security.Key;
import java.util.*;
import java.io.*;

public class Main {

	static int[] fruits = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	static int answer = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		ArrayList<Integer> input = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			input.add(Integer.parseInt(st.nextToken()));
		}

		if (N == 1 || N == 2) {
			bw.write(N + "\n");
		} else {
			int kind = 1;
			int left = 0;
			int right = 1;

			fruits[input.get(left)] += 1;

			solve(N, input, left, right, kind);
			bw.write(answer + "\n");
		}

		bw.flush();
		bw.close();
	}

	static void solve(int N, ArrayList<Integer> input, int left, int right, int kind) {
		int total = 1;
		Set<Integer> set = new HashSet<>();
		set.add(input.get(left));

		while (right < N) {
			set.add(input.get(right));

			if (set.size() > 2) {
				while (set.size() > 2) {
					int leftFruit = --fruits[input.get(left)];
					if (leftFruit == 0) {
						set.remove(input.get(left));
					}
					left++;
					total--;
				}
			} else {
				++fruits[input.get(right)];
				total++;
				right++;
			}

			answer = Math.max(answer, total);
		}
	}
}