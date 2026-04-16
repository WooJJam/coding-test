class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = solve(players, m, k);
        return answer;
    }
    
    private static int solve(int[] players, int m, int k) {
        int[] servers = new int[24];
        int answer = 0;
        
        for (int i = 0; i < 24; i++) {
            int user = players[i];
            int server = servers[i];
            int addServer = 0;
            
            if (server == 0) {
                addServer = user / m;
            } else {
                if (server * m < user) {
                    int needServer = user / m;
                    addServer = needServer - server;
                }
            }
            
            servers[i] += addServer;

            
            for (int j = i + 1; j < i + k; j++) {
                if (j >= 24) {
                    break;
                }
                
                servers[j] += addServer;
            }
            
            answer += addServer;
        }
        
        return answer;
    }
}
