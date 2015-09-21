package bp;

public class LinkedList implements ILinkedList {
	private Link first;
	private Link last;
	
	public boolean isEmpty() {
		return first == null;
	}

	public void clear() {
		first = last = null;
	}

	public int getSize() {
		if (first != null) {
			int i = 1;
			Link link = first;
			while(link.getNext() != null) {
				link = link.getNext();
				i++;
			}
			return i;
		}
		return 0;
	}

	public Link getFirst() {
		return first;
	}

	public void setFirst(Link pFirst) {
		first = pFirst;
	}

	public Link getLast() {
		return last;
	}

	public void setLast(Link pLast) {
		last = pLast;
	}

	// should you make this method private, since you will call this in insertLeft(Data)?
	public void insertLeft(Link linkToInsert) {
		linkToInsert.setNext(first);
		first.setPrevious(linkToInsert);
		setFirst(linkToInsert);
	}

	public void insertLeft(Data dataToInsert) {
		Link linkToInsert = new Link();
		linkToInsert.setData(dataToInsert);
		insertLeft(linkToInsert);
	}

	public void insertRight(Link linkToInsert) {
		linkToInsert.setPrevious(last);
		last.setNext(linkToInsert);
		setLast(linkToInsert);
	}

	public void insertRight(Data dataToInsert) {
		Link linkToInsert = new Link();
		linkToInsert.setData(dataToInsert);
		insertRight(linkToInsert);
	}
	
	// does this mean remove the current first and set a new first?
	public Data removeLeft() {
		Data removedData = first.getData();
		
		setFirst(first.getNext());
		
		// will it return a reference or a copy of the object?
		return removedData;
	}

	public Data removeRight() {
		Data removedData = first.getData();
		
		setLast(first.getPrevious());
		
		return removedData;
	}

}
