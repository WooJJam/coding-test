import java.security.Key;
import java.util.*;
import java.io.*;

import javax.lang.model.element.Name;

public class Main {

	static PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> {
		int absX = Math.abs(x);
		int absY = Math.abs(y);

		if (absX == absY) {
			return x < y ? -1 : 1;
		}

		return absX < absY ? -1 : 1;
	});

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (pq.size() == 0) {
					bw.write("0\n");
				} else {
					bw.write(pq.poll() + "\n");
				}
			} else {
				pq.add(x);
			}
		}

		bw.flush();
		bw.close();
	}
}