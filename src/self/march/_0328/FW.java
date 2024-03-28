package self.march._0328;

import java.util.Arrays;
import java.util.Scanner;

public class FW {
	static int E,V,number = 4;
	static int INF = 987654321;
	public static void main(String[] args) {
//		Scanner sc = new Scanner("4 7\n" 
//				+ "1 2 5\r\n" + "1 4 8\r\n" 
//				+ "2 1 7\r\n" + "2 3 9\r\n" 
//				+ "3 1 2\r\n" + "3 4 4\r\n" 
//				+ "4 3 3\r\n");
		Scanner sc = new Scanner("7 11\n" 
				+ "1 2 31\r\n" + "1 3 31\r\n" + "1 7 31\r\n" 
				+ "1 6 60\r\n" + "2 3 21\r\n" + "3 5 46\r\n" 
				+ "3 7 25\r\n" + "4 5 34\r\n" + "5 7 51\r\n" 
				+ "6 4 18\r\n" + "6 5 40\r\n");
		V=sc.nextInt();
		E=sc.nextInt();
		
		int[][] dist = new int[V+1][V+1];

		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist[i].length; j++) {

				dist[i][j]=(i==0)?0:INF;
			}
		}
		//print(dist);
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			dist[a][b]=c;
			
		}
		
		//print(dist);
		// floydwarshall
		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					if(dist[i][j]>dist[i][k]+dist[k][j]) {
						dist[i][j]=dist[i][k]+dist[k][j];
					}
				}
			}
		}
		print(dist);
	}
	private static void print(int[][] adj) {
		for (int i = 1; i < adj.length; i++) {
			for (int j = 1; j < adj[i].length; j++) {
				if(adj[i][j]!=987654321) 
				System.out.print(adj[i][j]+"\t");
				else System.out.print("INF\t");
			}
			System.out.println();
		}
	}
	
	
}
