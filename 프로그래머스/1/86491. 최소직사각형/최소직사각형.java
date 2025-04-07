import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = solve(sizes);
        return answer;
    }
    
    static int solve(int[][] sizes) {

		List<Integer> h = new ArrayList<>();
		List<Integer> w = new ArrayList<>();
		for (int i = 0; i < sizes.length; i++) {
			if (sizes[i][0] > sizes[i][1]) {
				w.add(sizes[i][0]);
				h.add(sizes[i][1]);
			} else {
				w.add(sizes[i][1]);
				h.add(sizes[i][0]);
			}
		}

		h.sort(Comparator.reverseOrder());
		w.sort(Comparator.reverseOrder());

		return h.get(0) * w.get(0);
	}
}