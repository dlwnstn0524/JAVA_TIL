package self.march._0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 벽돌깨기 {

	static int T, N, W, H, answer;
	static int[][] maps;
	static int[] sel;
	static StringTokenizer st;
	static int[] di = new int[] {-1, 1, 0, 0};
	static int[] dj = new int[] {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			maps = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					maps[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sel = new int[N];
//			solve(0);
			drop(new int[] {2,2,6}, maps);
			System.out.printf("#%d %d\n", t, answer);
		}
	}
	
	private static void print(int[][] map) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void drop(int[] loc, int[][] table) {
		L : for (int i = 0; i < loc.length; i++) {
			for (int j = 0; j < H; j++) {
				if(table[j][loc[i]] != 0) {
					recur(j, loc[i], table);
					print(table);
					System.out.println();
					break L;
				}
			}
		}
	}

	private static void recur(int i, int j, int[][] table) {
		if(table[i][j] == 0 || table[i][j] == 1) {
			table[i][j] = 0;
			return;
		}
		else {			
			for (int l = 0; l <= table[i][j] - 1; l++) {			
				for (int k = 0; k < 4; k++) {
					int ni = i + di[k]*l;
					int nj = j + dj[k]*l;
					if(ni>=0 && ni < H && nj >= 0 && nj < W) {
						table[ni][nj] = 0;
						if(table[ni][nj] != 0) recur(ni, nj, table);
					}
				}
			}
			return;
		}
	}

	private static void solve(int idx) {
		//basis part
		if(idx == N) {
			int[][] tmaps = copy();
			drop(sel, tmaps);
			return;
		}
		
		//inductive part
		for (int i = 0; i < W; i++) {
			sel[idx] = i;
			solve(idx+1);
		}
	}

	private static int[][] copy() {
		int[][] res = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				res[i][j] = maps[i][j];
			}
		}
		return res;
	}

}
