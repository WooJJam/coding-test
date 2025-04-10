import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] redundancy = initReserveClosthes(n, reserve);
        boolean[] clothes = initClothes(n, lost);
        Arrays.sort(lost);
        int count = checkHasClosthes(n, lost, redundancy, clothes);
        return n - lost.length + count;
    }
    
    static boolean[] initReserveClosthes(int n, int[] reserve) {
        
        boolean[] redundancy = new boolean[n+1];
        
        
        for (int i = 1; i <= n; i++) {
            redundancy[i] = false;
        }
        
        for (int i = 0; i < reserve.length; i++) {
            redundancy[reserve[i]] = true;
        }
        
        return redundancy;
    }
    
    static boolean[] initClothes(int n, int[] lost) {
        boolean[] clothes = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            clothes[i] = true;
        }
        
        for (int i = 0; i < lost.length; i++) {
            clothes[lost[i]] = false;
        }
        
        return clothes;
    }
    
    static int checkHasClosthes(int n, int[] lost, boolean[] redundancy, boolean[] clothes) {
        int count = 0;
        
        for (int i = 0; i < lost.length; i++) {
            
            if (redundancy[lost[i]]) { // 여벌옷을 가져온사람이 도난당할 경우 
                redundancy[lost[i]] = false;
                count ++;
                System.out.println(lost[i]);
            }
            else if (0 < lost[i] - 1 && clothes[lost[i] - 1] && redundancy[lost[i] - 1]) {
                // System.out.println(lost[i]);
                // System.out.println(redundancy[lost[i] - 1]);
                redundancy[lost[i] - 1] = false;
                System.out.println(lost[i] - 1);
                count ++;
            }
            // System.out.println(lost[i] + 1);
            // System.out.println(redundancy[lost[i]]);
            else if(lost[i] + 1 <= n && clothes[lost[i] + 1] && redundancy[lost[i] + 1]) {
                // System.out.println(lost[i]);
                // System.out.println(redundancy[lost[i] + 1 ]);
                redundancy[lost[i] + 1] = false;
                System.out.println(lost[i]);
                count ++;
            }
        }
        // System.out.println(count);
        return count;
    }
}
