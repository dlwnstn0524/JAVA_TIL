package self.feb._240226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 야바위 {
	
	static int T, N, X, K, answer;
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());			
			N = Integer.parseInt(st.nextToken());		// 종이컵의 수
			X = Integer.parseInt(st.nextToken());		// 간식이 들어있는 칸
			K = Integer.parseInt(st.nextToken());		// 컵 교체 횟수
			
			for (int i = 0; i < K; i++) {
				// 컵 교체 때마다 바뀌는 위치
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				if(s == X) {
					X = e;
				} else if (e == X) {
					X = s;
				}
				
			}
			
			System.out.println("#" + t + " " + X);
		}
	}
}
