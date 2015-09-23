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
		if(isEmpty()) {
			last = pFirst;
		}
		first = pFirst;
		first.setPrevious(null);
	}

	public Link getLast() {
		return last;
	}

	public void setLast(Link pLast) {
		if(isEmpty()) {
			first = pLast;
		}
		last = pLast;
		last.setNext(null);
	}

	public void insertLeft(Link linkToInsert) {
		if(first != null) {
			linkToInsert.setNext(first);
			first.setPrevious(linkToInsert);
		}
		setFirst(linkToInsert);
	}

	public void insertLeft(Data dataToInsert) {
		Link linkToInsert = new Link();
		linkToInsert.setData(dataToInsert);
		insertLeft(linkToInsert);
	}

	public void insertRight(Link linkToInsert) {
		if(last != null) {
			linkToInsert.setPrevious(last);
			last.setNext(linkToInsert);
		}
		setLast(linkToInsert);
	}

	public void insertRight(Data dataToInsert) {
		Link linkToInsert = new Link();
		linkToInsert.setData(dataToInsert);
		insertRight(linkToInsert);
	}
	
	public Data removeLeft() {
		if(!isEmpty() && first != last) {
			Data removedData = first.getData();
			setFirst(first.getNext());
			return removedData;
		} else if (first == last) {
			clear();
		}
		return null;
	}

	public Data removeRight() {
		if(!isEmpty() && last != first) {
			Data removedData = last.getData();
			setLast(last.getPrevious());
			return removedData;
		} else if (last == first) {
			clear();
		}
		return null;
	}
	/*
	 * Stack will push/pop from right.
	 * Queue will start from left and end on right. 
	 */
	
	//push from left. so insert left
	public void push(Link link) {
		insertRight(link);
	}
	
	public Link pop() {
		Link link = new Link();
		link.setData(removeRight());
		return link;
	}
	
	public void enqueue(Link link) {
		insertLeft(link);
	}
	
	public Link dequeue() {
		Link link = new Link();
		link.setData(removeRight());
		return link;
	}
	
	public String toString() {
		String s = "[";
		Link link = first;
		if (link != null) {
			while(link.getNext() != null) {
				s += link.getData().toString();
				link = link.getNext();
			}
			s += link.getData().toString();
		}
		s += "]";
		return s;
	}

}
