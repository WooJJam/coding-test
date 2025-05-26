import java.io.*;
import java.util.*;

public class Main {
	
	static boolean[] robot;
	static int answer = 0;
	static int count;


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		robot = new boolean[N];

		st = new StringTokenizer(br.readLine());

		int[] durability = new int[N * 2];

		for (int i = 0; i < N * 2; i++) {
			durability[i] = Integer.parseInt(st.nextToken());
		}

		solve(K, durability);
		System.out.println(answer);
	}

	private static void solve(int K, int[] durability) {

		while (count < K) {
			moveBelt(durability);

			for (int i = robot.length - 2; i >= 0; i--) {

				// 오른쪽부터 로봇이 있는곳에서 시작
				if (robot[i]) {
					moveRobot(i, durability);
				}

				if (count >= K) {
					break;
				}
			}

			if (durability[0] > 0) {
				robot[0] = true;
				durability[0] -= 1;

				if (durability[0] == 0) {
					count += 1;
				}
			}

			answer += 1;
		}
	}

	// 로봇 이동
	private static void moveRobot(int index, int[] durability) {

			// 이동할 칸에 다른 로봇이 있는 경우 | 이동할 칸의 내구도가 0인 경우
			if (robot[index + 1] || durability[index + 1] == 0) {
				return;
			}

			// 1. 이동할 칸 내구도 1 감소
			durability[index + 1] -= 1;

			// 2. 현재 칸은 로봇 비우기
			robot[index] = false;

			// 3. 다음 칸에 로봇 채우기
			robot[index+1] = true;

			if (durability[index + 1] == 0) {
				count += 1;
			}

	}

	// 벨트 이동
	private static void moveBelt(int[] durability) {

		int temp = durability[durability.length-1];
		for (int i = durability.length -1; i > 0; i--) {
			durability[i] = durability[i-1];
		}
		durability[0] = temp;

		for (int i = robot.length -1; i > 0; i--) {
			robot[i] = robot[i - 1];
		}

		// 로봇이 젤 마지막에 도착한다면 내리기
		robot[robot.length -1] = false;
		robot[0] = false; // 시작점에는 로봇이 없음
	}

}
