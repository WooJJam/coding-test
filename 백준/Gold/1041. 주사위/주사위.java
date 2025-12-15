import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] dice = new int[6];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 6; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}

		if (N == 1) {
			System.out.println(Arrays.stream(dice).sum() - Arrays.stream(dice).max().getAsInt());
		} else {
			long threeViewCount = 4;
			long twoViewCount = (8 * N) - 12;
			long oneViewCount = (5 * (long)Math.pow(N, 2)) - (16 * N) + 12;

			long answer = getThreeViewMinValue(threeViewCount) + getTwoViewMinValue(twoViewCount) + getOneViewValue(oneViewCount);
			System.out.println(answer);
		}

	}

	public static long getThreeViewMinValue(long threeViewCount) {
		return threeViewCount * (Math.min(dice[0], dice[5]) + Math.min(dice[1], dice[4]) + Math.min(dice[2], dice[3]));
	}

	public static long getTwoViewMinValue(long twoViewCount) {

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 6; i++) {
			for (int j = i + 1; j < 6; j++) {
				if (i + j != 5) {
					min = Math.min(min, dice[i] + dice[j]);
				}
			}
		}

		return twoViewCount * min;
	}


	public static long getOneViewValue(long oneViewCount) {
		return oneViewCount * Arrays.stream(dice).min().getAsInt();
	}
}
