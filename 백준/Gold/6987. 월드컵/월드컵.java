import java.io.*;
import java.util.*;

/*
input:
5 0 0 3 0 2 2 0 3 0 0 5 4 0 1 1 0 4
4 1 0 3 0 2 4 1 0 1 1 3 0 0 5 1 1 3
5 0 0 4 0 1 2 2 1 2 0 3 1 0 4 0 0 5
5 0 0 3 1 1 2 1 2 2 0 3 0 0 5 1 0 4

A 0
B 1
C 2
D 3
E 4
F 5

6

 */
public class Main {

	static int[][] result;
	static int answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 4; i++) {
			answer = 0;
			result = new int[6][3];
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 3; k++) {
					result[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			dfs(0, 1);
			sb.append(answer).append(' ');
		}

		System.out.println(sb);
	}

	// 현재 국가와 상대 국가
	private static void dfs(int cur, int next) {

		// System.out.printf("\ncur = %d, next = %d", cur, next);
		if (cur == 5) {
			if(check()) {
				answer = 1;
			}
			return;
		}

		// 현재 국가 이기고 상대 국가 진 경우
		if(result[cur][0] > 0 && result[next][2] > 0) {
			result[cur][0]--;
			result[next][2]--;

			if(next == 5) {
				dfs(cur + 1, cur + 2); // 현재 국가의 검증이 모두 끝나 아예 다음국가 차례로 넘어감
			} else {
				dfs(cur, next + 1); // 현재 국가의 검증이 남아서 상대 국가만 증가
			}
			result[cur][0]++;
			result[next][2]++;
		}

		// 현재 국가 이기고 상대 국가 진 경우
		if(result[cur][1] > 0 && result[next][1] > 0) {
			result[cur][1]--;
			result[next][1]--;

			if(next == 5) {
				dfs(cur + 1, cur + 2); // 현재 국가의 검증이 모두 끝나 아예 다음국가 차례로 넘어감
			} else {
				dfs(cur, next + 1); // 현재 국가의 검증이 남아서 상대 국가만 증가
			}
			result[cur][1]++;
			result[next][1]++;
		}

		// 현재 국가 이기고 상대 국가 진 경우
		if(result[cur][2] > 0 && result[next][0] > 0) {
			result[cur][2]--;
			result[next][0]--;

			if(next == 5) {
				dfs(cur + 1,cur + 2); // 현재 국가의 검증이 모두 끝나 아예 다음국가 차례로 넘어감
			} else {
				dfs(cur, next + 1); // 현재 국가의 검증이 남아서 상대 국가만 증가
			}
			result[cur][2]++;
			result[next][0]++;
		}
	}

	private static boolean check() {

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				if (result[i][j] != 0) {
					return false;
				}
			}
		}

		return true;
	}
}
