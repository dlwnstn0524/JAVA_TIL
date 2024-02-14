package ws._240214;

import java.util.Scanner;

public class SquareNumberTest {
	
	static int callCnt;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt(); // 최대 10억까지 가능
		
		System.out.println(exp1(x,n));
		System.out.println(callCnt);
	}

	static long exp1(long x, int n) {
		callCnt++;
		if(n == 1) {
			return x;
		}
		int half = n / 2;
		long res = exp1(x, half);
		res *= res;
		return n % 2 == 0 ? res : res * x;
	}
}
