
/**
 * This class contains the solution to the combinations part of Q1.
 * The Permutations Algorithm is in the Q1Permutations class
 * 
 * @author Darshan Narayana Reddy and Mahesh Venkateswaran
 *
 */
public class Q1Combinations {
	
	static int count;
	
	private static void Combination(boolean[] a, int n, int k) {
		if(k>n)
			return;
		else if(k==0)
			visit(a);
		else{
			Combination(a, n-1, k);
			a[n] = true;
			Combination(a, n-1, k-1);
			a[n] = false;
		}
	}
	
	private static void visit(boolean[] a) {
		if(a.length < 6){
			for (int i = 1; i < a.length; i++) {
				if(a[i])
					System.out.print(i);
			}
			System.out.println();
		}
		count++;
	}

	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		boolean[] a = new boolean[n+1];
		for (int i = 0; i < a.length; i++) {
			a[i] = false;
		}
		Timer t = new Timer();
		count = 0;
		Combination(a, n, k);
		t.end();
		System.out.println(n+"C"+k+" = "+count);
		System.out.println(t);
	}

}

//Sample output:

//12
//13
//23
//14
//24
//34
//4C2 = 6
//Time: 0 msec.
//Memory: 1 MB / 64 MB.

