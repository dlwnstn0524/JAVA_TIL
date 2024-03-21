package self.march._0321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 마법사상어와파이어볼 {

	static class FireBall {
		int r, c, m, s, d;

		FireBall(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "방향 : " + d + ", 질량 : " + m + ", 속도 : " + s; 
		}
	}

	static int N, M, K, answer;
	static List<FireBall>[][] maps;
	static List<FireBall> fireBalls;
	static StringTokenizer st;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		
		fireBalls = new ArrayList<>();
		maps = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				maps[i][j] = new ArrayList<>();
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			FireBall fb = new FireBall(r-1, c-1, m, s, d);
			maps[r-1][c-1].add(fb);
			fireBalls.add(fb);
		}
		
//		for (int i = 0; i < K; i++) {			
			magic();
//		}
		
		answer = 0;
		for(FireBall fb : fireBalls) {
			answer += fb.m;
		}
		System.out.println(answer);
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(maps[i][j].size() != 0) {
					System.out.println(i + " "  + j + " " + maps[i][j]);
				}
			}
		}
	}

	private static void magic() {
		
		print();
	}

}
