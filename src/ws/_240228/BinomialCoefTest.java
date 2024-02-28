package ws._240228;

import java.util.Arrays;
import java.util.Scanner;

public class BinomialCoefTest {

	//nCk
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		// 메모리 낭비 최소화
		int[][] B = new int[N+1][K+1];
		
		for (int i = 0; i <= N; i++) {
			for (int j = 0, end = Math.min(i, K); j <= end; j++) {	// end 변수 선언으로 j의 범위를 조정해준다
				if(j == 0 || i == j) B[i][j] = 1;			// 아무것도 고르지 않았을때와 모두 골랐을때 
				else B[i][j] = B[i-1][j-1] + B[i-1][j];		// 점화식대로 코드 구현
			}
		}
		for (int i = 0; i <= N; i++) {
			System.out.println(Arrays.toString(B[i]));
		}
		System.out.println(B[N][K]);
	}

}
