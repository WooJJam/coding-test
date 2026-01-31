/*

최소 공배수는 두 수의 곱에서 최대 공약수를 나눈 값

수가 4개라면?
2, 6, 8, 14

최소 공배수는 두 수의 곱 / gcd(두 수);

2와 6의 최소 공배수 = 6
6과 8의 최소 공배수 = 24
24와 14의 최소 공배수 = 168

2 14, 8
  7   4

*/

import java.util.*;

class Solution {
    public int solution(int[] arr) {
        return solve(arr);
    }
    
    private static int solve(int[] arr) {
        
        if (arr.length == 1) {
            return arr[0];
        }
        
        arr = Arrays.stream(arr).boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
        
        // for(int i = 0; i < arr.length; i++) {
        //     System.out.println(arr[i]);
        // }
        
        int gcdValue = gcd(arr[0], arr[1]);
        int x = (arr[0] * arr[1]) / gcd(arr[0], arr[1]);
        
        for(int i = 2; i < arr.length; i++) {
            x = (x * arr[i]) / gcd(x, arr[i]);
            System.out.println(x);
        }
        
        return x;
    }
    
    
    private static int gcd(int x, int y) {
        
        if (y == 0) {
            return x;
        }
        
        return gcd(y, x%y);
    }
}