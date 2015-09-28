package bp;

import java.time.LocalDate;

public class BinaryTree implements IBinaryTree {

	private Node rootNode;
	
	@Override
	public LocalDate showMinimumValue() {
		if (rootNode == null) {
			return LocalDate.MIN;
		} else {
			Node currentNode = rootNode;
			while (currentNode.getLeftChild() != null) {
				currentNode = currentNode.getLeftChild();
			}
			return currentNode.getDate();
		}
	}

	@Override
	public LocalDate showMaximumValue() {
		if (rootNode == null) {
			return LocalDate.MAX;
		} else {
			Node currentNode = rootNode;
			while (currentNode.getRightChild() != null) {
				currentNode = currentNode.getRightChild();
			}
			return currentNode.getDate();
		}
	}

	@Override
	public boolean isEmpty() {
		return rootNode == null;
	}

	@Override
	public int getSize() {
		return size(rootNode);
	}
	
	private int size(Node node) {
		if(node == null) {
			return 0;
		} else {
			return size(node.getLeftChild()) + size(node.getRightChild()) + 1;
		}
	}

	@Override
	public void clear() {
		rootNode = null;
	}

	@Override
	public void insert(LocalDate valueToInsert) {
		if (rootNode == null) {
			rootNode.setDate(valueToInsert);
		} else {
			insert_(rootNode, valueToInsert);
		}
	}

	private void insert_(Node node, LocalDate date) {
		// not considering duplicates
		if (date.compareTo(node.getDate()) < 0) {
			if (node.getLeftChild() == null) {
				node.setLeftChild(new Node(date));
			} else {
				insert_(node.getLeftChild(), date);
			}
		} else if (date.compareTo(node.getDate()) > 0) {
			if (node.getRightChild() == null) {
				node.setRightChild(new Node(date));
			} else {
				insert_(node.getRightChild(), date);
			}
		}
		
	}
	
	@Override
	public void delete(LocalDate valueToDelete) {
		// TODO Auto-generated method stub

	}

	@Override
	public Node find(LocalDate valueToFind) {
		// TODO Auto-generated method stub
		return null;
	}

	public Node getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}
	
	public String toString() {
		return toString(rootNode);
	}
	
	private String toString(Node nodeToString) {
		if (nodeToString == null) {
			return "";
		} else {
			return toString(rootNode.getLeftChild()) + ", " + rootNode.getDate() + ", "
					+ toString(rootNode.getRightChild());
		}
	}

}
