package ws._240214;

import java.util.Arrays;

public class Combi {
	
	static int[] sel;
	static int[] arr = new int[] {1,2,3,4,5};
	static int N;
	
	public static void main(String[] args) {
		N = 2;
		sel = new int[N];
		permu(0);
		combi(0, 0);
	}

	private static void permu(int depth) {
		
	}

	private static void combi(int depth, int cnt) {
		if(cnt == N) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(depth == arr.length) {
			return;
		}
		sel[cnt] = depth;
		combi(depth+1, cnt + 1);
		combi(depth+1, cnt);
	}
}
