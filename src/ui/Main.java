
package ui;

import bp.Vertex;
import bp.Edge;
import bp.Graph;
import bp.UnsortedList;

public class Main {

public static void main(String[] args) {

	Graph myGraph = new Graph();
	Vertex a = new Vertex('A');
	Vertex b = new Vertex('B');
	Vertex c = new Vertex('C');
	Vertex d = new Vertex('D');
	Vertex e = new Vertex('E');
	Vertex f = new Vertex('F');
	Vertex g = new Vertex('G');
	Vertex h = new Vertex('H');
	Vertex i = new Vertex('I');
	Vertex j = new Vertex('J');
	Vertex k = new Vertex('K');


	
	myGraph.addVertex(a);
	myGraph.addVertex(b);
	myGraph.addVertex(c);
	myGraph.addVertex(d);
	myGraph.addVertex(e);
	myGraph.addVertex(f);
	myGraph.addVertex(g);
	myGraph.addVertex(h);
	myGraph.addVertex(i);
	myGraph.addVertex(j);
	myGraph.addVertex(k);

	myGraph.addEdge(new Edge(a,b));
	myGraph.addEdge(new Edge(a,c));
	myGraph.addEdge(new Edge(b,d));
	myGraph.addEdge(new Edge(b,e));
	myGraph.addEdge(new Edge(e,h));
	myGraph.addEdge(new Edge(c,g));
	myGraph.addEdge(new Edge(c,f));
	myGraph.addEdge(new Edge(f,i));
	myGraph.addEdge(new Edge(i,j));
	myGraph.addEdge(new Edge(i,k));



	
//	myGraph.removeEdge(4);
//	myGraph.removeEdge(2);
//	myGraph.removeVertex(2);
	System.out.println(String.valueOf(myGraph.isConnected()));
	char[] a1 = myGraph.DepthFirstSearch();
	for (int I = 0 ; I < myGraph.getVertices().size(); I++) {
		System.out.print((a1[I]));
	}
	System.out.println();

	a1 = myGraph.BreadthFirstSearch();
	for (int I = 0 ; I < myGraph.getVertices().size(); I++) {
		System.out.print((a1[I]));
	}
	
}

}

