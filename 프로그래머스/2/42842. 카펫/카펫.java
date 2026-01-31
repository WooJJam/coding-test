/*
brown : 10
yellow : 2

가로: 4
세로: 3

brown: 8
yellow: 1

1 * 8
2 * 4
4 * 2

000
0X0
000

brown: 24
yellow: 24

XXXXXXXX
X000000X
X000000X
X000000X
X000000X
XXXXXXXX

48
16 * 3
= (16 * 2)  + (3 - 2) * 2 = 32 + 2 = 34
12 * 4
= (12 * 2) + (4 - 2) * 2 = 24 + 4 = 28
8 * 6
= (8 * 2) + (6 - 2) * 2
= 16 + 8 = 24

6 * 8 --> 세로가 더 길면 안됨.
*/

class Solution {
    public int[] solution(int brown, int yellow) {
        return solve(brown, yellow);
    }
/*

48
(3, 16)
(4, 12)
(6, 8)
16 * 3
= (16 * 2)  + (3 - 2) * 2 = 32 + 2 = 34

12 * 4
= (12 * 2) + (4 - 2) * 2 = 24 + 4 = 28

8 * 6
= (8 * 2) + (6 - 2) * 2
= 16 + 8 = 24

*/
    private static int[] solve(int brown, int yellow) {
        
        int[] answer = new int[2];
        
        int total = brown + yellow;
        
        for (int i = 3; i < total; i++) {
            int width = total / i;
            int grid = (width * 2) + ((i - 2) * 2);
            
            if (width < i) {
                break;
            }
            
            if (grid == brown) {
                answer[0] = width;
                answer[1] = i;
            }
        }
        
        return answer;
    }
}