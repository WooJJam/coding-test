import java.io.*;
import java.util.*;

import org.w3c.dom.Node;

/*
F : 총 건물의 층
S : 현재 위치
G : 목적지
U : U층 위로
D : D층 아래로
 */
public class Main {

	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		visited = new boolean[F + 1];
		visited[0] = true;

		int result = bfs(F, S, G, U, D);
		if (result == -1) {
			System.out.println("use the stairs");
		} else {
			System.out.println(result);
		}
	}

	private static int bfs(int total, int cur, int goal, int up, int down) {

		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(cur, 0));

		while(!q.isEmpty()) {
			Node node = q.poll();
			int curStair = node.stair;
			int moveCnt = node.move;

			if(curStair == goal) {
				return moveCnt;
			}

			if(curStair <= 0 || curStair > total || visited[curStair]) {
				continue;
			}

			visited[curStair] = true;
			q.offer(new Node(curStair + up, moveCnt + 1));
			q.offer(new Node(curStair - down, moveCnt + 1));
		}

		return -1;
	}

	/*
	class
	현재의 층
	이동 횟수
	 */
	static class Node {
		 int stair;
		 int move;

		 public Node(final int stair, final int move) {
			 this.stair = stair;
			 this.move = move;
		 }

	}
}
