package self.march._0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부분수열의합2 {

	static int N, S, answer;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
	
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		Arrays.sort(arr);
		int start = 0;
		int end = N-1;
		int subSum; 
		while(start <= end) {
			subSum = 0;
			for (int i = start; i <= end; i++) {
				subSum += arr[i];
			}
			if(subSum == S) {
				answer++;
				start++;
				end--;
			}else if(subSum > S) {
				end--;
			}else if(subSum < S) {
				start++;
			}
			
		}
//		System.out.println(Arrays.toString(arr));
		System.out.println(answer);
	}

}
