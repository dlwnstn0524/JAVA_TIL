package self.march._0313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀 {
    static class Change{
        int time;
        char dir;
        public Change(int t, char d){
            this.time = t;
            this.dir = d;
        }
    }
    static int N, K, L, dir, answer;
    static int[][] maps;
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};
    static Change[] changes;
    static Queue<int []> q;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        
        maps = new int[N][N];
        StringTokenizer st = null;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            maps[r-1][c-1] = 2;
        }

        L = Integer.parseInt(br.readLine());
        changes = new Change[L];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            changes[i] = new Change(t, d);
        }
        
        maps[0][0] = 1;
        q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        
        answer = 0;
        dir = 0;
        int cnt = 0;
        while(true) {
        	answer++;
        	if(answer == changes[cnt].time) {
        		
        	}
        	int[] cur = q.peek();
        	int ni = cur[0] + di[dir];
        	int nj = cur[1] + dj[dir];
        	if(ni < 0 || ni >= N || nj < 0 || nj >= N || maps[ni][nj] == 1) break;
        	else {
        		if(maps[ni][nj] == 2) q.offer(new int[] {});
        	}
        	
        }
        System.out.println(answer);
        print(maps);
    }

	private static void print(int[][] maps2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(maps[i][j] + " ");
			}
			System.out.println();
		}
	} 
}
