package self.march._0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 맥주마시면서걸어 {

	static StringTokenizer st;
	static int T, N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			int[][] maps = new int[N+2][2];
			for (int i = 0; i < N+2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				maps[i][0] =x;
				maps[i][1] =y;				
			}
			boolean[] v = new boolean[N+2];
			boolean able = false;
			Queue<Integer> q = new ArrayDeque<>();
			v[0] = true;
			q.offer(0);
			while(!q.isEmpty()) {
				int cur = q.poll();
				if(cur == N + 1) {
					able  = true;
					break;
				}
				for (int i = 0; i < N + 2; i++) {
					if(!v[i] && Math.abs(maps[cur][0] - maps[i][0]) + Math.abs(maps[cur][1] - maps[i][1]) <= 1000) {
						v[i] = true;
						q.offer(i);
					}
				}
			}
			System.out.println(able?"happy":"sad");
		}
	}
}
