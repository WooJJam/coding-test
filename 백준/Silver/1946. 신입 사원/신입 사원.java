import java.io.*;
import java.util.*;

public class Main {

	static class Grade {
		int document;
		int interview;

		public Grade(final int document, final int interview) {
			this.document = document;
			this.interview = interview;
		}

		@Override
		public String toString() {
			return "Grade{" +
				"document=" + document +
				", interview=" + interview +
				'}';
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			ArrayList<Grade> grades = new ArrayList<>();
			int N = Integer.parseInt(br.readLine());

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				int document = Integer.parseInt(st.nextToken());
				int interview = Integer.parseInt(st.nextToken());
				Grade grade = new Grade(document, interview);
				grades.add(grade);
			}

			grades.sort(Comparator.comparingInt(a -> a.document));
			bw.write(solve(N, grades) + "\n");
		}
		bw.flush();
		bw.close();
	}

	private static int solve(int N, final ArrayList<Grade> grades) {

		int fallCount = 0;
		int min = grades.get(0).interview;

		for (int i = 1; i < N; i++) {
			int interviewGrade = grades.get(i).interview;
			if (interviewGrade > min) {
				fallCount++;
			} else {
				min = interviewGrade;
			}
		}

		return N - fallCount;
	}

}
