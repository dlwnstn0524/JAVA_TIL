package self.march._0313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    static int N, K, L, answer;
    static int[][] maps;
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};
    static Change[] changes;
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
    } 
}
