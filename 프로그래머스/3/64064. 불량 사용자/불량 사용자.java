import java.util.*;

class Solution {
    
    static int answer = 0;
    static boolean[] visited;
    static HashSet<List<String>> set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {

        String[] candidate = new String[banned_id.length];
        visited = new boolean[user_id.length];
        
        select(user_id, banned_id, 0, candidate);
        
        // return answer;
        return set.size();
    }
    
    private static void select(String[] user_id, String[] banned_id, int depth, String[] candidate) {
        
        if (depth == banned_id.length) {
            if (isCheck(banned_id, candidate)) {
                String[] copy = candidate.clone();
                Arrays.sort(copy);
                set.add(Arrays.asList(copy));
                answer++;
            }
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            
            if (visited[i]) {
                continue;
            }
            
            candidate[depth] = user_id[i];
            visited[i] = true;
            select(user_id, banned_id, depth + 1, candidate);
            visited[i] = false;
        }
        
    }
    
//     2. user_id를 순회하며 문자열을 직접 비교한다.
//     - user_id의 문자열 길이 != banned_id의 문자열 길이
//         -> 무조건 불가능
//     - banned_id에 *가 있을 때
//         - user_id에서 해당 인덱스 번째에 문제가 존재한다면 pass
//         - user_id에서 해당 인덱스 번째에 문재가 없다면 불가능한 경우 -> continue
//     - banned_id에 *가 없을 때
//         - user_id와 banned_id의 인덱스를 같이 증가하면서 일치한다면 pass
//         - 만약 일치하지 않다면 불가능한 경우 -> continue
    
//     - 끝가지 비교하였을때 문제가 없다면 제제 아이디 경우의 수임
//         -> 해당 제제아이디 count 증가
    
    private static boolean isCheck(String[] banned_id, String[] candidate) {
        
        int index = 0;
        
        for(int i = 0; i < candidate.length; i++) {
            if (candidate[i].length() != banned_id[i].length()) {
                return false;
            }
            
            for (int j = 0; j < banned_id[i].length(); j++) {
                if (banned_id[i].charAt(j) == '*') {
                    continue;
                }
                
                // 2개의 문자열이 다르다면 해당 후보군은 불가능 하므로 return false
                if (banned_id[i].charAt(j) != candidate[i].charAt(j)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private static void print(int size, String[] candidate) {
        
        for (int i = 0; i < size; i++) {
            System.out.printf("%s ", candidate[i]);
        }
        System.out.println();
    }
}

/*


유저 id 
    - 문자열 길이 -> 8
    - 소문자와 숫자로 이루어짐
    - 중복 X

frodo, abc123
fradi, abc123
frodoc ->안딤

userID = 8, 문자열 길이 = 8 -> 8*8

1. user_id 배열 중 banned_id의 개수만큼 뽑는다 (조합 8 c 8)
2. user_id를 순회하며 문자열을 직접 비교한다.
    - user_id의 문자열 길이 != banned_id의 문자열 길이
        -> 무조건 불가능
    - banned_id에 *가 있을 때
        - user_id에서 해당 인덱스 번째에 문제가 존재한다면 pass
        - user_id에서 해당 인덱스 번째에 문재가 없다면 불가능한 경우 -> continue
    - banned_id에 *가 없을 때
        - user_id와 banned_id의 인덱스를 같이 증가하면서 일치한다면 pass
        - 만약 일치하지 않다면 불가능한 경우 -> continue
    
    - 끝가지 비교하였을때 문제가 없다면 제제 아이디 경우의 수임
        -> 해당 제제아이디 count 증가
    
3. 1개의 banned_id당 user_id 순회가 종료될 경우
    - 
    
0 2, 1 2, 1, 0

*/