package ws._240226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {
	
	static class Node{
		int to, weight;
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
	
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		Node[] adjList =new Node[V];
		int[] minDist = new int[V];
		boolean[] v = new boolean[V];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight);
		}
		
		Arrays.fill(minDist, Integer.MAX_VALUE);
		minDist[start] = 0; // 출발지에서 출발지로의 비용 0으로 초기화
		
		int min = 0, stopOver = 0;
		for (int i = 0; i < V; i++) { // 모든 정점이 다 처리될때까지 반복
			
			// step1 : 미방문 정점 중 출발지에서 가장 가까운 정점 선택
			min = Integer.MAX_VALUE;
			stopOver = -1;
			for (int j = 0; j < V; j++) {
				if(!v[j] && min > minDist[j]) {
					min = minDist[j];
					stopOver= j;
				}
			}
			
			if(stopOver == -1) break;
			v[stopOver] = true;
			
			// step2 : 선택된 경유지를 거쳐서 미방문 정점들에 대한 비용과 기존 최소비용을 고려하여 업데이트
			for (Node temp : adjList[stopOver]) {
				
			}
			
		}
		
	}

}
