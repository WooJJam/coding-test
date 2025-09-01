import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = br.readLine();
		Integer[] number = new Integer[line.length()];

		for (int i = 0; i < line.length(); i++) {
			Integer num = Integer.parseInt(String.valueOf(line.charAt(i)));
			number[i] = num;
		}

		Arrays.sort(number, Collections.reverseOrder());

		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i]);
		}
	}
}
