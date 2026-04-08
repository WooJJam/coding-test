import java.io.*;
import java.util.*;

public class Main {

	static int[][] board;
	static HashMap<Integer, Integer> direction = new HashMap<Integer, Integer>();
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	private static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		board = new int[N][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			board[x - 1][y - 1] = 1;
		}

		int L = Integer.parseInt(br.readLine());

		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();

			if (dir.equals("D")) {
				direction.put(time, 1);
			} else {
				direction.put(time, -1);
			}
		}

		int answer = solve(N, K);
		System.out.println(answer);

	}

	/*
	1. 시간 증가
	2. 사과 존재여부 확인
		- 사과가 없다면
			-> q.offer(머리좌표)
			-> 머리좌표를 -1로 수정
			-> 꼬리좌표 = q.pop()
			-> 꼬리좌표를 0으로 수정
	3. 머리 이동
	4. 방향 돌리기

	종료 조건
		- 머리 위치가 벽
		- 머리 위치가 몸통
		- 사과를 다 먹은 경우
	 */
	private static int solve(int N, int K) {

		int time = 0;
		int dir = 0;
		int nextX = 0;
		int nextY = 0;

		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0, 0));
		board[nextX][nextY] = -1;

		while (true) {
			// print(N);
			time ++;

			nextX += dx[dir];
			nextY += dy[dir];

			// 다음 위치가 벽이거나 자기의 몸이라면 종료
			if (0 > nextX || nextX >= N || 0 > nextY || nextY >= N || board[nextX][nextY] == -1) {
				break;
			}

			move(q, nextX, nextY);

			if (direction.containsKey(time)) {
				dir += direction.get(time);

				if (dir > 3) {
					dir = 0;
				} else if (dir < 0) {
					dir = 3;
				}
			}
		}

		return time;

	}

	private static void move(Queue<Node> q, int nextX, int nextY) {

		// 다음 위치에 사과가 없는 경우
		if (board[nextX][nextY] != 1) {
			Node node = q.poll();
			board[node.x][node.y] = 0;
		}

		board[nextX][nextY] = -1;
		q.offer(new Node(nextX, nextY));
	}

	private static void print(int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.printf("%d ", board[i][j]);
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}
}

/*

게임 방법
1. 뱀의 처음 위치는 (0, 0) 방향은 오른쪽
2. 머리를 늘려 다음칸에 위치시킴
3. 머리가 벽이나 자신의 몸과 부딪히면 게임 종료
4. 머리가 이동한 칸에 사과가 있다면 사과는 없어지고 몸길이 증가 (꼬리 좌표 그대로)
5. 머리가 이동한 칸에 사과가 없다면 몸길이 감소 (꼬리 삭제)

input
- N : 보드의 크기
- K : 사과의 개수
- x, y :  사과의 행, 열 -> K 만큼 존재
- L : 뱀의 방향 변환 횟수
- time, dir : 뱀이 방향 전환을 진행할 시간, 방향 (D : 오른쪽, L : 왼쪽)

 */
