class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = solve(players, m, k);
        return answer;
    }
    
    /*
    시간별 서버의 갯수 * m <= 시간별 사용인원
    - 서버 늘려야함
    - 시간별 사용인원 / 시간별 서버의 갯수 * m 만큼 늘리기
    
    10 / 0
    */
    
    private static int solve(int[] players, int m, int k) {
        int[] servers = new int[24];
        int answer = 0;
        
        for (int i = 0; i < 24; i++) {
            int user = players[i];
            int server = servers[i];
            int addServer = 0;
            // print(servers);
            
            if (server == 0) {
                addServer = user / m;
            } else {
                if (server * m < user) {
                    int needServer = user / m;
                    addServer = needServer - server;
                }
            }
            
            servers[i] += addServer;
            // System.out.println("addServer = " + addServer);
            // System.out.println("server = " + server);
            // System.out.println("user = " + user);
            
            for (int j = i + 1; j < i + k; j++) {
                // System.out.println("j = " + j);
                if (j >= 24) {
                    break;
                }
                
                servers[j] += addServer;
            }
            
            answer += addServer;
        }
        
        return answer;
    }
    
    private static void print(int[] servers) {
        
        for (int i = 0; i < 24; i++) {
            System.out.printf("%d ", servers[i]);
        }
        System.out.println();
    }
}

/*

서버 증설의 조건: n * m <= 이용자 수 < (n + 1) * m --> 최소 n대의 서버가 운영중
서버 운영 시간: k --> 10시에 증설 + K = 10 + k 까지 유지
판단 기준 : m
유지 시간 : k

players: [0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0]
시간별 사용인원:   [0, 0, 0, 10, 0, 12, 0, 15, 0, 1]
시간별 서버의 갯수: [0, 0, 0, 2, 2, 3, 3, 3, 1, 1]

시간별 서버의 갯수 * m <= 시간별 사용인원
    - 서버 늘려야함
    - 시간별 사용인원 / 시간별 서버의 갯수 * m 만큼 늘리기

3~4시 : 10명, 수용인원 5명 .. 
    if 시간별 사용인원 >= 수용인원-> 인원수 / m
        10 >= 5 --> 10 // 5 = 2
시간별 서버의 갯수: [0, 0, 0, 2, 2, 2, 2, 2]


*/