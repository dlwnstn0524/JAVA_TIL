package self.april._01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 수영대회결승전 {

	static class Node{
		int r, c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	static int T, N, answer;
	static int[][] pool;
	static Node start;
	static Node end;
	static StringTokenizer st;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	/*
	 * 장애물은 1, 소용돌이는 2
	 * 소용돌이는 2초동안 유지되고 1초동안 잠잠
	 * 한번 통과한 소용돌이 위에서는 머물러 있을 수 있다?
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			answer = -1;
			N = Integer.parseInt(br.readLine());
			
			pool = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					pool[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			start = new Node(sr, sc);
			
			st = new StringTokenizer(br.readLine());
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			end = new Node(er, ec);
			
			bfs();
			
			System.out.printf("#%d %d\n", t, answer);
		}
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] v = new boolean[N][N];
		q.offer(new int[] {start.r, start.c, 0});
		v[start.r][start.c] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0] == end.r && cur[1] == end.c) {
				answer = cur[2];
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]) {
					if(pool[nr][nc] == 1) continue;
					else if(pool[nr][nc] == 0) {
						v[nr][nc] = true;
						q.offer(new int[] {nr, nc, cur[2] + 1});
					}
					else if(pool[nr][nc] == 2) {
						if(cur[2] % 3 == 2) {
							v[nr][nc] = true;
							q.offer(new int[] {nr, nc, cur[2] + 1});
						} else {
							q.offer(new int[] {cur[0], cur[1], cur[2] + 1});
						}
					}
				}
			}
		}
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(pool[i][j] + " ");
			}
			System.out.println();
		}
	}

}
