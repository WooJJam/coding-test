import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] fruitCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] fruits = new int[N];
		fruitCount = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int f = Integer.parseInt(st.nextToken());
			fruits[i] = f;
		}

		if (N == 1) {
			System.out.println(1);
		} else {
			solve(N, fruits);
		}

	}

	static void solve(int N, int[] fruits) {
		int start = 0;
		int end = start + 1;
		int answer = 1;
		fruitCount[fruits[0]] = 1;

		int totalCount = 1;

		while(start <= end && end < N) {

			int first = fruits[start]; // 5
			int last = fruits[end]; // 2

			if (fruitCount[last] == 0) {
				totalCount += 1;
			}

			if (totalCount > 2) {
				fruitCount[first] -= 1;

				if (fruitCount[first] == 0) {
					totalCount -= 2;
				} else {
					totalCount -= 1;
				}
				start++;
			} else {
				answer = Math.max(answer, end - start + 1);

				fruitCount[last] += 1;
				end++;
			}

		}

		System.out.println(answer);
	}
}
