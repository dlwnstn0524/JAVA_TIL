package self.feb._240302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세사람의심리적거리 {
    static int T, N, answer;
    static int[] sel;
    static String[] str;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            answer = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            str = new String[N];
            for (int j = 0; j < N; j++) {
                str[j] = st.nextToken();
            }
            sel = new int[3];
            combi(0, 0);
            System.out.println(answer);
        }                
    }
    private static void combi(int depth, int idx) {
        if(idx == 3){
            dist(sel);
            return;
        }
        if(depth == N){
            return;
        }
        sel[idx] = depth;
        combi(depth+1, idx+1);
        combi(depth+1, idx);
    }
    private static void dist(int[] arr) {
        int res = 0;
        res += cal(arr[0], arr[1]);
        res += cal(arr[1], arr[2]);
        res += cal(arr[2], arr[0]);

        answer = Math.min(answer, res);
    }
    private static int cal(int i, int j) {
        int res = 0;
        for (int k = 0; k < 4; k++) {
            if(str[i].charAt(k) != str[j].charAt(k)){
                res++;
            }
        }
        return res;
    }
}
