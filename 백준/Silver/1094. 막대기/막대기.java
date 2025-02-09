import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int x = Integer.parseInt(br.readLine());
		String result = Integer.toBinaryString(x);
		long count = result.chars().filter(c -> c == '1').count();
		bw.write((int)count+"\n");
		bw.flush();
		bw.close();
	}
}
