
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

	
	myGraph.addVertex(f);
	myGraph.addVertex(a);
	myGraph.addVertex(b);
	myGraph.addVertex(c);
	myGraph.addVertex(d);
	myGraph.addVertex(e);


//	myGraph.addEdge(new Edge(a,b));
	myGraph.addEdge(new Edge(b,c));
	myGraph.addEdge(new Edge(e,b));
	myGraph.addEdge(new Edge(d,f));
//	myGraph.addEdge(new Edge(a,b));

	myGraph.addEdge(new Edge(d,e));
//	myGraph.addEdge(new Edge(a,e));
//	myGraph.addEdge(new Edge(c,d));

	for (Vertex v : myGraph.getVertices()) {
		System.out.print(v.getID());
	}
	System.out.println();

	for (Edge ee : myGraph.getEdges()) {
		System.out.print(ee.getVertex1().getID());
		System.out.print(ee.getVertex2().getID());
	}
	System.out.println();
	
//	myGraph.removeEdge(4);
//	myGraph.removeEdge(2);
//	myGraph.removeVertex(2);
	
	for (Vertex v : myGraph.getVertices()) {
		System.out.print(v.getID());
	}
	System.out.println();

	for (Edge ee : myGraph.getEdges()) {
		System.out.print(ee.getVertex1().getID());
		System.out.print(ee.getVertex2().getID());
	}
	System.out.println();

	
	System.out.println(myGraph.isConnected());
	System.out.println(myGraph.isAdjacent('A', 'B'));
	System.out.println(myGraph.isAdjacent('C', 'B'));
	System.out.println(myGraph.isAdjacent('A', 'C'));
	System.out.println(myGraph.getAdjacentVertices('B'));
	System.out.println(myGraph.getAdjacentVertices('E'));


}

}

