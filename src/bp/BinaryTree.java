package bp;

import interfaces.IBinaryTree;

import java.time.LocalDate;

public class BinaryTree implements IBinaryTree {

	private Node rootNode;
	int size = 0;
	
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
		return size;
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
			rootNode = new Node();
			rootNode.setDate(valueToInsert);
			size++;
		} else {
			insertMe(rootNode, valueToInsert);
			size++;
		}
	}

	private void insertMe(Node node, LocalDate date) {
		// not considering duplicates
		if (date.compareTo(node.getDate()) < 0) {
			if (node.getLeftChild() == null) {
				Node newNode = new Node();
				newNode.setDate(date);
				node.setLeftChild(newNode);
			} else {
				insertMe(node.getLeftChild(), date);
			}
		} else if (date.compareTo(node.getDate()) > 0) {
			if (node.getRightChild() == null) {
				Node newNode = new Node();
				newNode.setDate(date);
				node.setRightChild(newNode);
			} else {
				insertMe(node.getRightChild(), date);
			}
		}
	}
	
	@Override
	public void delete(LocalDate valueToDelete) {
		// node : node to be deleted
		Node node = find(valueToDelete);
		Node parentNode;
		boolean onRight  = false;

		parentNode = node.getParent() == null ? node.getParent() : null;
		
		if (node != null && parentNode != null) {
			// determine which side it's on
			if (node.getDate().compareTo(parentNode.getDate()) > 0) {
				onRight = true;
			} else {
				onRight = false;
			}
			
			// node deleting has no child
			// node deleting has one child : replace it with its child on either side
			//node deleting has two children: replace it with the leftest child of its right child, then make its left child the new left child of the new node	
			if (node.getLeftChild() == null && node.getRightChild() == null) {
				if (onRight && parentNode != null) {
					parentNode.setRightChild(null);
				} else if (!onRight && parentNode != null){
					parentNode.setLeftChild(null);
				}
				node.setParent(null);
				node = null;
			} else if (node.getLeftChild() == null) {
				if (onRight && parentNode != null) {
					parentNode.setRightChild(node.getRightChild());
				} else if (!onRight && parentNode != null){
					parentNode.setLeftChild(node.getRightChild());
				}
				node.setParent(null);
				node = null;
			} else if (node.getRightChild() == null) {
				if (onRight && parentNode != null) {
					parentNode.setRightChild(node.getLeftChild());
				} else if (!onRight && parentNode != null){
					parentNode.setLeftChild(node.getLeftChild());
				}
				node.setParent(null);
				node = null;
			} else {
				Node current = node.getRightChild();
				while (current.getLeftChild() != null) {
					current = current.getLeftChild();
				}
				// replace node to be deleted with current
				Node newNode = new Node();
				newNode.setDate(current.getDate());
				if (onRight) {
					node.getParent().setRightChild(newNode);
					delete(current.getDate());
					node.setParent(null);
					node = null;
				} else {
					node.getParent().setLeftChild(newNode);
					delete(current.getDate());
					node.setParent(null);
					node = null;
				}
			}
			size--;
		} else if (node != null && node.equals(rootNode)) {
			node.setParent(null);
			node = null;
		} else if (node.getLeftChild() == null) {
			if (onRight && parentNode != null) {
				setRootNode(node.getRightChild());
			} else if (!onRight && parentNode != null){
				setRootNode(node.getRightChild());
			}
			node.setParent(null);
			node = null;
		} else if (node.getRightChild() == null) {
			if (onRight && parentNode != null) {
				setRootNode(node.getLeftChild());
			} else if (!onRight && parentNode != null){
				setRootNode(node.getLeftChild());
			}
			node.setParent(null);
			node = null;
		} else {
			Node current = node.getRightChild();
			while (current.getLeftChild() != null) {
				current = current.getLeftChild();
			}
			// replace node to be deleted with current
			Node newNode = new Node();
			newNode.setDate(current.getDate());
			if (onRight) {
				setRootNode(newNode);
				delete(current.getDate());
				node.setParent(null);
				node = null;
			} else {
				setRootNode(newNode);
				delete(current.getDate());
				node.setParent(null);
				node = null;
			}
		}
		size--;
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
		if (current.getDate().compareTo(valueToFind) == 0) return current;
		else return null;
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
	
	public int getMaxHeight(Node node) {
		if (rootNode == null) return 0;
		else {
			int leftHeight = 0;
			int rightHeight = 0;
			if (node.getLeftChild() != null) {
				leftHeight = getMaxHeight(node.getLeftChild());
			}
			if (node.getRightChild() != null) {
				rightHeight = getMaxHeight(node.getRightChild());
			}
			return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
		}
	}
	
	private String toString(Node nodeToString) {
		if (nodeToString == null) {
			return null;
		} else {
			return toString(rootNode.getLeftChild()) + ", " + rootNode.getDate() + ", "
					+ toString(rootNode.getRightChild());
		}
	}

}
