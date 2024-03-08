package self.feb._240226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 최적화는 아마 찾은 것들에 대해서 정렬한 다음 순차 탐색일것 같은데 정렬 기준이 무엇인지 잘 모르겠다 ㅜㅠㅠ 지금은 그것들 다 찾은 다음에 버블정렬처럼 서로 하나하나 비교함 ㅠㅠ
 * 산악 지도 그리기
 * 
 */

public class 산악지도그리기 {
	
	static int N, cntA, cntB;
	static int[][] cords;
	static List<int []> hornes;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		cords = new int[N][2];
		hornes = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cords[i][0] = Integer.parseInt(st.nextToken());
			cords[i][1] = Integer.parseInt(st.nextToken());
		}
		
		boolean isSwitch = false;
		int temp = 0;
		for (int i = 1; i < N; i++) {
			if(!isSwitch) {				
				if(cords[i-1][1] * cords[i][1] < 0) {
					isSwitch = true;
					temp = cords[i][0];
				}
			}
			else if(isSwitch) {
				if(cords[i-1][1] * cords[i][1] < 0) {
					isSwitch = false;
					hornes.add(new int[] {Math.min(temp, cords[i][0]), Math.max(temp, cords[i][0])});
				}
			}
		}
		
		cntA = 0;
		cntB = 0;
		count();
		System.out.println(cntA + " " + cntB);
	}

	private static void count() {		// 다른 봉우리를 포함하지 않는 봉우리 개수 세기
		for (int i = 0; i < hornes.size(); i++) {
			boolean flagA = true;
			boolean flagB = true;
			for (int j = 0; j < hornes.size(); j++) {
				if(i == j) {
					continue;
				} else if(hornes.get(i)[0] > hornes.get(j)[0] && hornes.get(i)[1] < hornes.get(j)[1]) {
					flagA = false;
				} else if(hornes.get(i)[0] < hornes.get(j)[0] && hornes.get(i)[1] > hornes.get(j)[1]) {
					flagB = false;
				}
			}
			if(flagA) {
				cntA++;
			}
			if(flagB) {
				cntB++;
			}
		}
	}


}
