package ws._240221;

import java.util.Arrays;

public class DisjointSet {		// 서로소 집합

	static int N = 10;
	
	public static void main(String[] args) {
		int[] set = new int[N];
		
		//makeSet
		for (int i = 0; i < set.length; i++) {
			set[i] = i;
		}
		//find
		//union
		System.out.println(Arrays.toString(set));
		unionFind(3, 2, set);
		System.out.println(Arrays.toString(set));
	}

	private static void unionFind(int org, int change, int[] set) {
		for (int i = 0; i < set.length; i++) {
			if(set[i]==org) set[i]=change;
		}
	}
}
