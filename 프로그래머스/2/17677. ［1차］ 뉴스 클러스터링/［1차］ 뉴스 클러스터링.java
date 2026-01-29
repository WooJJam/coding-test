/*

A = {1, 1, 2, 2, 3}
B = {1, 2, 2, 4, 5}

1. 대 소문자 구분 X
2. 영어 알파벳만 허용
3. 문자열은 2글자씩 끊기.

집합 구하기
1. A 리스트를 순차적으로 탐색하면서 B를 찾기
1-1. B가 존재한다면 remove
1-2. 해당 요소를 교집합에 추가

2. 해당 요소를 합집합에 추가 (존재 하지 않는 경우에도 추가)



*/

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = splitString(str1);
        List<String> list2 = splitString(str2);
    
        // System.out.println(list1);
        // System.out.println(list2);
        
        return makeSet(list1, list2);
    }
    
    private static int makeSet(List<String> list1, List<String> list2) {
        
//         집합 구하기
//         1. A 리스트를 순차적으로 탐색하면서 B를 찾기
//         1-1. B가 존재한다면 remove
//         1-2. 해당 요소를 교집합에 추가
//         2. 해당 요소를 합집합에 추가 (존재 하지 않는 경우에도 추가)
        
        List<String> union = new ArrayList<>();
        List<String> inter = new ArrayList<>();
        
        for(String str: list1) {
            if(list2.contains(str)) {
                list2.remove(str);
                union.add(str);
            }
            inter.add(str);
        }
        
        inter.addAll(list2);
        
        return solve(union.size(), inter.size());
    }
    
    private static List<String> splitString(String str) {
        
        List<String> list = new ArrayList<>();
        str = str.toLowerCase();
        
        for(int i=0; i < str.length() - 1; i++) {
            String splitStr = "";
            
            splitStr += str.charAt(i);
            if (str.length() > i + 1) {
                 splitStr += str.charAt(i+1);
            }
            
            splitStr = splitStr.replaceAll("[^a-z]", "");
            
            if (splitStr.length() == 2) {
                list.add(splitStr);
            }
        }
        
        return list;
    }
    
    private static int solve(double size1, double size2) {
        
        if(size1 == 0 && size2 == 0) {
            return 65536;
        }
        
        // System.out.println(size1);
        // System.out.println(size2);
        
        double similarity = size1 / size2;
        // System.out.println(similarity);
        int answer = (int) (similarity * 65_536);
        return answer;
    }
}