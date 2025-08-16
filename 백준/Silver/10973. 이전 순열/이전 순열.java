import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<Integer> number = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			number.add(Integer.parseInt(st.nextToken()));
		}

		if (prevPermutation()) {
			for (int i = 0; i < N; i++) {
				System.out.print(number.get(i) + " ");
			}
		} else {
			System.out.println(-1);
		}

	}

	/**
	 * 1. 뒤에서부터 차례대로 오름차순 인지 확인해야함 (i = length - 1)
	 * -> 만약 내림차순이라면 swap을 해야하므로 해당 index를 기억하자
	 *
	 * 2. i를 기억한 뒤에 다시 마지막 부터 number[i] 보다 큰 number[j]를 찾는다.
	 * 3. i와 j를 찾았으면 swap 해야 한다.
	 * (현재 숫자가 1 3 2 4 라면.. 1 2 4 3 이 되어야 함, 그러므로 swap 한 뒤 i 이후의 순열을 뒤집어야 한다.)
	 */
	private static boolean prevPermutation() {
		int i = number.size() - 1;

		// 뒤에서부터 오름차순인지 일때까지 반복
		while(i > 0 && number.get(i - 1) <= number.get(i)) {
			i--;
		}

		if (i <= 0) {
			return false;
		}

		int j = number.size() - 1;

		while(number.get(i - 1) <= number.get(j)) {
			j--;
		}

		swap(i - 1, j);

		// swap 한 이후의 순열을 뒤집자.
		j = number.size() - 1;
		while(i < j) {
			swap(i, j);
			i++;
			j--;
		}

		return true;
	}

	private static void swap(int i, int j) {
		int temp = number.get(i);
		number.set(i, number.get(j));
		number.set(j, temp);
	}
}
