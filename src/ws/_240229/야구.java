package ws._240229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 야구 {

	static int N, answer;
	static int[][] result;
	static boolean[] v;
	static int[] sel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = null;
		result = new int[N][9];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				result[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		print();
		// 선수들 순열을 먼저 만들어주고 각 순열에 대해서
		v = new boolean[9];
		v[0] = true;
		sel = new int[9];
		permu(0);

		System.out.println(answer);
	}

	private static void permu(int depth) {
		if (depth == 9) {
			System.out.println(Arrays.toString(sel));
			simul(sel);
			return;
		}
		if (depth == 3) {
			permu(depth + 1);
		} else {
			for (int i = 0; i < 9; i++) {
				if (v[i])
					continue;
				v[i] = true;
				sel[depth] = i;
				permu(depth + 1);
				v[i] = false;
			}
		}

	}

	private static void simul(int[] order) {
		int score = 0;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			// 매회마다 베이스, 아웃카운트 초기화, 타자의 순서는 그대로 유지한다.
			int out = 0;
			boolean[] base = new boolean[3];
			while (out < 3) {
				if (result[i][order[idx]] == 0) { // 아웃일때
					out++;
				} else {
					for (int j = 1; j <= 4; j++) {
						if (j == result[i][order[idx]]) { // 1루타, 2루타, 3루타, 4루타 -> 홈런
							for (int k = 0; k < 3; k++) {
								if(base[k] && k + j < 4) {
									base[k+j] = true;
									base[k] = false;
								} else if(base[k] && k + j > 4) {
									base[k] = false;
									score++;
								}
							}
						}
					}
				}
				idx++;
				idx = idx % 9;
			}
		}
		answer = Math.max(answer, score);
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

}
