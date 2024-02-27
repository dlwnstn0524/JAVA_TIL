package ws._240227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 최단경로 {

	static class Node {
		int to, weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	static int V, E, K;
	static List<Node>[] maps;
	static StringTokenizer st;
	static final int INF = Integer.MAX_VALUE;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		maps = new List[V + 1];
		for (int i = 0; i < V + 1; i++) {
			maps[i] = new LinkedList<>();
		}
		
		K = Integer.parseInt(br.readLine());

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			maps[from].add(new Node(to, weight));
		}

		v = new boolean[V + 1];
		int[] minDis = new int[V+1];
		Arrays.fill(minDis, INF);
		minDis[K] = 0;
		
		int min = 0, flag = 0;
		for (int i = 0; i < V; i++) {
			min = INF;
			flag = -1;
			
			for (int j = 1; j <= V; j++) {
				if(!v[j] && min > minDis[j]) {
					min = minDis[j];
					flag = j;
				}
			}
			if(flag == -1) break;
			v[flag] = true;
			for (Node node : maps[flag]) {
				if(!v[node.to] && minDis[node.to] > min + node.weight) {
					minDis[node.to] = min + node.weight;
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			System.out.println(minDis[i]==INF?"INF":minDis[i]);
		}
	}

}
