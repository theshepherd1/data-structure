
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


	myGraph.addEdge(new Edge(a,b));
	myGraph.addEdge(new Edge(b,c));
	myGraph.addEdge(new Edge(e,b));
	myGraph.addEdge(new Edge(d,f));
//	myGraph.addEdge(new Edge(a,b));

	myGraph.addEdge(new Edge(d,e));
//	myGraph.addEdge(new Edge(a,e));
//	myGraph.addEdge(new Edge(c,d));


	
//	myGraph.removeEdge(4);
//	myGraph.removeEdge(2);
//	myGraph.removeVertex(2);
	
	System.out.println(myGraph.BreadthFirstSearch());

}

}

