package ui;

import java.util.Arrays;

import bp.Edge;
import bp.Graph;
import bp.Vertex;
import bp.Direction;

public class Main {
public static void main(String[] args) {

Graph graph = new Graph();

// Declare Vertices
Vertex a = new Vertex('A');
Vertex b = new Vertex('B');
Vertex c = new Vertex('C');
Vertex d = new Vertex('D');
Vertex e = new Vertex('E');
Vertex f = new Vertex('F');

graph.addVertex(a);
graph.addVertex(b);
graph.addVertex(c);
graph.addVertex(d);
graph.addVertex(e);
graph.addVertex(f);


graph.addEdge(new Edge(a,b,10));
graph.addEdge(new Edge(a,c,10, Direction.FORWARD));
graph.addEdge(new Edge(b,b,2));
graph.addEdge(new Edge(b,e,21, Direction.FORWARD));
graph.addEdge(new Edge(e,f,10, Direction.NEITHER));
graph.addEdge(new Edge(e,d,9, Direction.FORWARD));
graph.addEdge(new Edge(c,d,9, Direction.BACKWARD));
graph.addEdge(new Edge(d,f,20));
graph.addEdge(new Edge(d,e,9, Direction.BACKWARD));

//System.out.println("List of E's adjacencies: " + Arrays.toString(graph.getAdjacentVertices('E'))); //B, F, D
//
System.out.println("Is this graph connected: " + graph.isConnected()); //True
//
//System.out.println("Are D and E adjacent: " + graph.isAdjacent('D', 'E')); //True
//
//System.out.println("Are A and F adjacent: " + graph.isAdjacent('A', 'F')); //False
//
//System.out.println("Depth first search: " + Arrays.toString(graph.DepthFirstSearch()));
//
//System.out.println("Breadth first search: " + Arrays.toString(graph.BreadthFirstSearch()));
//
System.out.println("Does this graph have an Euler cycle: " + graph.hasStrongEulerCycle('A')); //True

System.out.println("If it has a cycle, what is it: " + Arrays.toString(graph.StrongEulerCycle('A')));

System.out.println("Is the graph complete: " + graph.isComplete());

System.out.println("Get shortest path from A to F: " + Arrays.toString(graph.getShortestPath('A', 'F'))); 

for (Vertex v : graph.getVertices()) {
	System.out.println(v.getDistance());
}


}
}