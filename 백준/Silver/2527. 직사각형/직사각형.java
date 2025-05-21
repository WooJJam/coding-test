import java.io.*;
import java.util.*;

import org.w3c.dom.Node;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());

			solve(x1, y1, p1, q1, x2, y2, p2, q2);
		}

	}

	private static void solve(int x1, int y1, int p1, int q1, int x2, int y2, int p2, int q2) {

		// 서로 겹치지 않는 경우
		if (p1 < x2 || y1 > q2 || x1 > p2 || q1 < y2) {
			System.out.println("d");
		}


		// 점으로 만나는 경우
		else if((q1 == y2 && x1 == p2 ) || (x1 == p2 && y1 == q2) || (q2 == y1 && p1 == x2) || (p1 == x2 && q1 == y2)) {
			// System.out.println("\n=================");
			// System.out.printf("x1 = %d, y1 = %d, p1 = %d, q1 = %d", x1, y1, p1, q1);
			// System.out.println();
			// System.out.printf("x2 = %d, y2 = %d, p2 = %d, q2 = %d", x2, y2, p2, q2);
			System.out.println("c");
		}

		else if(q1 == y2 || x1 == p2 || q2 == y1 || p1 == x2) {
			System.out.println('b');
		}

		else {
			System.out.println("a");
		}
	}
}
