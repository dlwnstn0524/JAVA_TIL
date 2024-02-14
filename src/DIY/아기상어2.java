package DIY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어2 {

	static int N, M, answer;
	static int[][] maps;
	static boolean[][] v;
	static StringTokenizer st;
	static int[] di = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dj = {-1, 0, 1, -1, 1, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maps = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (maps[i][j] == 0) {
					answer = Math.max(answer, bfs(i, j));
				}
			}
		}
		System.out.println(answer);

	}

	private static int bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		v = new boolean[N][M];
		v[i][j] = true;
		q.offer(new int[] { i, j, 0 });
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int k = 0; k < 8; k++) {
				int ni = cur[0] + di[k];
				int nj = cur[1] + dj[k];
				if(ni >= 0 && ni < N && nj >= 0 && nj < M && !v[ni][nj]) {
					if(maps[ni][nj] == 1) {
						return cur[2] + 1;
					}
					v[ni][nj] = true;
					q.offer(new int[] {ni, nj, cur[2] + 1});
				}
			}
		}
		return -1;
	}
}
