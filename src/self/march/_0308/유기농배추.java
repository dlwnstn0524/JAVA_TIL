package self.march._0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추 {

	static int T, M, N, K, answer;
	static boolean[][] maps;
	static boolean[][] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 0; t < T; t++) {
			answer = 0;
			
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			maps = new boolean[M][N];
			v = new boolean[M][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				maps[r][c] = true;
			}
//			print();
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(maps[i][j] && !v[i][j]) {
						bfs(i,j);
					}
				}
			}
			System.out.println(answer);
		}
	}

	private static void print() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(maps[i][j] + " ");
			}
			System.out.println();
		}
	}

	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	private static void bfs(int i, int j) {
		answer++;
		Queue<int[]> q = new ArrayDeque<>();
		v[i][j] = true;
		q.offer(new int[] {i, j});
		while(!q.isEmpty()){
			int[] cur = q.poll();
			for (int k = 0; k < 4; k++) {
				int ni = cur[0] + di[k];
				int nj = cur[1] + dj[k];
				
				if(ni>= 0 && ni < M && nj >= 0 && nj < N && !v[ni][nj] && maps[ni][nj]) {
					v[ni][nj] = true;
					q.offer(new int[] {ni, nj});
				}
			}
		}
	}

}
