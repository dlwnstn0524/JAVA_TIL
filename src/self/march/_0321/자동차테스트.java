package self.march._0321;

import java.io.*;
import java.util.*;

public class 자동차테스트 {

    static int N, Q;
    static int[] cars;
    static StringTokenizer st;
    static Map<Integer, Integer> map;
    
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        cars = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            cars[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cars);
        map = new HashMap<>();
        for(int i = 0; i < N; i++){
            map.put(cars[i], i);
        }

        for(int i = 0; i < Q; i++){
            int target = Integer.parseInt(br.readLine());
            
            if(map.containsKey(target)){
                Integer idx = map.get(target);
                sb.append(idx*(N-idx-1) + "\n");
            } else {
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }
}

