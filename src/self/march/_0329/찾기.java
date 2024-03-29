package self.march._0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 찾기 {

	static String target;
	static String pattern;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		target = br.readLine();
		pattern = br.readLine();
		int[] pi = new int[pattern.length()];
		pi = getPi();
		
		int n1 = target.length(), n2 = pattern.length();
		int begin =0, matched=0; // begin = matched = 0
		while(begin <= n1-n2) {
			// 만약 짚더미의 해당 글자가 바늘의 해당 글자가 같다면
			if(matched < n2 && target.charAt(begin+matched) == pattern.charAt(matched)) {
				++matched;
				// 결과적으로 m글자가 모두 일치했다면 답에 추가한다.
				if(matched == n2) {
					System.out.println(i-idx+1 + "번째에서 찾았습니다. ~" + (begin+1) );
				}
			}else{
				// 예외 : matched가 0인 경우에는 다음 칸에서부터 계속 
				if(matched ==0) {
					++begin;
				}else {
					begin += matched - table[matched-1];
					// begin을 옮겼다고 처음부터 다시 비교할 필요가 없다.
					// 옮긴 후에도 table[matched-1]만큼은 항상 일치하기 때문이다.
					matched = table[matched-1];
				}
			}
		}
		System.out.println(Arrays.toString(pi));
		System.out.println(pattern);
	}

	private static int[] getPi() {
		int[] res = new int[pattern.length()];
		
		int idx = 0;
		for (int i = 1; i < res.length; i++) {
			while(idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
				idx = res[idx-1];
			}
			if(pattern.charAt(i) == pattern.charAt(idx)) {
				idx++;
				res[i] = idx;
			}
		}
		
		
		return res;
	}

}
