package bp;

import java.util.ArrayList;
import java.util.List;

public class Graph implements IGraph {

	private List<Vertex> vertices = new ArrayList<Vertex>();
	private List<Edge> edges = new ArrayList<Edge>();
	
	@Override
	public Vertex getVertexByID(char pID) {
		for (Vertex v : vertices) {
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
		return vertices;
	}

	@Override
	public void setVertices(List<Vertex> pVertices) {
		vertices = pVertices;
	}

	@Override
	public void addEdge(Edge pEdge) {
		boolean found = false;
		for (Edge e : edges) {
			if ((e.getVertex1().getID() == pEdge.getVertex1().getID() && e.getVertex2().getID() == pEdge.getVertex2().getID()) || 
					(e.getVertex1().getID() == pEdge.getVertex1().getID() && e.getVertex2().getID() == pEdge.getVertex2().getID())) {
				found = true;
				break;
			}
		}
		if (!found) {
			edges.add(pEdge);
			if (pEdge.getVertex1() != null) {
				addVertex(pEdge.getVertex1());
			}
			if (pEdge.getVertex2() != null) {
				addVertex(pEdge.getVertex2());
			}
		}
	}

	@Override
	public void removeEdge(int pIndex) {
		if (pIndex < edges.size() && edges.get(pIndex) != null) {
			Edge myEdge = edges.get(pIndex);
			myEdge.setVertex1(null);
			myEdge.setVertex2(null);
			myEdge = null;
			edges.remove(pIndex);
		}
	}

	@Override
	public void addVertex(Vertex pVertex) {
		boolean found = false;
		for (Vertex v: vertices) {
			if (v.getID() == pVertex.getID()) {
				found = true;
				break;
			}
		}
		if (!found) {
			vertices.add(pVertex);
			if (!pVertex.getEdges().isEmpty()) {
				for (Edge e : pVertex.getEdges()) {
					edges.add(e);
				}
			}
		}
	}

	@Override
	public void removeVertex(int pIndex) {
		if (pIndex < vertices.size() && vertices.get(pIndex) != null) {
			vertices.remove(pIndex);
		}
	}

	@Override
	public boolean isConnected() {
		for (Vertex v : vertices) {
			if (v.getEdges().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isAdjacent(char pVertex1ID, char pVertex2ID) {		
		if (pVertex1ID != pVertex2ID && getVertexByID(pVertex1ID) != null && getVertexByID(pVertex2ID) != null) {
			Vertex v1 = getVertexByID(pVertex1ID);
			Vertex v2 = getVertexByID(pVertex2ID);
			if (!v1.getEdges().isEmpty() && !v2.getEdges().isEmpty()) {
				List<Edge> edges1 = v1.getEdges();
				List<Edge> edges2 = v2.getEdges();
				for (Edge e1 : edges1) {
					for (Edge e2 : edges2) {
						if (e1.equals(e2)) {
							return true;
						}
					}
				}
			}
			
		}
		return false;
	}

	@Override
	public char[] getAdjacentVertices(char pVertexID) {
		if (getVertexByID(pVertexID) != null) {
			Vertex myVertex = getVertexByID(pVertexID);
			if (!myVertex.getEdges().isEmpty()) {
				List<Character> temp = new ArrayList<Character>();
				List<Edge> myEdges = myVertex.getEdges();
				for (Edge e : myEdges) {
					if (e.getVertex1() != null && !e.getVertex1().equals(myVertex)) {
						temp.add(Character.valueOf(e.getVertex1().getID()));
					} else if (e.getVertex2() != null && !e.getVertex2().equals(myVertex)) {
						temp.add(Character.valueOf(e.getVertex2().getID()));
					}
				}
				char[] result = new char[temp.size()];
				for (int i = 0; i < temp.size(); i++) {
					result[i] = temp.get(i);
				}
				return result;
			}
			return "".toCharArray();
		}
		return "".toCharArray();
	}

}
