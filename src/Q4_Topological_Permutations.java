import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author Darshan Narayana Reddy and Mahesh Venkateswaran
 *
 */
public class Q4_Topological_Permutations {
	
	static int count;

	private static void generateTopologicalOrderings(Graph g) {
		updateInDegree(g);
		boolean[] b = new boolean[g.numNodes+1];
		count=0;
		listAllTopOrderings(g, b, new ArrayList<Vertex>());
		
	}

	private static void listAllTopOrderings(Graph g, boolean[] b, ArrayList<Vertex> currentList) {
		for (Vertex v : g.verts) {
			if(v==null)
				continue;
			if(!b[v.name] && v.degree == 0){
				for (Edge e : v.Adj) {
					e.To.degree--;
				}
				b[v.name] = true;
				currentList.add(v);
				listAllTopOrderings(g, b, currentList);
				currentList.remove(v);
				b[v.name] = false;
				for (Edge e : v.Adj) {
					e.To.degree++;
				}
			}
		}
		if(currentList.size() == g.numNodes)
			visit(currentList);
	}

	private static void visit(ArrayList<Vertex> currentList) {
		if(currentList.size() < 10){
			for (Vertex vertex : currentList) {
				System.out.print(vertex+", ");
			}
			System.out.println();
		}
		count++;
	}

	private static void updateInDegree(Graph g) {
		for (Vertex vertex : g.verts) {
			if(vertex==null)
				continue;
			vertex.degree = vertex.revAdj.size();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in;
		if(args.length > 0) {
			in = new Scanner(new File(args[0]));
        } else {
        	in = new Scanner(System.in);
		}
		Graph g = Graph.readGraph(in, true);
		Timer t = new Timer();
		generateTopologicalOrderings(g);
		t.end();
		System.out.println("Number of orderings = "+count);
		System.out.println(t);
		if(in!=null)
			in.close();
	}

}

//Sample input:
//7 8
//1 2 1
//1 3 1
//2 4 1
//3 4 1
//4 5 1
//4 6 1
//5 7 1
//6 7 1

//Sample output:
//1, 2, 3, 4, 5, 6, 7, 
//1, 2, 3, 4, 6, 5, 7, 
//1, 3, 2, 4, 5, 6, 7, 
//1, 3, 2, 4, 6, 5, 7, 
//Number of orderings = 4
//Time: 0 msec.
//Memory: 1 MB / 64 MB.
