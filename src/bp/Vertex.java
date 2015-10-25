package bp;

import java.util.List;

public class Vertex implements IVertex {

	private char id;
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEdges(List<Edge> edges) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEdge(Edge pEdge) {
		throw new UnsupportedOperationException("add edges through the graph interface");
	}

	@Override
	public void removeEdge(int pIndex) {
		throw new UnsupportedOperationException("remove edges through the graph interface");
	}

}
