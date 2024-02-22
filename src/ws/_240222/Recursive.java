package ws._240222;

import java.util.Arrays;

public class Recursive {

	static int[] sel;
	static int[] arr = { 1, 3, 5, 7, 9 };
	static int N = 2;
	static boolean[] v;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sel = new int[N];
		v = new boolean[arr.length];
//		permu(0);
		combi(0,0);
	}

	private static void combi(int depth, int idx) {
		if(idx == N) {
			System.out.println(Arrays.toString(sel));
			return;
		} if (depth == arr.length) {
			return;
		}
		sel[idx] = arr[depth];
		combi(depth+1, idx + 1);
		combi(depth+1, idx);
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

}
