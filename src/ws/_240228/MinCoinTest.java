package ws._240228;

import java.util.Scanner;

public class MinCoinTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] D = new int[N + 1];
		
		D[0] = 0;
		for (int i = 1; i <= N; i++) {
			int min = D[i-1] + 1;
			if(i >= 4) min = Math.min(D[i-4]+1, min);
			if(i >= 6) min = Math.min(D[i-6]+1, min);
			D[i] = min;
		}
		System.out.println(D[N]);
	}

}
