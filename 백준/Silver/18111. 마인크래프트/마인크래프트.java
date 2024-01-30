import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] earth = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                earth[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;
        int height = 0;

        for (int i = 0; i <= 256; i++) { // 256층까지 검사
            int time = 0;
            int block = B;
            boolean flag = true;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (i < earth[j][k]) { // 현재 층보다 earth의 층이 더 높다면?
                        time += 2 * (earth[j][k] - i); // 해당 층만큼 지워야함 ex) 140 200 -> 60층 지워야함
                        block += earth[j][k] - i;
                    } else {
                        block -= i - earth[j][k];
                        time += i - earth[j][k];
                    }
                }
            }

            if (block < 0) {
                continue;
            }

            if (answer >= time) {
                answer = time;
                height = i;
            }
        }

        System.out.println(answer + " " + height);
    }
}
