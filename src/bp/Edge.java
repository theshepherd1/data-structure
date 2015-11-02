package bp;

import interfaces.IEdge;

public class Edge implements IEdge {

	private Vertex v1;
	private Vertex v2;
	private boolean visited;
	
	public Edge(Vertex pV1, Vertex pV2) {
		v1 = pV1;
		v2 = pV2;
		v1.addEdge(this);
		v2.addEdge(this);
		setVisited(false);
	}
	
	@Override
	public Vertex getVertex1() {
		return v1;
	}

	@Override
	public void setVertex1(Vertex vertex1) {
		v1 = vertex1;
	}

	@Override
	public Vertex getVertex2() {
		return v2;
	}

	@Override
	public void setVertex2(Vertex vertex2) {
		v2 = vertex2;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}
