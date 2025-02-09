import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int x = Integer.parseInt(br.readLine());
		int bar = 64;
		int result = 0;
        
		while (x > 0) {
			if (bar > x) {
				bar /= 2;
			} else {
				x -= bar;
				result += 1;
			}
		}
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}
}