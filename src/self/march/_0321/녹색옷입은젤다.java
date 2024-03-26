package self.march._0321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 녹색옷입은젤다 {

	static int N, answer;
	static int[][] maps;
	static StringTokenizer st;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = 1;
		while(true) {			
			N = Integer.parseInt(br.readLine());
			if(N == 0) {
				break;
			}
			maps = new int[N][N];
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					maps[j][k] = Integer.parseInt(st.nextToken());
				}
			}
//			print();
			answer = 0;
			dijkstra();
			System.out.printf("Problem %d: %d\n", i, answer);
			i++;
		}
	}

	private static void dijkstra() {
		Queue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
		int[][] cost = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(cost[i], Integer.MAX_VALUE);
		}
		
		pq.offer(new int[] {0, 0, maps[0][0]});
		cost[0][0] = maps[0][0];
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if(cur[0] == N -1 && cur[1] == N-1) {
				answer = cur[2];
				return;
			}
			for (int i = 0; i < 4; i++) {
				int ni = cur[0] + di[i];
				int nj = cur[1] + dj[i];
				if(ni>= 0 && ni < N && nj >= 0 && nj < N) {
					if(cur[2] + maps[ni][nj] < cost[ni][nj]) {
						cost[ni][nj] = cur[2] + maps[ni][nj];
						pq.offer(new int[] {ni, nj, cost[ni][nj]});
					}
				}
			}
		}
	}

	private static void print() {
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < N; k++) {
				System.out.print(maps[j][k] + " ");
			}
			System.out.println();
		}
	}

}
