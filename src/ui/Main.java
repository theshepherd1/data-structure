
package ui;

import bp.Vertex;
import bp.Edge;
import bp.Graph;
import bp.UnsortedList;

public class Main {

public static void main(String[] args) {

	Graph myGraph = new Graph();
	Graph myGraph2 = new Graph();
	
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
//	myGraph.addVertex(g);
//	myGraph.addVertex(h);
//	myGraph.addVertex(i);
//	myGraph.addVertex(j);
//	myGraph.addVertex(k);

//	myGraph.addEdge(new Edge(a,b));
//	myGraph.addEdge(new Edge(a,f));
//	myGraph.addEdge(new Edge(a,d));
//	myGraph.addEdge(new Edge(b,d));
//	myGraph.addEdge(new Edge(b,e));
//	myGraph.addEdge(new Edge(b,c));
//	myGraph.addEdge(new Edge(c,d));
//	myGraph.addEdge(new Edge(d,e));
//	myGraph.addEdge(new Edge(d,e));
//	myGraph.addEdge(new Edge(e,f));
//	myGraph.addEdge(new Edge(f,g));
//	myGraph.addEdge(new Edge(f,h));
//	myGraph.addEdge(new Edge(h,g));
//	myGraph.addEdge(new Edge(c,g));
	
	myGraph2.addVertex(a);
	myGraph2.addVertex(b);
	myGraph2.addVertex(c);
	myGraph2.addVertex(d);
	myGraph2.addVertex(e);
	myGraph2.addVertex(f);

	myGraph2.addEdge(new Edge(a,b));
	myGraph2.addEdge(new Edge(a,d));
	myGraph2.addEdge(new Edge(b,c));
	myGraph2.addEdge(new Edge(c,f));
	myGraph2.addEdge(new Edge(f,e));
	myGraph2.addEdge(new Edge(e,d));
	




	
//	myGraph.removeEdge(4);
//	myGraph.removeEdge(2);
//	myGraph.removeVertex(2);
	System.out.println(String.valueOf(myGraph.isConnected()));
	System.out.println(String.valueOf(myGraph2.hasStrongEulerCycle('A')));
}

}

