package bp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import interfaces.IGraph;
import interfaces.IGraph2;

public class Graph implements IGraph, IGraph2 {

	private static final int MAX = 100000;
	
	private List<Vertex> vertices = new ArrayList<Vertex>();
	private List<Edge> edges = new ArrayList<Edge>();
	
	private int visitedCounter = 0;
	
	private List<Character> path = new ArrayList<Character>();
	
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
//		boolean found = false;
//		for (Edge e : edges) {
//			if ((e.getVertex1().getID() == pEdge.getVertex1().getID() && e.getVertex2().getID() == pEdge.getVertex2().getID()) || 
//					(e.getVertex1().getID() == pEdge.getVertex1().getID() && e.getVertex2().getID() == pEdge.getVertex2().getID())) {
//				found = true;
//				break;
//			}
//		}
//		if (!found) {
			edges.add(pEdge);
//		}
	}

	@Override
	public void removeEdge(int pIndex) {
		if (pIndex >= 0 && pIndex < edges.size() && edges.get(pIndex) != null) {
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
		if (pIndex >= 0 && pIndex < vertices.size() && vertices.get(pIndex) != null) {
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
		clearVisited();		
		if (vertices.get(0) != null) {
			visitedCounter = 0;
			dfs(vertices.get(0).getID());
		}
		if (visitedCounter != vertices.size()) {
			return false;
		} else {
			return true;
		}
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
					if (e.getVertex1() != null && !e.getVertex1().equals(myVertex) && !temp.contains(e.getVertex1().getID())) {
						temp.add(Character.valueOf(e.getVertex1().getID()));
					} else if (e.getVertex2() != null && !e.getVertex2().equals(myVertex) && !temp.contains(e.getVertex2().getID())) {
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
	
	@Override
	public char[] DepthFirstSearch() {
		clearVisited();
		clearPath();
		dfs(vertices.get(0).getID());
		return pathToCharArray();
	}

	@Override
	public char[] BreadthFirstSearch() {
		clearVisited();
		clearPath();
		bfs(vertices.get(0).getID());
		return pathToCharArray();
	}

	@Override
	public char[] HamiltonianCycle(char pVertexID) {
		if (!isConnected()) {
			return new char[0];
		}
		if (vertices.size() < 3) {
			return new char[0];
		}
		clearPath();
		path.add(pVertexID);
		if (hc(1) == true) {
			path.add(pVertexID);
			return pathToCharArray();
		}
		return new char[0];
	}

	@Override
	public char[] HamiltonianPath(char pVertex1ID, char pVertex2ID) {
		if (!isConnected()) {
			return new char[0];
		}		
		if (vertices.size() < 3) {
			return new char[0];
		}
		clearPath();
		path.add(pVertex1ID);
		if (hp(1, pVertex1ID, pVertex2ID) == true) {
			return pathToCharArray();
		}
		return new char[0];
	}

	@Override
	public char[] StrongEulerCycle(char pVertexID) {
		if (!hasStrongEulerCycle(pVertexID)) {
			return new char[0];
		} else {
			clearVisited();
			clearPath();
			dfs2(pVertexID);
		}
		return pathToCharArray();
	}

	@Override
	public boolean hasStrongEulerCycle(char pVertexID) {
		if (!isConnected()) {
			return false;
		}
		for (Vertex v : vertices) {
			if ((v.getEdges().size()%2) != 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isComplete() {
		int n = vertices.size();
		if (edges.size() == n*(n-1)/2 && isConnected()) {
			return true;
		} else {
			return false;
		}
	}
	
	private void dfs(char id) {
		Vertex source = getVertexByID(id);
		source.setVisited(true);
		path.add(source.getID());
		visitedCounter++;
		char[] myVertexIds = getAdjacentVertices(source.getID());
		for (char c : myVertexIds) {
			if (getAdjacentVertices(c) != null && !getVertexByID(c).isVisited()) {
				dfs(c);
			}
		}
	}
	
	private void dfs2(char id) {
		Vertex source = getVertexByID(id);
		Stack<Vertex> s = new Stack<Vertex>();
		s.push(source);
		while (!s.isEmpty()) {
			Vertex visit = s.peek();
			if (hasUnvisited(visit.getID())) {
				for (Edge e : visit.getEdges()) {
					if (!e.isVisited()) {
						Vertex v = visit.getID() == e.getVertex1().getID() ? e.getVertex2() : e.getVertex1();
						s.push(v);
						e.setVisited(true);
						break;
					}
				}
			} else {
				s.pop();
				path.add(visit.getID());
			}
		}
	}
	
	private boolean hasUnvisited(char id) {
		Vertex v = getVertexByID(id);
		for (Edge e : v.getEdges()) {
			if (!e.isVisited()) {
				return true;
			}
		}
		return false;
	}
	
	private void bfs(char id) {
		Vertex source = getVertexByID(id);
		Queue<Vertex> q = new LinkedList<Vertex>();
		q.add(source);
		while (!q.isEmpty()) {
			Vertex visit = q.remove();
			visit.setVisited(true);
			path.add(visit.getID());
			visitedCounter++;
			char[] adjIds = getAdjacentVertices(visit.getID());
			for (char adjId : adjIds) {
				if (adjIds != null && getVertexByID(adjId).isVisited() == false) {
					q.add(getVertexByID(adjId));
					getVertexByID(adjId).setVisited(true);
				}
			}
		}	
	}
	
	private boolean isSafe(int index, int pos) {
		if (!isAdjacent(vertices.get(index).getID(), path.get(pos-1))) {
			return false;
		}
		for (char c : path) {
			if (vertices.get(index).getID() == c) {
				return false;
			}
		}
		return true;
	}
	
	private boolean hc(int pos) {
		if (path.size() == vertices.size()) {
			char first  = path.get(0);
			char last = path.get(path.size()-1);
			if (isAdjacent(first,last)) {
				return true;
			} else {
				return false;
			}
		}
		
		for (int i = 0; i < vertices.size(); i++) {
			if (isSafe(i, pos)) {
				path.add(vertices.get(i).getID());
				if (hc(pos+1)) {
					return true;
				} else {
					path.remove(path.size()-1);
				}
			}
		}
		return false;
	}
	
	private boolean hp(int pos, char start, char end) {
		if (path.size() == vertices.size()) {
			char first = path.get(0);
			char last = path.get(path.size()-1);
			if (first == start && last == end) {
				return true;
			} else {
				return false;
			}
		}
		
		for (int i = 0; i < vertices.size(); i++) {
			if (isSafe(i, pos)) {
				path.add(vertices.get(i).getID());
				if (hp(pos+1, start, end)) {
					return true;
				} else {
					path.remove(path.size()-1);
				}
			}
		}
		return false;
	}
	
	private void ec(char u, Graph g) {
		for (char c : getAdjacentVertices(u)) {
			Vertex v = getVertexByID(c);
			if (v != null && isValidEdge(u, v.getID(), g)) {
				path.add(u);
				path.add(v.getID());
				ec(v.getID(), g);
			}
		}
	}
		
	private Edge getSharedEdge(char u, char v) {
		for (Edge e1 : getVertexByID(u).getEdges()) {
			for (Edge e2: getVertexByID(v).getEdges()) {
				if (e2.equals(e1)) {
					return e2;
				}
			}
		}
		return null;
	}
	
	private boolean isValidEdge(char u, char v, Graph g) {
		if (getAdjacentVertices(u).length == 1 && getAdjacentVertices(u)[0] == v) {
			return true;
		}
		Edge e = getSharedEdge(u, v);
		g.removeEdge(edges.indexOf(e));
		if (g.isConnected()) {
			return true;
		}
		return false;
	}
	
	private void clearVisited() {
		for (Vertex v : vertices) { 
			v.setVisited(false);
		}
		for (Edge e : edges) {
			e.setVisited(false);
		}
		visitedCounter = 0;
	}

	private void clearPath() {
		path.clear();
	}
	
	private char[] pathToCharArray() {
		char[] result = new char[path.size()];
		for (int i = 0; i < path.size(); i++) {
			result[i] = path.get(i);
		}
		return result;
	}

	///!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!WEIGHTED GRAPHTS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	@Override
	public char[] getShortestPath(char pVertex1ID, char pVertex2ID) {
		// TODO Auto-generated method stub
		return null;
	}
}
