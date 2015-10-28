package test;

import static org.junit.Assert.*;

import org.junit.Test;

import bp.Edge;
import bp.Graph;
import bp.Vertex;

public class GraphTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	public void isConnectedTest() {
		Graph g = new Graph();
		Vertex a = new Vertex('A');
		Vertex b = new Vertex('B');
		g.addEdge(new Edge(a,b));
		
		assertTrue(g.isConnected()); 
	}
	
	@Test
	public void isNotConnected() {
		Graph g = new Graph();
		Vertex a = new Vertex('A');
		Vertex b = new Vertex('B');
		Vertex c = new Vertex('C');
		
		g.addVertex(c);
		g.addEdge(new Edge(a,b));
		assertFalse(g.isConnected());
	}
	

}
