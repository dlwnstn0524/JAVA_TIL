package self.march._0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 리모컨 {

	static String chanel;
	static int N, answer;
	static String buttons = "0123456789";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		chanel = br.readLine();
		
		N = Integer.parseInt(br.readLine());
		if(N > 0){
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				buttons = buttons.replace(st.nextToken(), "");
			}
		}	
		answer = Math.abs(Integer.parseInt(chanel) - 100);
		recursive("");
		
		System.out.println(answer);
	}
	private static void recursive(String num) {
		if(num.length() > chanel.length()+1){
			return;
		}
		if(num.length() != 0){
			answer = Math.min(Math.abs(Integer.parseInt(num) - Integer.parseInt(chanel)) + num.length(), answer);
		}
		for (int i = 0; i < buttons.length(); i++) {
			recursive(num + (buttons.charAt(i)+""));
		}

	}

}
