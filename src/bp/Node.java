package bp;

import java.time.LocalDate;

public class Node implements IBinaryTreeNode {

	private Node parent;
	private Node leftChild;
	private Node rightChild;
	
	private LocalDate date;
	
	public Node(LocalDate pDate) {
		setDate(pDate);
	}
	
	@Override
	public LocalDate getDate() {
		return date;
	}

	@Override
	public void setDate(LocalDate pDate) {
		date = pDate;
	}

	@Override
	public Node getLeftChild() {
		return leftChild;
	}

	@Override
	public void setLeftChild(Node pLeftChild) {
		leftChild = pLeftChild;
		leftChild.setParent(this);
	}

	@Override
	public Node getRightChild() {
		return rightChild;
	}

	@Override
	public void setRightChild(Node pRightChild) {
		rightChild = pRightChild;
		rightChild.setParent(this);
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
	
}
