package self._240226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 공주님 {

	static List<boolean[]> work;
	static int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	static class Project {
		int sm, sd, em, ed;

		public Project(int sm, int sd, int em, int ed) {
			this.sm = sm;
			this.sd = sd;
			this.em = em;
			this.ed = ed;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return sm + " " + sd + " " + em + " " + ed;
		}
	}

	static int N;
	static Project[] sel;
	static StringTokenizer st;
	static Project[] projects;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		int answer = 0;
		projects = new Project[N];
		// 그리디 문제
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int sm = Integer.parseInt(st.nextToken());
			int sd = Integer.parseInt(st.nextToken());
			int em = Integer.parseInt(st.nextToken());
			int ed = Integer.parseInt(st.nextToken());
			projects[i] = new Project(sm, sd, em, ed);
		}
		
		Arrays.sort(projects, (a,b) -> Integer.compare(a.em - a.sm, b.em - b.sm)==0?
				-Integer.compare(a.ed - a.sd, b.ed - b.sd):
					-Integer.compare(a.em - a.sm, b.em - b.sm));
		
		work = new ArrayList<>();
		
//		for(int i = 1 ; i <= N ; i++) {
			sel = new Project[2];
			combi(0, 0, 2);
//		}
		for (Project prj : projects) {
			if(prj.sm > 11 && prj.em < 3) {
				continue;
			} else {
				
				answer++;
			}
			if(check()) {
				System.out.println(answer);
				break;
			}
		}
	}

	private static void combi(int depth, int idx, int target) {
		if(idx == target) {
			// work boolean 배열 초기화
			for (int i = 0; i < days.length; i++) {
				work.add(new boolean[days[i]]);
			}
			for (Project p : sel) {
				
			}
			System.out.println(Arrays.toString(sel));
			return;
		} if(depth == projects.length) {
			return;
		}
		sel[idx] = projects[depth];
		combi(depth+1, idx+1, target);
		combi(depth+1, idx, target);
	}

	private static boolean check() {
		for (int i = 3; i <= 11; i++) {
			for (int j = 0; j < days[i]; j++) {
				if(!work.get(i)[j]) {
					return false;
				}
			}
		}
		return true;
	}
}
