package ws._240229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 다리놓기 {

	static int T, n, k;
	static int[][] dp;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			n = Math.max(a, b);
			k = Math.min(a, b);
			
			dp = new int[n+1][k+1];
			for (int i = 0; i < n+1; i++) {
				for (int j = 0, size = Math.min(i, k); j <= size ; j++) {
					if(i == j || j == 0) {
						dp[i][j] = 1;
					}
					else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}
			}
			System.out.println(dp[n][k]);
		}
	}

}
