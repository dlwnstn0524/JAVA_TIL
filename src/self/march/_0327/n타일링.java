package self.march._0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n타일링 {

	static int[] dp;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(N == 1) {
			System.out.println(1);
		} else {			
			dp = new int[N+1];
			dp[1] = 1;
			dp[2] = 2;
			for (int i = 1; i <= N; i++) {
				if(i+2 <= N) {
					dp[i+2] = (dp[i] + dp[i+1])%10007;
				}
			}
			System.out.println(dp[N]);
		}
	}
}
