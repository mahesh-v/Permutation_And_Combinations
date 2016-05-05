import java.util.Random;


/**
 * 
 * Knuth's algorithm for listing permutations in lexicographic order.
 * 
 * @author Darshan Narayana Reddy and Mahesh Venkateswaran
 *
 */
public class Q3KnuthsAlgo {
	
	static long count;

	private static void knuthsAlgo(int[] a) {
		int j =0, l=0;
		visit(a);
		while(true){
			for (j = a.length-1; j > 0; j--) {
				if(a[j-1] < a[j])
					break;
			}
			j--;
			if(j==-1)
				break;
			for(l=a.length-1;l > j;l--){
				if(a[l] > a[j])
					break;
			}
			swap(a, j, l);
			reverse(a, j+1);
			visit(a);
		}
	}
	
	private static void reverse(int[] a, int start) {
		int end = a.length-1;
		for (int j = start; j < (a.length+start)/2; j++) {
			swap(a, j, end--);
		}
	}

	private static void visit(int[] a) {
		if(a.length < 5){
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i]);
			}
			System.out.println();
		}
		count++;
	}
	
	private static void swap(int[] a, int j, int i) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
//		int[] a = {1, 2, 2, 3};
		int n = 14;
		int[] a = new int[n];
		int val = 1;
		Random rand = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = val;
			if(rand.nextBoolean())
				val++;
		}
		System.out.println("Number of unique values = "+val);
		System.out.println("Total number of values = "+n);
		Timer t = new Timer();
		knuthsAlgo(a);
		t.end();
		System.out.println("Count = "+count);
		System.out.println(t);
	}

}

//Sample output for n=14:
//
//Number of unique values = 8
//Total number of values = 14
//Count = 302702400
//Time: 4109 msec.
//Memory: 1 MB / 64 MB.
