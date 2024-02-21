package ws._240221;

import java.util.Arrays;

public class DisjointSet_Tree {
	
	static int N = 8;

	public static void main(String[] args) {
		int[] set = new int[N];
		
		//makeSet
		for (int i = 0; i < set.length; i++) {
			set[i] = i;
		}
		//find
		
		//union
		System.out.println(Arrays.toString(set));
		unionSet(0, 2, set);
		System.out.println(Arrays.toString(set));
		unionSet(1, 3, set);
		System.out.println(Arrays.toString(set));
		unionSet(0, 1, set);
		System.out.println(Arrays.toString(set));
	}

	private static void unionSet(int org, int change, int[] set) {
		int a = findSet(org, set);
		int b = findSet(change, set);
		if(a!= b) {
			set[a] = b;
		}
	}

	private static int findSet(int org, int[] set) {
		if(set[org] == org) return org;
		else return findSet(set[org], set);
	}
}
