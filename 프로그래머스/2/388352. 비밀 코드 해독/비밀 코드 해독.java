import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        int[] code = new int[5];
        combination(n, q, ans, 0, 0, code);

        return answer;
    }
    
    /*
    백트래킹의 depths는 최대 5
    for 반복문으로 1~30까지 값을 생성. 첫 시작은 매번 파라미터로 기억해야한다.
    */
    private static void combination(int n, int[][] q, int[] ans, int depth, int start, int[] code) {
        
        if(depth == 5) {
            if (retain(q, code , ans)) {
                answer++;
                // print(code);
            }
            return;
        }
        
        for (int i = start + 1; i <= n; i++) {
            code[depth] = i;
            combination(n, q, ans, depth + 1, i, code);
        }
    }
    
    private static boolean retain(int[][] q, int[] code, int[] ans) {
        
        int m = q.length;
        
        Set<Integer> setA = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            setA.add(code[i]);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if(setA.contains(q[i][j])) {
                    count++;
                }
            }
            
            // System.out.println(count);
            
            result.add(count);
        }
        
        for(int i = 0; i < m; i++) {
            if(result.get(i) != ans[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    private static void print(int[] code) {
        
        for(int i = 0; i < 5; i++) {
            System.out.printf("%d, ", code[i]);
        }
        System.out.println();
    }
}

/*

1. 30개중에 5개를 뽑는 조합 메소드 구현 -> 백트래킹
2. 5개를 뽑았다면 q 2차원 배열의 교집합을 구한다.
    - 교집합의 수가 0이라면 비밀코드가 아니므로 pass

*/