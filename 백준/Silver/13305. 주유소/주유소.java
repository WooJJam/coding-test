import java.io.*;
import java.util.*;

public class Main {

	/*
	5 --2--> 2 --3--> 4 --1--> 1

	prev = 5
	next = 2
	distance = 2
	if next > prev: // 다음 역이 더 비싸면 현재 역에서 최대한 많이 주입
		distance += 2; // 첫번째 이동 거리
	else (next <= prev) // 다음 역이 더 싸고, 현재 역이 비싸다면 현재 역에서는 다음 역까지의 기름만 더함
		기름양 += prev * distance;
		prev = next;

	next = next + 1;

	prev = 2
	next = 4
	distance = 0
	기름양 = 2

	if next > prev: // 다음 역이 더 비싸면 현재 역에서 최대한 많이 주입
		distance += 3; // 첫번째 이동 거리
		next = next + 1;

	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] distance = new int[N - 1];
		int[] oil = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			oil[i] = Integer.parseInt(st.nextToken());
		}

		solve(N, distance, oil);

	}

	/*
	if next > prev: // 다음 역이 더 비싸면 현재 역에서 최대한 많이 주입
		distance += 2; // 첫번째 이동 거리
	else (next <= prev) // 다음 역이 더 싸고, 현재 역이 비싸다면 현재 역에서는 다음 역까지의 기름만 더함
		기름양 += prev * distance;
		prev = next;
	 */
	private static void solve(int N, int[] distance, int[] oil) {

		int cur = 0;
		int next;
		long totalOil = 0;
		long totalDistance = 0;

		for (next = cur + 1; next < N - 1; next++) {
			totalDistance += distance[next - 1];
			if (oil[next] < oil[cur]) {
				totalOil += (oil[cur] * totalDistance);
				cur = next;
				totalDistance = 0;
			}
		}

		totalOil += (oil[cur] * (totalDistance + distance[next - 1]));

		System.out.println(totalOil);
	}
}
