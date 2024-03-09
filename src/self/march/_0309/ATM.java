package self.march._0309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {
    static int N, answer;
    static int[] nums;
    static int[] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        dp = new int[N];
        dp[0] = nums[0];
        for (int i = 1; i < N; i++) {
            dp[i] = dp[i-1] + nums[i];
        }
        answer = 0;
        for (int i = 0; i < N; i++) {
            answer += dp[i];
        }
        System.out.println(answer);
    }
}
