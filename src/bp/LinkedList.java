package bp;

public class LinkedList implements ILinkedList {
	private Link first;
	private Link last;
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return first == null;
	}

	public void clear() {
		// TODO Auto-generated method stub
		first = last = null;
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Link getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFirst(Link pFirst) {
		// TODO Auto-generated method stub

	}

	public Link getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setLast(Link pLast) {
		// TODO Auto-generated method stub

	}

	public void insertLeft(Link linkToInsert) {
		// TODO Auto-generated method stub

	}

	public void insertLeft(Data dataToInsert) {
		Link linkToInsert = new Link();
		linkToInsert.setData(dataToInsert);
		insertLeft(linkToInsert);
	}

	public void insertRight(Link linkToInsert) {
		// TODO Auto-generated method stub

	}

	public void insertRight(Data dataToInsert) {
		// TODO Auto-generated method stub

	}

	public Data removeLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	public Data removeRight() {
		// TODO Auto-generated method stub
		return null;
	}

}
