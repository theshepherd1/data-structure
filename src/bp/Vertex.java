package bp;

import java.util.List;

public class Vertex implements IVertex {

	@Override
	public char getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setID(char pID) {
		// TODO Auto-generated method stub

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
