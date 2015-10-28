package bp;

import interfaces.IVertex;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements IVertex {

	private char id;
	private List<Edge> edges = new ArrayList<Edge>();
	private boolean visited = false;
	
	public Vertex(char pID) {
		id = pID;
	}
	
	@Override
	public char getID() {
		return id;
	}

	@Override
	public void setID(char pID) {
		id = pID;
	}

	@Override
	public List<Edge> getEdges() {
		return edges;
	}

	@Override
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
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
		}
	}

	@Override
	public void removeEdge(int pIndex) {
		if (pIndex >= 0 && pIndex < edges.size() && edges.get(pIndex) != null) {
			edges.remove(pIndex);
		}
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}
