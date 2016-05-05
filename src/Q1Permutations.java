
/**
 * This class contains the solution to the permutations part of Q1.
 * The Combinations Algorithm is in the Q1Combinations class
 * 
 * 2 algorithms have been implmented. The take 2, as well as Heap's.
 * Running time comparisions are in the report
 * 
 * @author Darshan Narayana Reddy and Mahesh Venkateswaran
 *
 */
public class Q1Permutations {
	static int count;
	
	static void Permute(int[] a, int i){
		if(i==0)
			Visit(a);
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
			Visit(a);
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

	private static void Visit(int[] a) {
		if(a.length < 4){
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
		int n = 14;
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		Timer t = new Timer();
		
		//Take2
//		t.start();
//		count=0;
//		Permute(a, a.length-1);
//		t.end();
//		System.out.println("n! = "+count);
//		System.out.println(t);
		
		//Heaps
		t.start();
		count=0;
		HeapsPermute(a, a.length);
		t.end();
		System.out.println("Heaps n! = "+count);
		System.out.println(t);
	}
}

//For better accuracy with time, one section was commented out before running the other
//Sample output:

//120
//210
//201
//021
//102
//012
//n! = 6
//Time: 0 msec.
//Memory: 1 MB / 64 MB.
//012
//102
//201
//021
//120
//210
//Heaps n! = 6
//Time: 0 msec.
//Memory: 1 MB / 64 MB.


//Sample output 2: n=12
//Take 2:

//n! = 479001600
//Time: 8101 msec.
//Memory: 1 MB / 64 MB.


//Sample output 3: n=12
//Heaps:

//Heaps n! = 479001600
//Time: 7078 msec.
//Memory: 1 MB / 64 MB.

