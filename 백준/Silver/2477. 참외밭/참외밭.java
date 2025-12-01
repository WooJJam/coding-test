import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[] length = new int[6];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int melon = Integer.parseInt(br.readLine());

		int maxHeight = 0, maxWidth = 0;
		int maxHeightIndex = -1, maxWidthIndex = -1;

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());

			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());

			// 동, 서 방향이라면 세로 길이의 최대값과 인덱스를 구해야함
			if (dir <= 2 && maxHeight < len) {
				maxHeight = len;
				maxHeightIndex = i;
			}

			// 남, 북 방향이라면 가로 길이의 최대값과 인덱스를 구해야함
			if (dir > 2 && maxWidth < len) {
				maxWidth = len;
				maxWidthIndex = i;
			}

			length[i] = len;
		}

		int area = getArea(maxHeightIndex, maxWidthIndex);
		System.out.println(area * melon);
	}

	private static int getArea(int heightIndex, int widthIndex) {

		int bigArea = length[heightIndex] * length[widthIndex];
		int smallArea = getSmallAreaLength(heightIndex) * getSmallAreaLength(widthIndex);

		return bigArea - smallArea;
	}

	private static int getSmallAreaLength(int index) {
		int prevIndex = -1;
		int nextIndex = -1;

		prevIndex = index == 0 ? 5 : index - 1;
		nextIndex = index == 5 ? 0 : index + 1;

		return Math.abs(length[prevIndex] - length[nextIndex]);
	}
}
