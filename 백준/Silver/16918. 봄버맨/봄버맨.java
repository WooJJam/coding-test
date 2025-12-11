import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static char[][] bomb;
	static int[][] timer;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken()); // 세로
		int C = Integer.parseInt(st.nextToken()); // 가로
		int N = Integer.parseInt(st.nextToken()); // 시간
		
		bomb = new char[R][C];
		timer = new int[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();

			for (int j = 0; j < C; j++) {
				char info = line.charAt(j);
				bomb[i][j] = info;

				if (info == '.') {
					timer[i][j] = -1;
				}
			}
		}

		solve(R, C, N);

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(bomb[i][j]);
			}
			System.out.println();
		}
	}

	private static void solve(int R, int C, int N) {

		int count = 2;

		while(count <= N) {

			if (count % 2 == 0) { // 짝수 초일때 폭탄 설치
				setUpBomb(R, C, count);
			} else { // 홀수 초일때 폭탄 터트리기
				detonate(R, C, count);
			}
			
			count++;
		}
	}

	private static void setUpBomb(int R, int C, int count) {

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (bomb[i][j] == '.') {
					bomb[i][j] = 'O';
					timer[i][j] = count;
				}
			}
		}
	}

	private static void detonate(int R, int C, int count) {

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (bomb[i][j] == 'O' && timer[i][j] == count - 3) {
					bomb[i][j] = '.';
					timer[i][j] = -1;

					for (int k = 0; k < 4; k++) {
						int nextX = dx[k] + i;
						int nextY = dy[k] + j;
						
						if (0 <= nextX && nextX < R && 0 <= nextY && nextY < C && bomb[nextX][nextY] == 'O' && timer[nextX][nextY] != count - 3) {
							bomb[nextX][nextY] = '.';
							timer[i][j] = -1;
						}
					}
				}
			}
		}
	}
}
