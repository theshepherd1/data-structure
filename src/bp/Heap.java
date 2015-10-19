package bp;

import java.time.LocalDate;

public class Heap implements IHeap  {
	//Max Heap - first is the biggest
	
	private Link first;
	private Link last;
	int size = 0;
	
	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void clear() {
		first = last = null;
	}

	@Override
	public void insert(LocalDate valueToInsert) {
		if (first == null) {
			first = new Link();
			first.setDate(valueToInsert);
			last = first;
		} else {
			pInsert(first, valueToInsert);
		}
	}
	
	private void pInsert(Link left, LocalDate valueToInert) {
		if (left.getNext() == null) {
			Link link = new Link();
			link.setDate(valueToInert);
			left.setNext(link);
			link.setPrevious(left);
			validate(link);
			last = left.getNext();
		} else {
			pInsert(left.getNext(), valueToInert);
		}
	}
	
	private void validate(Link link) {
		if (link.getPrevious() != null) {
			if (isBiggerThanPrev(link.getPrevious(), link)) {
				swapValue(link, link.getPrevious());
				validate(link.getPrevious());
			}
		}
	}

	private boolean isBiggerThanPrev(Link prev, Link next) {
		if (next.getDate().compareTo(prev.getDate()) > 0) {
			return true;
		} else return false;
	}
	
	private void swapValue(Link linkOne, Link linkTwo) {
		LocalDate temp = linkOne.getDate();
		linkOne.setDate(linkTwo.getDate());
		linkTwo.setDate(temp);
	}
	
	public void delete() {
		first.getNext().setPrevious(null);
		first = first.getNext();
	}
	
	@Override
	public void delete(LocalDate valueToDelete) {
		Link link = first;
		if (link.getDate().compareTo(valueToDelete) == 0) {
			delete();
		} else {
			while (link != null && link.getNext() != null) {
				if (link.getDate().compareTo(valueToDelete) == 0) {
					link.getPrevious().setNext(link.getNext());
					link.getNext().setPrevious(link.getPrevious());
					link.setPrevious(null);
					link.setNext(null);
				} else {
					link = link.getNext();
				}
			}
		}
	}
	
	public String toString() {
		String s = "[";
		Link link = first;
		if (link != null) {
			while(link.getNext() != null) {
				s = s + link.getDate().toString() + ", ";
				link = link.getNext();
			}
			s += link.getDate().toString();
		}
		s += "]";
		return s;
	}
}
