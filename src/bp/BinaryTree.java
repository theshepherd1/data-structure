package bp;

import java.time.LocalDate;

public class BinaryTree implements IBinaryTree {

	private Node rootNode;
	
	@Override
	public LocalDate showMinimumValue() {
		if (rootNode == null) {
			return LocalDate.of(0001, 1, 1);
		} else {
			LocalDate minimumValue = rootNode.getDate();
			Node currentNode = rootNode;
			while (rootNode.getLeftChild() != null) {
				currentNode = currentNode.getLeftChild();
			}
			return currentNode.getDate();
		}
	}

	@Override
	public LocalDate showMaximumValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		return rootNode == null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(LocalDate valueToInsert) {
		// TODO Auto-generated method stub

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

}
