import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		List<String> serial = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			serial.add(st.nextToken());
		}

		solve(serial);
	}

	/*
	1. 문자열의 길이가 빠를 수록
	2. 문자열의 합을 더했을 때 숫자가 낮을수록
	3. 모두 같다면 사전순으로 (숫자 < 알파벳)
	 */
	private static void solve(List<String> serial) {
		serial.sort(new CustomComparator());
		serial.forEach(System.out::println);
	}

	private static class CustomComparator implements Comparator<String> {

		@Override
		public int compare(final String o1, final String o2) {

			// 1. 길이 비교
			int value = Integer.compare(o1.length(), o2.length());
			if (value != 0) {
				return value;
			}

			// 2. 문자열의 합
			value = Integer.compare(sumOfDigits(o1), sumOfDigits(o2));
			if (value != 0) {
				return value;
			}

			return o1.compareTo(o2);
		}

		private static int sumOfDigits(String s) {

			int sum = 0;
			for (char c : s.toCharArray()) {
				if (Character.isDigit(c)) {
					sum += c - '0';
				}
			}

			return sum;
		}
	}

}
