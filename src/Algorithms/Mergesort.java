package Algorithms;

import java.util.Arrays;

public class Mergesort {
	
	public static void mergesort(int[] a, int start, int end, int[] clone) {
		if(start == end)
			return;
		int m = (start+end)/2;
		//clone stays the same so it becomes the first arg, a changes as it is supposed to do 
		mergesort(clone, start, m, a);
		mergesort(clone, m+1, end, a);
		merge(a, start, m, end, clone);
	}
	
	public static void merge(int[]a, int start, int m, int end, int[] clone) {
		int i=start, j=m+1, k=start;
		
		while(i <= m || j <=end) {  //it's an or so it can be that one of the 2 conditions is not sat
			if ( i > m ) //it means we finished the elements on the left but there are still on the right
				a[k++] = clone[j++];
			else if (j > end)
				a[k++] = clone[i++];
			else if(clone[j] < clone[i])
				a[k++] = clone[j++];
			else
				a[k++] = clone[i++];			
		}
	}
	
	
	public static int countInversions(int[]array, int start, int end, int[] aux) {
		return mergeSortWithInv(array, start, end, aux);
		
	}
	
	public static int mergeSortWithInv(int[]a, int start, int end, int[] copy) {
		int inversions = 0;
		if(start == end)
			return inversions;
		int m = (start+end)/2;
		inversions += mergeSortWithInv(copy, start, m, a);
		inversions += mergeSortWithInv(copy, m+1, end, a);
		inversions += mergeWithInv(a, start, m, end, copy);
		return inversions;
	}
	
	
	public static int mergeWithInv(int[]a, int start, int m, int end, int[]copy) {
		int inv = 0;
		int i=start, j=m+1, k=start;
		while(i <= m || j <= end) {
			if(j > end)
				a[k++] = copy[i++];
			else if (i > m)
				a[k++] = copy[j++];
			else if (copy[j] < copy[i]) {
				a[k++] = copy[j++];
				inv += m-i+1;
			}
			else
				a[k++] = copy[i++];
		}
		return inv;
	}
	
	public static void main(String[] args){
		int[] array = {'w','h','a','t',' ','a',' ','w','o','n','d','e','r','f','u','l',' ','d','a','y',' ',':',')'};
		//auxiliary array for avoiding 2 temp arrays every time
		int[] aux = array.clone();
		int[] clone = array.clone();
		int[] clone1 = array.clone();
		mergesort(array, 0, array.length-1, aux);
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(clone));
		System.out.println("number of inversions(10): "+mergeSortWithInv(clone, 0, clone.length-1, clone1));
		
		array = new int[]{9,8,7,6,5,4,3,2,1};
		aux = array.clone();
		clone = array.clone();
		clone1 = array.clone();
		mergesort(array, 0, 8, aux);
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(clone));
		System.out.println("number of inversions(10): "+mergeSortWithInv(clone, 0, clone.length-1, clone1));
		
	}

}
