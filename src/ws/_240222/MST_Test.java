package ws._240222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST_Test {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int V;
	static Edge[] edgeList;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());

		int E = Integer.parseInt(st.nextToken());
		edgeList = new Edge[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(start, end, weight);
		}

		// 크루스칼 전처리 -> 그리디 한 알고리즘 이니까
		Arrays.sort(edgeList);

		// 1. makeSet
		parents = new int[V];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}

		// 2. unionSet
		int weight = 0;
		int cnt = 0;
		for (Edge e : edgeList) {
			if(unionSet(e.from, e.to)) {
				weight += e.weight;
				if(++cnt == V - 1) {	// 최소신장트리 완성
					break;
				}
			}
		}
		
		System.out.println(weight);
	}

	private static boolean unionSet(int from, int to) {
		int a = find(from);
		int b = find(to);
		if (a == b)
			return false; // a와 b가 같은 트리 안에 속해있다. -> union 불필요. 사이클 발생!
		parents[a] = b;
		return true;

	}

	private static int find(int source) { // source가 속한 트리의 루트 찾기
		if (source == parents[source])
			return source;
		else
			return parents[source] = find(parents[source]); // 경로 압축
	}
}
