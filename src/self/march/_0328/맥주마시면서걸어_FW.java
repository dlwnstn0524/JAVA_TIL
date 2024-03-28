package self.march._0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 맥주마시면서걸어_FW {

	static StringTokenizer st;
	static int T, N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			int[][] maps = new int[N+2][2];
			for (int i = 0; i < N+2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				maps[i][0] =x;
				maps[i][1] =y;				
			}
			
			int[][] dp = new int[N+2][N+2];
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					int dist = Math.abs(maps[i][0] - maps[j][0]) + Math.abs(maps[i][1] - maps[j][1]);
					if(i == j) continue;
					if(dist <= 1000) {
						dp[i][j] = 1;
						dp[j][i] = 1;
					}
					else {
						dp[i][j] = N+10000;
						dp[j][i] = N+10000;
					}
				}
			}
			for (int k = 0; k <= N+1; k++) {
				for (int i = 0; i <= N+1; i++) {
					for (int j = 0; j <= N+1; j++) {
						if(dp[i][j]>dp[i][k]+dp[k][j]) {
							dp[i][j]=dp[i][k]+dp[k][j];
						}
					}
				}
			}
//			print(dp);
			
			System.out.println(dp[0][N+1]==N+10000?"sad":"happy");
			
		}
	}

	private static void print(int[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
}
