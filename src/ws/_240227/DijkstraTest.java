package ws._240227;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author THKim
 *
 */

// 인접리스트 버전
public class DijkstraTest {
	static class Node{
		int vertex,weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;	
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + ", link=" + next + "]";
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		int V = Integer.parseInt(st.nextToken()); //정점 갯수
		int E = Integer.parseInt(st.nextToken()); //간선 갯수
		st = new StringTokenizer(in.readLine().trim());
		int start = Integer.parseInt(st.nextToken());//시작점 인덱스
		int end =  Integer.parseInt(st.nextToken()); //도착점 인덱스
		final int INF = Integer.MAX_VALUE;
		
		
		Node[] adjList = new Node[V];
		int[] minDinstance = new int[V];
		boolean[] visited = new boolean[V];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine().trim(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to,weight,adjList[from]);
		} // 인접리스트 생성
		
		Arrays.fill(minDinstance, INF);
		minDinstance[start] = 0; // 출발지에서 출발지로의비용 0으로 초기화
		
		int min = 0 , stopOver = 0;
		for (int i = 0; i < V; i++) { //모든 정점이 다 처리될때까지 반복
			
			//step1 : 미방문 정점 중 출발지에서 가장 가까운 정점 선택
			min = INF;
			stopOver = -1;
			
			for (int j = 0; j < V; j++) {
				if(!visited[j] && min > minDinstance[j]) {
					min = minDinstance[j];
					stopOver = j;
				}
			}
			
			if(stopOver == -1) break;
			visited[stopOver] = true;
//			if(stopOver == end) break;  // 도착점이면 끝내기!!
			
			// step2 : 미방문 정점들에 대해 선택된 경유지를 거쳐서 가는 비용과 기존 최소비용을 비교해서 업데이트
			for (Node temp = adjList[stopOver]; temp != null; temp = temp.next) {
				if(//!visited[temp.vertex] && 
						minDinstance[temp.vertex] > min + temp.weight) {
					minDinstance[temp.vertex] = min + temp.weight; 
				}
			}
		}
		System.out.println(Arrays.toString(minDinstance));
		System.out.println(minDinstance[end] != INF ? minDinstance[end] : -1);
	}

}









