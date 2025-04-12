import java.util.*;

class Solution {
    
    static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        return bfs(maps);
    }
    
    static int bfs(int[][] maps) {
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] {0, 0, 1});

		while(!q.isEmpty()) {
			int[] data = q.poll();
			int y = data[0];
			int x = data[1];
			int count = data[2];

			if (y == maps.length -1 && x == maps[0].length -1) { // 상대 진영에 도착하면 바로 return
				return count;
			}

			for (int i = 0; i < 4; i++) {
				int nextY = y + dy[i];
				int nextX = x + dx[i];

				if (0 <= nextY && nextY < maps.length && 0 <= nextX && nextX < maps[0].length && maps[nextY][nextX] == 1) {
					maps[nextY][nextX] = 0;
					q.offer(new int[] {nextY, nextX, count + 1});
				}
			}
		}

		return -1;
	}
}