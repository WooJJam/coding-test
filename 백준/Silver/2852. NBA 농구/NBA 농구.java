import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int times[] = new int[2881];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int teamNo = Integer.parseInt(st.nextToken());
			String[] strTime = st.nextToken().split(":");

			int hour = Integer.parseInt(strTime[0]);
			int minute = Integer.parseInt(strTime[1]);

			int goalTime = hour * 60 + minute;

			times[goalTime] = teamNo;
		}

		solve(times);
	}
	
	private static void solve(int[] times) {

		int team1GoalCnt = 0;
		int team2GaolCnt = 0;
		int team1Timer = 0;
		int team2Timer = 0;

		int time = 0;

		while (time <= 2880) {

			if (team1GoalCnt > team2GaolCnt) {
				team1Timer ++;
			}

			if (team1GoalCnt < team2GaolCnt) {
				team2Timer ++;
			}


			if (times[time] != 0) {
				if (times[time] == 1) {
					team1GoalCnt++;
				} else {
					team2GaolCnt++;
				}
			}

			time++;
		}

		getTimeFormat(team1Timer);
		getTimeFormat(team2Timer);
	}

	private static void getTimeFormat(int timer) {

		int hour = timer / 60;
		int min = timer % 60;

		System.out.printf("%02d:%02d%n", hour, min);
	}
}
