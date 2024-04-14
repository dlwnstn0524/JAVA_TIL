package self.march._0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액 {

	static int N, value;
	static int[] arr;
	static int[] answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int front = 0;
		int back = N-1;
		value = Integer.MAX_VALUE;
		answer = new int[2];
		
		while(front < back) {
			int diff = arr[front] + arr[back];
			if(Math.abs(diff) < value) {
				value = Math.abs(diff);
				answer[0] = arr[front];
				answer[1] = arr[back];
			}
			if(diff > 0) {
				back--;
			} else if(diff < 0) {
				front++;
			} else {
				break;
			}
		}
		System.out.println(answer[0] + " " + answer[1]);
	}

}
