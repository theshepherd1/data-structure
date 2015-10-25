package bp;

import java.util.ArrayList;
import java.util.List;

public class Graph implements IGraph {

	private List<Vertex> verticies = new ArrayList<Vertex>();
	private List<Edge> edges = new ArrayList<Edge>();
	
	@Override
	public Vertex getVertexByID(char pID) {
		for (Vertex v : verticies) {
			if (v.getID() == pID) {
				return v;
			}
		}
		return null;
	}

	@Override
	public List<Edge> getEdges() {
		return edges;
	}

	@Override
	public void setEdges(List<Edge> pEdges) {
		edges = pEdges;
	}

	@Override
	public List<Vertex> getVertices() {
		return verticies;
	}

	@Override
	public void setVertices(List<Vertex> pVertices) {
		verticies = pVertices;
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
			if (v.getID() == pVertex.getID()) {
				found = true;
			}
		}
		if (!found) {
			
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
