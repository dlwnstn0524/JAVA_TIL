package ws._240214;

import java.util.Arrays;

public class Combi {
	
	static int[] sel;
	static int[] arr = new int[] {1,3,5,7,9};
	static int N;
	static boolean[] v;
	
	public static void main(String[] args) {
		N = 2;
		sel = new int[N];
		v = new boolean[arr.length];
		permu(0);
		System.out.println();
		combi(0, 0);
	}

	private static void permu(int depth) {
		if(depth == N) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(v[i]) continue;
			v[i] = true;
			sel[depth] = arr[i];
			permu(depth+1);
			v[i] = false;
		}
	}

	private static void combi(int depth, int cnt) {
		if(cnt == N) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(depth == arr.length) {
			return;
		}
		sel[cnt] = arr[depth];
		combi(depth+1, cnt + 1);
		combi(depth+1, cnt);
	}
}
