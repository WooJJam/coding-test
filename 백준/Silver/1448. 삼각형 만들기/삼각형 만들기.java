import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> straw = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			straw.add(Integer.parseInt(br.readLine()));
		}

		straw.sort(Comparator.reverseOrder());
		System.out.println(solve(straw));

	}

	private static int solve(ArrayList<Integer> straw) {

		for (int i = 0; i < straw.size() - 2; i++) {
			int C = straw.get(i);
			int B = straw.get(i + 1);
			int A = straw.get(i + 2);

			if(determine(A, B, C)) {
				return A + B + C;
			}
		}

		return -1;
	}

	private static boolean determine(int A, int B, int C) {
		return C < A + B;
	}
}
