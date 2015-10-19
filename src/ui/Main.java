
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

	myGraph.addEdge(new Edge(a,b));
	myGraph.addEdge(new Edge(b,c));
	myGraph.addEdge(new Edge(d,e));

	System.out.println(myGraph.isConnected());
	System.out.println(myGraph.isAdjacent('A', 'B'));
	System.out.println(myGraph.isAdjacent('C', 'B'));
	System.out.println(myGraph.isAdjacent('A', 'C'));
	System.out.println(myGraph.getAdjacentVertices('B'));

}

}

