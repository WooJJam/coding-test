import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

	static char[] formular = new char[] {' ', '+', '-'};
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			char[] ops = new char[N - 1];
			backtracking(N, 0, ops);
			sb.append('\n');
		}

		System.out.println(sb.toString());

	}

	private static void backtracking(int N, int depth, char[] ops) {

		if (depth >= N - 1) {
			// System.out.println("------------");
			// for (int i = 0; i < ops.length; i++) {
			// 	System.out.print(ops[i] + ", ");
			// }
			// System.out.println();
			if (calculate(ops, N)) {
				print(ops);
			};
			// System.out.println();
			return;
		}

		for (int j = 0; j < 3; j++) {
			ops[depth] = formular[j];
			backtracking(N, depth + 1 , ops);
			// expression.remove(depth + 1);
		}

	}

	private static boolean calculate(char[] ops, int N) {

		ArrayList<Integer> number = new ArrayList<>();
		int[] array = new int[N];
		int index = 0;

		for (int i = 0; i < N; i++) {
			number.add(i + 1);
		}

		array[0] = 1;

		for (int i = 0; i < ops.length; i++) {
			if (ops[i] == ' ') {
				array[index] = array[index] * 10 + number.get(i + 1);
			} else {
				array[++index] = number.get(i + 1);
			}

		}

		// for (int i = 0; i < array.length; i++) {
		// 	System.out.print(array[i] + ", ");
		// }
		// System.out.println();

		// while (index < N) {
		//
		// 	if (index < N - 1 && ops[index] == ' ') {
		// 		number.add(index,number.get(index) * 10 + (num++));
		// 		// number.add((index + 1) * 10 + (index + 2));
		// 		// index+=2;
		// 	} else {
		// 		number.add(num++);
		// 	}
		//
		// 	index++;
		//
		// }

		index = 0;
		int answer = array[index];

		for (int i = 0; i < ops.length; i++) {
			if (ops[i] == ' ') {
				continue;
			}

			if (ops[i] == '+') {
				answer += array[index + 1];
			}

			if (ops[i] == '-') {
				answer -= array[index + 1];
			}

			index++;

		}

		// System.out.println("answer = " + answer);

		if (answer == 0) {
			return true;
			// sb.append(number[0]);
			//
			// for (int i = 0; i < ops.length; i++) {
			// 	sb.append(ops[i]).append(number[i+1]);
			// }
			// sb.append('\n');
		}

		return false;
	}

	private static void print(char[] ops) {

		sb.append(1);

		for (int i = 0; i < ops.length; i++) {
			sb.append(ops[i]).append(i + 2);
		}

		sb.append('\n');
	}
/*
 , ,-,+,-,-
 */
}
