package bp;

public class Stack implements IStack {
	public static final int MAX_SIZE = 1000;
	private Data[] dataItems = new Data[MAX_SIZE];
	private int sizeOfList;
	

	@Override
	public boolean isFull() {
		if(MAX_SIZE == getSize()) {
			return true;
		}
		return false;
	}

	@Override
	public int getSize() {
		return sizeOfList;
	}

	@Override
	public int getCapacity() {
		return MAX_SIZE;
	}

	@Override
	public void clear() {
		// should we reinit the array here?
		sizeOfList = 0;
	}

	@Override
	public void push(Data dataItem) {
		if(sizeOfList < MAX_SIZE) {
			dataItems[sizeOfList] = dataItem;
			sizeOfList++;
		}
	}

	@Override
	public Data pop() {
		if(sizeOfList > 0) {
			sizeOfList--;
			return dataItems[sizeOfList];
		}
		return null;
	}

	@Override
	public Data peek() {
		if(sizeOfList > 0) {
			return dataItems[sizeOfList-1];
		}
		return null;
	}

}
