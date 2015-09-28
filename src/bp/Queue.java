package bp;

public class Queue extends UnsortedList implements IQueue {
	public static final int MAX_SIZE = 1000;
	private Data[] dataItems = new Data[MAX_SIZE];
	private int sizeOfList;
	private boolean isPriorityQueue = false;

	
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

	
	public boolean isPriorityQueue() {
		return isPriorityQueue;
	}

	
	public void setPriorityQueue(boolean pIsPriorityQueue) {
		isPriorityQueue = pIsPriorityQueue;
	}

	
	public void clear() {
		sizeOfList = 0;
	}

	
	public void enqueue(Data dataItem) {
		if(sizeOfList == 0) {
			sizeOfList++;
			dataItems[sizeOfList-1] = dataItem;
		} else if(sizeOfList < MAX_SIZE && isPriorityQueue == false) {
			sizeOfList++;
			for (int i = sizeOfList-1; i > 0; i--) {
				dataItems[i] = dataItems[i-1];
				}
			dataItems[0] = dataItem;
		} else if(sizeOfList < MAX_SIZE && isPriorityQueue == true) {
			sizeOfList++;
			int i = 0;
			while(i < sizeOfList-1 && dataItem.getPriority() < dataItems[i].getPriority()) {
				i++;
			}
			for(int n = sizeOfList-1; n > i; n--) {
				dataItems[n] = dataItems[n-1];
			}
			dataItems[i] = dataItem;
		}
	}

	
	public Data dequeue() {
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
	
	public String toString() {
		String temp = isPriorityQueue ? "Priority Queue: [" : "Normal Queue: [";
		for(int i = 0; i < sizeOfList - 1; i++) {
			temp = temp + dataItems[i] + ", ";
		}
		temp = temp + (sizeOfList > 0 ? dataItems[sizeOfList-1] : ""); 
		temp = temp + "]";
		
		return temp;
	}
}
