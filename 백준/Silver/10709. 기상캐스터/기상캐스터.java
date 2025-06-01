import java.io.*;
import java.util.*;

public class Main {

	static char[][] sky;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[][] time = new int[H][W];

		sky = new char[H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			for (int j = 0; j < W; j++) {
				sky[i][j] = input.charAt(j);
			}
		}
		
		initTime(time, H);
		solve(time, H, W);

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.printf("%d ", time[i][j]);
			}
			System.out.println();
		}
	}
	
	private static void initTime(int[][] time, int H) {

		for (int i = 0; i < H; i++) {
			Arrays.fill(time[i], -1);
		}
	}

	private static void solve(int[][] time, int H, int W) {

		for (int i = 0; i < H; i++) {
			boolean hasCloud = false;
			for (int j = 0; j < W; j++) {
				if (sky[i][j] == 'c') {
					time[i][j] += 1;
					hasCloud = true;
				} else if(hasCloud && time[i][j] == -1) {
					time[i][j] = time[i][j-1] + 1;
				}
			}
		}
	}
}
