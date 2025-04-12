import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {

        return solve(scoville, K);
    }
    
    static int solve(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int count = 0;

		for (int d: scoville) {
			pq.add(d);
		}

		while (pq.size() > 1) {
			int first = pq.poll();
			int second = pq.poll();

			if (first >= K) {
				return count;
			}

			int result = first + (second * 2);

			pq.add(result);
			count++;
		}
        
        if (pq.size() > 0) {
            return pq.peek() > K ? count : -1;
        }

		return -1;
	}
}