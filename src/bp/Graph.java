package bp;

import java.util.ArrayList;
import java.util.List;

public class Graph implements IGraph {

	List<Vertex> verticies = new ArrayList();
	List<Edge> edges = new ArrayList();
	
	@Override
	public Vertex getVertexByID(char pID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Edge> getEdges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEdges(List<Edge> pEdges) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Vertex> getVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setVertices(List<Vertex> pVertices) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEdge(Edge pEdge) {
		edges.add(pEdge);
		addVertex(pEdge.getVertex1());
		addVertex(pEdge.getVertex2());
	}

	@Override
	public void removeEdge(int pIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addVertex(Vertex pVertex) {
		boolean found = false;
		for (Vertex v: verticies) {
			if (v.getID() == pVertext.getID()) {
				found = true;
			}
		}
		
	}

	@Override
	public void removeVertex(int pIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAdjacent(char pVertex1ID, char pVertex2ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public char[] getAdjacentVertices(char pVertexID) {
		// TODO Auto-generated method stub
		return null;
	}

}
