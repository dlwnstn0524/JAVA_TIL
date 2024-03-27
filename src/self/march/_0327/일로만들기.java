package self.march._0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일로만들기 {
	
	static int X;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(br.readLine());
		
		dp = new int[X+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		dp[1] = 0;
		for (int i = 2; i <= X ; i++) {
			if (i % 3 == 0 && i % 2 == 0) {
				dp[i] = Math.min(dp[i-1] + 1, Math.min(dp[i/3] + 1, dp[i/2] + 1));
			} else if (i % 3 == 0) {
				dp[i] = Math.min(dp[i/3] + 1, dp[i-1] + 1);
			} else if (i % 2 == 0) {
				dp[i] = Math.min(dp[i/2] + 1, dp[i-1] + 1);				
			} else {
				dp[i] = dp[i-1];
			}
		}
		System.out.println(dp[X]);
	}
}
