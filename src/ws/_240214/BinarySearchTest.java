package ws._240214;

import java.util.Arrays;

public class BinarySearchTest {
	static int[] arr = { 3, 11, 20, 21, 39, 45, 48, 53, 60, 71, 89 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res = binarySearchLoop(20);
		System.out.println(res);
		res = binarySearchRecursive(20, 0, arr.length - 1);
		System.out.println(res);
		
		res = Arrays.binarySearch(arr, 20);
		System.out.println(res);
	}

	private static int binarySearchRecursive(int key, int start, int end) {
		// TODO Auto-generated method stub
		if(start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == key)
				return mid;
			else if (arr[mid] < key)
				return binarySearchRecursive(key, mid + 1, end);
			else if (arr[mid] > key)
				return binarySearchRecursive(key, start, mid - 1);
		}
		return -1;
	}

	private static int binarySearchLoop(int key) {
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;

		while (start <= end) {
			mid = (start + end) / 2;
			if (arr[mid] == key)
				return mid;
			else if (arr[mid] < key)
				start = mid + 1;
			else if (arr[mid] > key)
				end = mid - 1;
		}
		return -1;
	}

}
