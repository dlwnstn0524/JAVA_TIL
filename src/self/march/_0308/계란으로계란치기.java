package self.march._0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 계란으로계란치기 {

	static int N, answer;
	static int[] s;
	static int[] w;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		s = new int[N];
		w = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				s[i] = Integer.parseInt(st.nextToken());
				w[i] = Integer.parseInt(st.nextToken());
			}
		}
		
		
	}

}
