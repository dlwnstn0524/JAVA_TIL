package self._240226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class 펭귄만나기 {

	static int R, C, answer;
	static StringTokenizer st;
	static int[][] cords;
	static int[][] maps;
	static boolean[][] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int cnt = 0;
		maps = new int[R][C];
		cords = new int[2][2];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				if (line.charAt(j) == '.') {
					maps[i][j] = 1;
				} else if (line.charAt(j) == 'X') {
					maps[i][j] = 0;
				} else if (line.charAt(j) == 'L') {
					maps[i][j] = 2;
					cords[cnt][0] = i;
					cords[cnt][1] = j;
					cnt++;
				}
			}
		}
		answer = 0;		
		while(!isMeetable()) {			
			v = new boolean[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (!v[i][j] && maps[i][j] == 1) {
						melt(i, j);
					}
				}
			}
			answer++;
		}
		System.out.println(answer);
	}

	static int[] di = new int[] { -1, 1, 0, 0 };
	static int[] dj = new int[] { 0, 0, -1, 1 };

	private static boolean isMeetable() { // 두 사람이 만날 수 있는지 확인
		Queue<int[]> q = new ArrayDeque<>();
		v = new boolean[R][C];
		q.offer(new int[] { cords[0][0], cords[0][1] });
		v[cords[0][0]][cords[0][1]] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int ni = cur[0] + di[i];
				int nj = cur[1] + dj[i];

				if (ni >= 0 && ni < R && nj >= 0 && nj < C && !v[ni][nj]) {
					if (ni == cords[1][0] && nj == cords[1][1]) {
						return true;
					} else if (maps[ni][nj] == 1) {
						v[ni][nj] = true;
						q.offer(new int[] { ni, nj });
					}
				}
			}
		}
		return false;
	}

	private static void melt(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		v[r][c] = true;
		q.offer(new int[] { r, c });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int ni = cur[0] + di[i];
				int nj = cur[1] + dj[i];
				if (ni >= 0 && ni < R && nj >= 0 && nj < C && !v[ni][nj]) {
					if (maps[ni][nj] == 0) {
						v[ni][nj] = true;
						maps[ni][nj] = 1;
					} else if (maps[ni][nj] == 1 || maps[ni][nj] == 2) {
						v[ni][nj] = true;
						q.offer(new int[] { ni, nj });
					}
				}
			}
		}
	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(maps[i][j] + " ");
			}
			System.out.println();
		}
	}

}
