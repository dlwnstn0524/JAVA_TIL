package ws._240227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class 알고스탁 {

	static class Stock {
		int curPrice, nextPrice, diff;

		public Stock(int curPrice, int nextPrice, int diff) {
			this.curPrice = curPrice;
			this.nextPrice = nextPrice;
			this.diff = diff;
		}
	}

	static int T, Ms, Ma, N, L, answer, monthProfit;
	static int[][] data;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t < T + 1; t++) {
			answer = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			Ms = Integer.parseInt(st.nextToken());
			Ma = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			data = new int[N][L + 1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < L + 1; j++) {
					data[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int money = Ms;
			for (int month = 0; month < L; month++) {
				// 매달 구입 리스트
				List<Stock> wishList = new ArrayList<>();
				for (int i = 0; i < N; i++) {
					if (data[i][month] < data[i][month + 1]) {
						wishList.add(
								new Stock(data[i][month], data[i][month + 1], data[i][month + 1] - data[i][month]));
					}
				}
				monthProfit = 0;
				// 어떤 주식을 얼만큼 살까요?
				recursive(0, money, wishList, 0);

				money += monthProfit;
				money += Ma;
			}
			answer = money - Ms - (Ma * L);
			System.out.println("#" + t + " " + answer);
		}
	}

	private static void recursive(int depth, int money, List<Stock> wishList, int profit) {
		
		// basis part
		if(depth == wishList.size()) {
			monthProfit = Math.max(monthProfit, profit);
			return;
		}
		
		//inductive part
		Stock stock = wishList.get(depth);
		
		if(money >= stock.curPrice) {
			recursive(depth, money - stock.curPrice, wishList, profit + stock.diff);
		}
		recursive(depth+1, money, wishList, profit);
		
	}
}
