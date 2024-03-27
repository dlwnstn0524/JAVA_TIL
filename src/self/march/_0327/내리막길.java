package self.march._0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 내리막길 {

	static int M, N;
	static int[][] maps;
	static int[][] dp;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		maps = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[M][N];
		for (int i = 0; i < M; i++) {
			Arrays.fill(dp[i], -1);
		}
//		print();
		int answer = recursive(M-1,N-1);
		System.out.println(answer);
		
	}
	
	private static void print() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int recursive(int r, int c) {
		// basis part
		if(r == 0 && c == 0) return dp[0][0] = 1;
		if(dp[r][c] != -1) return dp[r][c];
			
		// inductive part
		dp[r][c] = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr >= 0 && nr < M && nc >= 00 && nc < N) {
				if(maps[r][c] < maps[nr][nc]) {
					dp[r][c] += recursive(nr, nc);
				}
			}
		}
		return dp[r][c];
	}
	
}
