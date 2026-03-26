import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        
       return solve(sequence, k);
    }
    
    private static int[] solve(int[] sequence, int k) {
        
        int left = 0;
        int right = left + 1;
        
         if (sequence[left] == k) {
            return new int[] {left, left};
        }
        
        int sum = sequence[left] + sequence[right];
        int min = 0;
        int max = 0;
        int size = Integer.MAX_VALUE;
     
        while(right < sequence.length && left <= right) {
        
            
            if(sum < k) { // k가 더 크다면 right를 증가시키고, right 인덱스를 더하자.
                right++;
                
                if (right < sequence.length) {
                    sum += sequence[right];
                }
                
            } else {
                if (sum == k) { // k와 같다면 left를 증가시키고, 현재 배열의 길이와 left 인덱스의 값을 기록해놓자.
                    int curSize = right - left + 1;
                    if (size > curSize) {
                        size = curSize;
                        min = left;
                        max = right;
                    }
                    sum -= sequence[left++];
                }
                else { // sum이 더 크다면 left를 증가시키고
                    sum -= sequence[left++];
                }
            }
        }
        
        return new int[] {min, max};
    }
}
/*
1, 2, 3, 5, 8, 12, 17
1, 1, 1, 1, 3, 4, 5

1 = 1
2 = 1 or 1+1 = 2
3 = 1 or 1+1+1 = 3
4 = 2 or 1+1+1+1 = 4
5 = 3 or 1+1+1+1+3 = 7

2 -> 길이 2, 값 2
3 -> 길이 3, 값 3
4 -> 길이 4, 값 4
5 -> 길이 5, 값 7 만약 합이 5보다 커진다면 

sequence의 길이는 최대 1,000,000 -> 최대 시간복잡도를 N으로 끝내야함.. 1번의 반복문.. DP or 누적합
*/