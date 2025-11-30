import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static ArrayList<Integer>[] rectangle;
	static Map<Integer, Integer> rectangleMap = new HashMap<>();
	static int[] length = new int[6];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int melon = Integer.parseInt(br.readLine());
		rectangle = new ArrayList[5];

		for (int i = 0; i < 5; i++) {
			rectangle[i] = new ArrayList<>();
		}

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());

			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());

			rectangleMap.put(dir, rectangleMap.getOrDefault(dir, 0) + 1);
			rectangle[dir].add(i);
			length[i] = len;

		}

		int[] longestLength = getLongestLength();

		int rectangleArea = getRectangleArea(longestLength);


		System.out.println(rectangleArea * melon);

		// for (int i = 1; i < 5; i++) {
		// 	System.out.println("i = " + i + " : "+ rectangle[i]);
		// }
		// System.out.println(getAnswer(melon, totalArea));
	}

	private static int[] getLongestLength() {

		int[] longestLen = new int[2];
		int index = 0;

		for(Map.Entry<Integer, Integer> entry: rectangleMap.entrySet()) {
			int dir = entry.getKey();
			int count = entry.getValue();

			// 횟수가 1회라면 그 길이가 최대 길이이므로 최대 사각형의 길이
			if (count == 1) {
				longestLen[index++] = dir;
			}
		}

		// for (int i = 0; i < 2; i++) {
		// 	System.out.println(longestLen[i]);
		// }

		return longestLen;
	}

	private static int getRectangleArea(int[] longestLength) {

		// for (int i = 0; i < 2; i++) {
		// 	System.out.println("longestLength = " + longestLength[i]);
		// }
		int maxLenA = rectangle[longestLength[0]].get(0);
		int maxLenB = rectangle[longestLength[1]].get(0);

		// System.out.println(maxLenA);
		// System.out.println(maxLenB);
		int smallAreaLenA = 1;
		int smallAreaLenB = 1;
		int smallRectangleArea = 1;
		int bigRectangleArea = length[maxLenA] * length[maxLenB];

		if (maxLenA == 0) {
			smallAreaLenA = Math.abs(length[5] - length[1]);
		} else if (maxLenA == 5) {
			smallAreaLenA = Math.abs(length[4] - length[0]);
		} else {
			smallAreaLenA = Math.abs(length[maxLenA - 1] - length[maxLenA + 1]);
		}

		if (maxLenB == 0) {
			smallAreaLenB = Math.abs(length[5] - length[1]);
		} else if (maxLenB == 5) {
			smallAreaLenB = Math.abs(length[4] - length[0]);
		} else {
			smallAreaLenB = Math.abs(length[maxLenB - 1] - length[maxLenB + 1]);
		}

		// System.out.println("smallAreaLenA = " + smallAreaLenA);
		// System.out.println("smallAreaLenB = " + smallAreaLenB);

		smallRectangleArea = smallAreaLenA * smallAreaLenB;

		// System.out.println("bigRectangleArea = " + bigRectangleArea);
		// System.out.println("smallRectangleArea = " + smallRectangleArea);

		return bigRectangleArea - smallRectangleArea;
	}

	private static int getAnswer(int melon, int totalArea) {
		return melon * totalArea;
	}
}

/*
7
4 160
2 30
3 60
1 20
3 100
1 10
 */
