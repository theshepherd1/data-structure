package ui;

import bp.Edge;
import bp.Vertex;
import bp.Graph;

public class Main {
public static void main(String[] args) {

// Declare Vertices
Vertex vertexA = new Vertex('A');
Vertex vertexB = new Vertex('B');
Vertex vertexC = new Vertex('C');
Vertex vertexD = new Vertex('D');

// Graph 1
Graph graph1 = new Graph();
System.out.println("First Graph...");

// Add Needed Vertices to the graph
graph1.addVertex(vertexA);
graph1.addVertex(vertexB);
graph1.addVertex(vertexC);
graph1.addVertex(vertexD);

// Add new edges between the used vertices
graph1.addEdge(new Edge(vertexA, vertexB));
graph1.addEdge(new Edge(vertexA, vertexB));
graph1.addEdge(new Edge(vertexA, vertexC));
graph1.addEdge(new Edge(vertexA, vertexD));
graph1.addEdge(new Edge(vertexB, vertexC));
graph1.addEdge(new Edge(vertexB, vertexC));
graph1.addEdge(new Edge(vertexB, vertexD));
graph1.addEdge(new Edge(vertexB, vertexD));
graph1.addEdge(new Edge(vertexC, vertexD));

// Test 1
System.out.println("Is this graph connected? " + graph1.isConnected()); // True
System.out.println("Are B and C adjacent? "
+ graph1.isAdjacent('B', 'C')); // True
System.out.print("What are B\'s adjacencies? "); // A,C,D
char[] graph1BAdj = graph1.getAdjacentVertices('B');
for (char c : graph1BAdj) {
System.out.print(c);
}
System.out.print("\nDepth First Search: "); // Check the Path
char[] graph1Depth = graph1.DepthFirstSearch();
for (char c : graph1Depth) {
System.out.print(c);
}
System.out.print("\nBreadth First Search: "); // Check the Path
char[] graph1Breadth = graph1.BreadthFirstSearch();
for (char c : graph1Breadth) {
System.out.print(c);
}
System.out.println("\nDoes this graph have a strong euler cycle? "
+ graph1.hasStrongEulerCycle('A')); // True
System.out.print("If so, give me a euler cycle: "); // Check the Path
char[] graph1Euler = graph1.StrongEulerCycle('A');
for (char c : graph1Euler) {
System.out.print(c);
}
System.out
.println("\nIs this a complete graph? " + graph1.isComplete()); // True
System.out.print("Hamiltonian Cycle: ");
char[] graph1HamCyc = graph1.HamiltonianCycle('A');
for (char c : graph1HamCyc) {
System.out.print(c);
}
System.out.println();
System.out.print("Hamiltonian Path: ");
char[] graph1HamPath = graph1.HamiltonianPath('A', 'D');
for (char c : graph1HamPath) {
System.out.print(c);
}

// New Graph
Graph graph2 = new Graph();
System.out.println("\n\n\nSecond Graph...");

// Declare Vertices
vertexA = new Vertex('A');
vertexB = new Vertex('B');
vertexC = new Vertex('C');
vertexD = new Vertex('D');

// Add Vertices
graph2.addVertex(vertexA);
graph2.addVertex(vertexB);
graph2.addVertex(vertexC);
graph2.addVertex(vertexD);

// Add Edges
graph2.addEdge(new Edge(vertexA, vertexB));
graph2.addEdge(new Edge(vertexD, vertexB));

// Test 2
System.out.println("Is this graph connected? " + graph2.isConnected()); // False
System.out.println("Are B and C adjacent? "
+ graph2.isAdjacent('B', 'C')); // False
System.out.print("What are B\'s adjacencies? "); // A,D
char[] graph2BAdj = graph2.getAdjacentVertices('B');
for (char c : graph2BAdj) {
System.out.print(c);
}
System.out.print("\nDepth First Search: "); // Check the Path
char[] graph2Depth = graph2.DepthFirstSearch();
for (char c : graph2Depth) {
System.out.print(c);
}
System.out.print("\nBreadth First Search: "); // Check the Path
char[] graph2Breadth = graph2.BreadthFirstSearch();
for (char c : graph2Breadth) {
System.out.print(c);
}
System.out.println("\nDoes this graph have a strong euler cycle? "
+ graph2.hasStrongEulerCycle('A')); // False
System.out.print("If so, give me a euler cycle: "); // Check the Path
char[] graph2Euler = graph2.StrongEulerCycle('A');
for (char c : graph2Euler) {
System.out.print(c);
}
System.out
.println("\nIs this a complete graph? " + graph2.isComplete()); // False
System.out.print("Hamiltonian Cycle: ");
char[] graph2HamCyc = graph2.HamiltonianCycle('A');
for (char c : graph2HamCyc) {
System.out.print(c);
}
System.out.println();
System.out.print("Hamiltonian Path: ");
char[] graph2HamPath = graph2.HamiltonianPath('A', 'D');
for (char c : graph2HamPath) {
System.out.print(c);
}

// New Graph
Graph graph3 = new Graph();
System.out.println("\n\nThird Graph...");

// Declare Vertices
vertexA = new Vertex('A');
vertexB = new Vertex('B');
vertexC = new Vertex('C');
vertexD = new Vertex('D');
Vertex vertexE = new Vertex('E');
Vertex vertexF = new Vertex('F');
Vertex vertexG = new Vertex('G');

// Add Vertices
graph3.addVertex(vertexA);
graph3.addVertex(vertexB);
graph3.addVertex(vertexC);
graph3.addVertex(vertexD);
graph3.addVertex(vertexE);
graph3.addVertex(vertexF);
graph3.addVertex(vertexG);

// Add Edges
graph3.addEdge(new Edge(vertexC, vertexA));
graph3.addEdge(new Edge(vertexC, vertexB));
graph3.addEdge(new Edge(vertexC, vertexD));
graph3.addEdge(new Edge(vertexC, vertexE));
graph3.addEdge(new Edge(vertexC, vertexE));
graph3.addEdge(new Edge(vertexC, vertexG));
graph3.addEdge(new Edge(vertexA, vertexB));
graph3.addEdge(new Edge(vertexB, vertexD));
graph3.addEdge(new Edge(vertexB, vertexD));
graph3.addEdge(new Edge(vertexD, vertexE));
graph3.addEdge(new Edge(vertexE, vertexF));
graph3.addEdge(new Edge(vertexF, vertexG));
graph3.addEdge(new Edge(vertexG, vertexA));
graph3.addEdge(new Edge(vertexG, vertexA));

// Test 3
System.out.println("Is this graph connected? " + graph3.isConnected()); // True
System.out.println("Are A and F adjacent? "
+ graph3.isAdjacent('A', 'F')); // False
System.out.print("What are C\'s adjacencies? "); // A,B,D,E,G
char[] graph3BAdj = graph3.getAdjacentVertices('C');
for (char c : graph3BAdj) {
System.out.print(c);
}
System.out.print("\nDepth First Search: "); // Check the Path
char[] graph3Depth = graph3.DepthFirstSearch();
for (char c : graph3Depth) {
System.out.print(c);
}
System.out.print("\nBreadth First Search: "); // Check the Path
char[] graph3Breadth = graph3.BreadthFirstSearch();
for (char c : graph3Breadth) {
System.out.print(c);
}
System.out.println("\nDoes this graph have a strong euler cycle? "
+ graph3.hasStrongEulerCycle('A')); // True
System.out.print("If so, give me a euler cycle: "); // Check the Path
char[] graph3Euler = graph3.StrongEulerCycle('A');
for (char c : graph3Euler) {
System.out.print(c);
}
System.out
.println("\nIs this a complete graph? " + graph3.isComplete()); // False
System.out.print("Hamiltonian Cycle: ");
char[] graph3HamCyc = graph3.HamiltonianCycle('A');
for (char c : graph3HamCyc) {
System.out.print(c);
}
System.out.println();
System.out.print("Hamiltonian Path: ");
char[] graph3HamPath = graph3.HamiltonianPath('A', 'G');
for (char c : graph3HamPath) {
System.out.print(c);
}
}
}

