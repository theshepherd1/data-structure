package bp;

public class Stack extends UnsortedList implements IStack {
	public static final int MAX_SIZE = 5;
	private Data[] dataItems = new Data[MAX_SIZE];
	private int sizeOfList;
	

	public boolean isFull() {
		if(MAX_SIZE == getSize()) {
			return true;
		}
		return false;
	}

	public int getSize() {
		return sizeOfList;
	}

	public int getCapacity() {
		return MAX_SIZE;
	}

	
	public void clear() {
		// should we reinit the array here?
		sizeOfList = 0;
	}

	
	public void push(Data dataItem) {
		if(sizeOfList < MAX_SIZE) {
			dataItems[sizeOfList] = dataItem;
			sizeOfList++;
		}
	}

	
	public Data pop() {
		if(sizeOfList > 0) {
			sizeOfList--;
			return dataItems[sizeOfList];
		}
		return null;
	}

	
	public Data peek() {
		if(sizeOfList > 0) {
			return dataItems[sizeOfList-1];
		}
		return null;
	}

}
