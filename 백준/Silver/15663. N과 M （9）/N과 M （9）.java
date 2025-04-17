import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

	static int[] answer;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer> arr = new ArrayList<>();
		answer = new int[M];
		visited = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int input = Integer.parseInt(st.nextToken());
			arr.add(input);
		}

		arr.sort(Comparator.naturalOrder());

		backtracking(0, N, M, arr);
		
	}

	static void backtracking(int depth, int N, int M, List<Integer> arr) {

		if (depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();
			return;
		}

		int before = 0;
		for (int i = 0; i < N; i++) {
			int num = arr.get(i);
			if (!visited[i] && before != num) {
				visited[i] = true;
				before = num;
				answer[depth] = num;
				backtracking(depth + 1, N, M, arr);
				visited[i] = false;
			}
		}
	}
}
