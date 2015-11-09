package bp;

import interfaces.IEdge;
import bp.Direction;

public class Edge implements IEdge {

	private Vertex v1;
	private Vertex v2;
	private double weight;
	private boolean visited;
	private Direction direction;
	
	public Edge(Vertex pV1, Vertex pV2) {
		v1 = pV1;
		v2 = pV2;
		v1.addEdge(this);
		v2.addEdge(this);
		setVisited(false);
	}
	
	public Edge(Vertex pV1, Vertex pV2, double pWeight) {
		v1 = pV1;
		v2 = pV2;
		v1.addEdge(this);
		v2.addEdge(this);
		setVisited(false);
		setWeight(pWeight);
	}
	
	public Edge(Vertex pV1, Vertex pV2, double pWeight, Direction pDirection) {
		v1 = pV1;
		v2 = pV2;
		v1.addEdge(this);
		v2.addEdge(this);
		setVisited(false);
		setWeight(pWeight);
		setDirection(pDirection);
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

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}
