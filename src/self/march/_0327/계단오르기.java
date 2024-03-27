package self.march._0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 계단오르기 {

	static int N;
	static int[] scores;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		scores = new int[N+1];
		for (int i = 1; i <= N; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[N+1];
		if(N == 1) {
			System.out.println(scores[1]);
		} else if(N == 2){
			System.out.println(scores[1] + scores[2]);
		}else {			
			dp[0] = 0;
			dp[1] = scores[1];
			dp[2] = scores[1] + scores[2];			
			for (int i = 0; i <= N; i++) {
				if(i + 3 <= N) {
					dp[i+3] = Math.max(dp[i] + scores[i+2] + scores[i+3], dp[i+1] + scores[i+3]);
				}
			}
			System.out.println(dp[N]);
		}
	}

}
