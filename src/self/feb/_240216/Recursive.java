package self.feb._240216;

import java.util.Arrays;

public class Recursive {

	static int[] sel;
	static int[] arr;
	static int N, R;
	static boolean[] v;

	public static void main(String[] args) {
		N = 5;
		R = 3;
		arr = new int[] { 1, 3, 5, 7, 9 };
		sel = new int[R];
		v = new boolean[N];

//		permu(0);
		combi(0, 0);

	}

	private static void combi(int depth, int idx) {
		if(idx == R) {
			System.out.println(Arrays.toString(sel));
			return;
		} if (depth == N) {
			return;
		}
		sel[idx] = arr[depth];
		combi(depth + 1, idx + 1);
		combi(depth + 1, idx);
	}

	private static void permu(int depth) {
		if (depth == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (v[i])
				continue;
			v[i] = true;
			sel[depth] = arr[i];
			permu(depth + 1);
			v[i] = false;
		}
	}
}
