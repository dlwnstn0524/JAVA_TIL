package self.march._0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 리모컨 {

	static String chanel;
	static int N, answer;
	static String[] error;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		chanel = br.readLine();
		
		N = Integer.parseInt(br.readLine());
		
		error = new String[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			error[i] = st.nextToken();	
		}
		answer = Integer.MAX_VALUE;
		recursive("", );
		System.out.println(answer);
		System.out.println(Arrays.toString(error));
	}

}
