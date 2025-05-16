import java.util.*;

class Solution {
    
    static List<M> mineralsCount = new ArrayList<>();
    
    public int solution(int[] picks, String[] minerals) {
        
        int picksCount = 0;
        for(int pick: picks) {
            picksCount += pick;
        }
        
        int totalCount = Math.min(picksCount * 5, minerals.length);
        groupMinerals(minerals, totalCount);
        
        System.out.println(mineralsCount);
        return usePicks(picks);
    }
    
    static void groupMinerals(String[] minerals, int totalCount) {
        
        int groupId = 0;
        mineralsCount.add(new M(0, 0, 0));
        
        for(int i = 1; i <= totalCount; i++) {
            M m = mineralsCount.get(groupId);
            
            calculateTired(minerals[i-1], m);
            
            if (i % 5 == 0) {
                groupId += 1;
                mineralsCount.add(new M(0, 0, 0));
            }
        }
        
        mineralsCount.sort((m1, m2) -> Integer.compare(m2.stoneCnt, m1.stoneCnt));
    }
    
    static void calculateTired(String mineral, M m) {
        
        if (mineral.equals("diamond")) {
            m.diaCnt += 1;
            m.ironCnt += 5;
            m.stoneCnt += 25;
        }
        
        if (mineral.equals("iron")) {
            m.diaCnt += 1;
            m.ironCnt += 1;
            m.stoneCnt += 5;
        }
        
        if (mineral.equals("stone")) {
            m.diaCnt += 1;
            m.ironCnt += 1;
            m.stoneCnt += 1;
        }
    }
    
    static int usePicks(int[] picks) {
        
        int answer = 0;
        
        for(M m: mineralsCount) {
            if(picks[0] > 0) {
                picks[0] -= 1;
                answer += m.diaCnt;
            }
            
            else if(picks[1] > 0) {
                picks[1] -= 1;
                answer += m.ironCnt;
            }
            
            else if(picks[2] > 0) {
                picks[2] -= 1;
                answer += m.stoneCnt;
            }
        }
        
        return answer;
    }
    
    static class M {
        int diaCnt;
        int ironCnt;
        int stoneCnt;
        
        M (int diaCnt, int ironCnt, int stoneCnt) {
            this.diaCnt = diaCnt;
            this.ironCnt = ironCnt;
            this.stoneCnt = stoneCnt;
        }
        
        @Override
		public String toString() {
			return "M{" +
				"diaCnt=" + diaCnt +
				", ironCnt=" + ironCnt +
				", stoneCnt=" + stoneCnt +
				'}';
		}
    }
    
}