package self.feb._240226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 이건 또 최적화를 어떻게 하지?
 * 소문
 */

public class 소문 {

	static int N, M, answer;
	static int[][] maps;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		maps = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			maps[s][e] = 1; 
			maps[e][s] = 1; 
		}
		
		answer = 0;
		bfs(1);
		System.out.println(answer);
	}

	private static void bfs(int i) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] v = new boolean[N+1];
		q.offer(i);
		v[i] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int j = 0; j < N+1; j++) {
				if(!v[j] && maps[cur][j] == 1) {
					v[j] = true;
					answer++;
					q.offer(j);
				}
			}
		}
	}

}
