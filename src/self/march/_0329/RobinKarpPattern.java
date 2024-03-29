package self.march._0329;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
// 해쉬를 통해 패턴값을 찾아낸다
// 슬라이드윈도우 사용
// % 를 통해 지나간것을 삭제하고 
// * 10 을 통해 자릿수 이동하고
// + 을 통해 새로운 값을 추가한다
public class RobinKarpPattern {
	static long[] power;
	public static void main(String[] args) throws Exception{
		/*
		robinkarp.txt
			1
			6843212431
			4321
		 */
		BufferedReader in = new BufferedReader(new FileReader("robinkarp.txt"));
		int T = Integer.parseInt(in.readLine().trim());
		int[] text, pattern;
		String line;
		int size;
		for (int tc = 1; tc <= T; tc++) {
			line = in.readLine();
			size = line.length();
			text = new int[size];
			for (int i = 0; i < size; i++) {
				//hash code를 구하기 위해 문자를 숫자로 변환 
				text[i] = line.charAt(i)-'0';
			}
			line = in.readLine();
			size = line.length();
			pattern = new int[size];
			for (int i = 0; i < size; i++) {
				pattern[i] = line.charAt(i)-'0';
			}
			//패턴의 길이만큼 10의 n승을 구하기 위해 배열 생성 
			power = new long[size];
			setPower();
			System.out.println("#"+tc+" "+search(text, pattern));
		}
	}
	private static void setPower() {
		long p = 1;
		for (int i = power.length-1; i >=0 ; i--) {
			power[i] = p;
			p*=10;
		}
	}
	private static int search(int[] text, int[] pattern) {
		int size = pattern.length;
		long patternHash = makeHash(pattern);
		//text 배열에서 pattern 크기와 같은 배열을 추출해서 hashcode를 만든다.
		long textHash = makeHash( Arrays.copyOfRange(text, 0, size));
		//boolean isSame=true;
		for (int i = 0, end = text.length-size; i <end; i++) {
			if(patternHash == textHash) {
				return i;
			}
			textHash = makeHash(textHash, text[i+size]);
		}
		return -1;
	}
	
	
	private static long makeHash(int[] str) {
		int size = str.length;
		long hash=0;
		for (int i = 0; i < size; i++) {
			hash += str[i]*power[i];
		}
		return hash;
	}
	private static long makeHash(long hash, int at) {
		//기존 hash code 에서 첫 자리를 뺀 수를 구하기 위해  10의 pattern.lenth-1 power로 mod한다. 
		hash %= power[0];		
		hash *= 10;
		hash += at;
		return hash;
	}
	
}










