import java.security.Key;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
		}

		for (int i = 0; i < N-1; i++) {
			pq.poll();
		}

		bw.write(pq.poll()+"\n");
		bw.flush();
		bw.close();
	}
}