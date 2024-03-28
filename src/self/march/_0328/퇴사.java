package self.march._0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 퇴사 {

	static int N;
	static int[][] concils;
	static StringTokenizer st;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		concils = new int[N][2];
		for (int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine());
			concils[t][0] = Integer.parseInt(st.nextToken());
			concils[t][1] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N+1];
		for (int i = 0; i < N; i++) {
			if(concils[i][0]+i <= N) {				
				dp[concils[i][0]+i] = Math.max(dp[concils[i][0]+i], dp[i] + concils[i][1]);
			}
		}
		System.out.println(Arrays.toString(dp));
	}

}
