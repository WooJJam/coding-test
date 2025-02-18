import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		if (N == 1) {
			bw.write("1\n");
		} else if (N == 2) {
			bw.write(Math.min((M + 1) / 2, 4) +"\n");
		}
		else if (M < 7) {
			bw.write(Math.min(M, 4)+ "\n");
		} else {
			bw.write((M-2)+"\n");
		}

		bw.flush();
		bw.close();
	}
}