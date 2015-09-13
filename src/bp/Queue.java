package bp;

public class Queue extends UnsortedList implements IQueue {
	public static final int MAX_SIZE = 1000;
	private Data[] dataItems = new Data[MAX_SIZE];
	private int sizeOfList;
	private boolean isPriorityQueue;

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
	public boolean isPriorityQueue() {
		return isPriorityQueue;
	}

	@Override
	public void setPriorityQueue(boolean pIsPriorityQueue) {
		isPriorityQueue = pIsPriorityQueue;
	}

	@Override
	public void clear() {
		sizeOfList = 0;
	}

	@Override
	public void enqueue(Data dataItem) {
		if(sizeOfList < MAX_SIZE) {
			sizeOfList++;
			for (int i = sizeOfList-1; i > 0; i--) {
				dataItems[i] = dataItems[i-1];
			}
			dataItems[0] = dataItem;
		}
	}

	@Override
	public Data dequeue() {
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
