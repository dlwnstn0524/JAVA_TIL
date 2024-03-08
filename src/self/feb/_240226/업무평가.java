package self.feb._240226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


/*
 * 이걸 최적화를 어떻게 하지?
 * 업무 평가
 * 
 */
public class 업무평가 {
	static class Work{
		int score, rest;
		public Work(int score, int rest) {
			this.score = score;
			this.rest = rest;
		}
	}
	static int N, answer;
	static Stack<Work> stack;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		stack = new Stack<>();
		Work cur;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			if(line.equals("0")) { // 해당 시간에는 아무런 것도 들어오지 않았다.
				if(!stack.isEmpty()) {					
					cur = stack.peek();
					cur.rest-=1;
					if(cur.rest == 0) {
						answer += cur.score;
						stack.pop();
					}
				}
			} else {
				st = new StringTokenizer(line);
				int num = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				if(t == 1) {
					answer += a;
				} else {					
					stack.push(new Work(a, t-1));
				}
			}
		}
		
		System.out.println(answer);
	}

}
