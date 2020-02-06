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
			else if (clone[j] < clone[i])
				a[k++] = clone[i++];			
		}
	}
	
	public static void main(String[] args){
		int[] array = {5,4,3,2,1};
		//auxiliary array for avoiding 2 temp arrays every time
		int[] aux = array.clone();
		mergesort(array, 0, array.length-1, aux);
		System.out.println(Arrays.toString(array));
		
		array = new int[]{9,8,7,6,5,4,3,2,1};
		aux = array.clone();
		mergesort(array, 0, 8, aux);
		System.out.println(Arrays.toString(array));
		
	}

}
