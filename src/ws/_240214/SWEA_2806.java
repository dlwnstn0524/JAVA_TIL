package ws._240214;

import java.util.Scanner;

public class SWEA_2806 {	// N-queen 문제
	
	static int T, N, answer;
	static int[][] maps;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int t = 1; t <=T ; t++) {
			answer = 0;
			N = sc.nextInt();
			maps = new int[N][N];
			
			recursive(0);
			System.out.println("#" + t + " " + answer);
		}
	}

	private static void recursive(int r) {
		// basis part
		if(r == N) {
			answer++;
			return;
		}
		//inductive part
		for (int i = 0; i < N; i++) {
			// 가지 치기를 실시한다
			if(check(r, i)) {		
				maps[r][i] = 1;
				recursive(r+1);
				maps[r][i] = 0;
			}
		}
	}

	private static boolean check(int r, int c) {
		// 상
		for (int i = r-1; i >= 0; i--) {
			if(maps[i][c] == 1) return false;
		}
		// 좌상
		for(int i = r, j = c ; i>=0 && j >= 0 ; i--, j--) {
			if(maps[i][j] == 1) return false;
		}
		// 우상
		for (int i = r, j = c; i >= 0 && j < N; i--, j++) {
			if(maps[i][j] == 1) return false;
		}
		return true;
	}

}
