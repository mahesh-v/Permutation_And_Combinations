
/**
 * Solution to Q2, nPk
 * 
 * @author Darshan Narayana Reddy and Mahesh Venkateswaran
 *
 */
public class Q2nPk {
	
	static int count;
	
	static void nPk(int n, int k) {
		boolean[] a = new boolean[n+1];
		for (int i = 0; i < a.length; i++) {
			a[i] = false;
		}
		Combination(a, n, k, k);
	}
	
	private static void Combination(boolean[] a, int n, int k, int initialK) {
		if(k>n)
			return;
		else if(k==0)
			visit(a, initialK);
		else{
			Combination(a, n-1, k, initialK);
			a[n] = true;
			Combination(a, n-1, k-1, initialK);
			a[n] = false;
		}
	}
	
	private static void visit(boolean[] a, int initialK) {
		int[] arr = new int[initialK];
		int c = 0;
		for (int i = 1; i < a.length; i++) {
			if(a[i])
				arr[c++] = i;
		}
//		Permute(arr, initialK-1);
		HeapsPermute(arr, initialK);
	}
	
	static void Permute(int[] a, int i){
		if(i==0)
			permutationsVisit(a);
		else{
			for (int j = 0; j <= i; j++) {
				swap(a, j, i);
				Permute(a, i-1);
				swap(a, i, j);
			}
		}
	}
	
	static void HeapsPermute(int[] a, int i){
		if(i==1)
			permutationsVisit(a);
		else{
			for (int j = 0; j < i-1; j++) {
				HeapsPermute(a, i-1);
				if(i%2==0)
					swap(a, j, i-1);
				else
					swap(a, 0, i-1);
			}
			HeapsPermute(a, i-1);
		}
	}

	private static void permutationsVisit(int[] a) {
//		for (int i = 0; i < a.length; i++) {
//			System.out.print(a[i]);
//		}
//		System.out.println();
		count++;
	}
	
	private static void swap(int[] a, int j, int i) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
		int n = 14;
		int k = 9;
		
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		Timer t = new Timer();
		count = 0;
		nPk(n, k);
		t.end();
		System.out.println(n+"P"+k+" = "+count);
		System.out.println(t);
	}
}

//Sample output:

//14P9 = 726485760
//Time: 12028 msec.
//Memory: 1 MB / 64 MB.
