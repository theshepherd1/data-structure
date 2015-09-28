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
		Node node = find(valueToDelete);
		Node parentNode = node.getParent();
		boolean isRight  = false;
		
		// determine which side it's on
		if (node.getDate().compareTo(parentNode.getDate()) > 0) {
			isRight = true;
		} else {
			isRight = false;
		}
		
		// node deleting has no child
		if (node.getLeftChild() == null && node.getRightChild() == null) {
			if (isRight) {
				parentNode.setRightChild(null);
			} else {
				parentNode.setLeftChild(null);
			}
			node.setParent(null);
			node = null;
		} else if (node.getLeftChild() == null) {
			parentNode.setLeftChild(node.getLeftChild());
			node.setParent(null);
			node = null;
		} else if (node.getRightChild() == null) {
			
		} else {
			
		}
		// node deleting has one child : replace it with its child
		
		
		//node deleting has two children: replace it with the leftest child of its right child, then make its left child the new left child of the new node
		
	}

	
	// can use recursion?
	@Override
	public Node find(LocalDate valueToFind) {
		Node current = rootNode;
		while (current.getDate().compareTo(valueToFind) != 0) {
			if (valueToFind.compareTo(current.getDate()) < 0) {
				if (current.getLeftChild() == null) {
					return null;
				} else {
					current = current.getLeftChild();
				}
			} else if (valueToFind.compareTo(current.getDate()) > 0) {
				if (current.getRightChild() == null) {
					return null;
				} else {
					current = current.getRightChild();
				}
			} else {
				return current;
			}
		}
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
