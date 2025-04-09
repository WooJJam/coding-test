import java.util.*;
import java.math.*;

class Solution {
    public List<Integer> solution(int[] answers) {
    
        return solve(answers);
    }
    
    static List<Integer> solve(int[] answers) {

		int[] a = {1, 2, 3, 4, 5};
		int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		int a_count = 0;
		int b_count = 0;
		int c_count = 0;

		for (int i = 0; i < answers.length; i++) {
			if (a[i % 5] == answers[i]) {
				a_count += 1;
			}

			if (b[i % 8] == answers[i]) {
				b_count += 1;
			}

			if (c[i % 10] == answers[i]) {
				c_count += 1;
			}
		}
		
		return get_result(a_count, b_count, c_count);
	}
	
	static List<Integer> get_result(int a_count, int b_count, int c_count) {

		int max = Math.max(Math.max(a_count, b_count), c_count);
		
		List<Integer> answer = new ArrayList<>();

		if (max == a_count) {
			answer.add(1);
		}

		if (max == b_count) {
			answer.add(2);
		}

		if (max == c_count) {
			answer.add(3);
		}
		
		return answer;
	}
}