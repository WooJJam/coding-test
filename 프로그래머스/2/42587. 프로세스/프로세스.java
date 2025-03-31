import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
       

		Integer[] order = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
		Arrays.sort(order, Collections.reverseOrder());

		Queue<Integer> order_queue = new LinkedList<>();

		for (int i = 0; i < order.length; i++) {
			order_queue.offer(order[i]);
		}

		return solve(priorities, order_queue, location);        
    }
    
    static int solve(int[] priorities, Queue<Integer> order_queue, int location) {

		int count = 0;

		while (!order_queue.isEmpty()) {
			for (int i = 0; i < priorities.length; i++) {
				if (order_queue.peek().equals(priorities[i])) {
					count ++;
					order_queue.poll();

					if (i == location) {
						return count;
					}
				}
			}
		}
		return count;
	}
}