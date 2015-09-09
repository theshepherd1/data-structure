package bp;

public class UnsortedList implements IUnsortedList {
	
	public static final int MAX_SIZE = 100;
	private int sizeOfList;
	private int[] listItems = new int[MAX_SIZE];
	protected boolean duplicatesAllowed;
	protected int ranUpperBound = 15;
	
	@Override
	public int getSizeOfList() {
		return this.sizeOfList;
	}

	@Override
	public boolean areDuplicatesAllowed() {
		return duplicatesAllowed;
	}

	@Override
	public void setDuplicatesAllowed(boolean pDuplicatesAllowed) {
		duplicatesAllowed = pDuplicatesAllowed;
	}

	@Override
	public void clear() {
		sizeOfList = 0;
	}

	@Override
	public void insert(int pValueToInsert) {
		
		if ((find(pValueToInsert) > -1 && !duplicatesAllowed) || sizeOfList == MAX_SIZE) {
			// don't insert
		} else {
			listItems[sizeOfList++] = pValueToInsert;
		}
	}

	@Override
	public void delete(int pValueToDelete) {
		int n = find(pValueToDelete);
		
		if(n != -1 && sizeOfList > 0) {
			for(int i = n; i < sizeOfList - 1; i++) {
				listItems[i] = listItems[i+1];
			}
			sizeOfList--;
		}
	}

	@Override
	public void deleteAll(int pValueToDelete) {
		while (sizeOfList > 0 && find(pValueToDelete) != -1) {
			delete(pValueToDelete);
		}
	}

	@Override
	public void initializeWithRandomData(int pSizeOfList) {
		int n = 0;
		if (pSizeOfList <= MAX_SIZE && pSizeOfList > 0) {
			while (n < pSizeOfList) {
				insert(getRandomNumber(ranUpperBound));
				n = sizeOfList;
			}
		} else {
			while (n < MAX_SIZE) {
				insert(getRandomNumber(ranUpperBound));
				n = sizeOfList;
			}
		}
	}

	@Override
	public int find(int pValueToFind) {
		for (int n = 0; n < sizeOfList; ++n) {
			if (listItems[n] == pValueToFind) {
				return n;
			}
		}
		return -1;
	}

	@Override
	public int[] findAll(int pValueToFind) {
		int[] indexList = new int[MAX_SIZE];
		int i = 0;
		for (int n = 0; n < sizeOfList; n++) {
			if (listItems[n] == pValueToFind) {
				indexList[i] = n;
				i++;
			} 
		}
		
		return indexList;
	}

	public String toString() {
		String temp = "[";
		for(int n = 0; n < sizeOfList-1; ++n) {
			temp = temp + listItems[n] + ", ";
		}
		
		if (sizeOfList > 0) {
				temp = temp + listItems[sizeOfList-1] + "]";
		} else {
			temp = temp + "]";
		}
		
		return temp;
		
	}
	
	protected int getRandomNumber(int pMaxValue) {
		return (int) (Math.random() * pMaxValue + 1);
	}
	
//	public void insertionSort() {
//		int min = listItems[0];
//		for(int i = 0; i < sizeOfList; i++) {
//			for(int j = 1; j < sizeOfList; j++) {
//				if(listItems[j] < min) {
//					min = listItems[j];
//					listItems[j] = listItems[i];
//					
//				}
//			}
//		}
//	}
	
	public void selectionSort() {
		int curIn = 0;
		int temp = listItems[curIn];
		for(int i = 0; i < sizeOfList; i++) {
			curIn = i;
			temp = listItems[i];
			for(int j = i; j < sizeOfList; j++) {
				if(listItems[j] < listItems[curIn]) {
					curIn = j;
				}
			}
			temp = listItems[i];
			listItems[i] = listItems[curIn];
			listItems[curIn] = temp;
		}
	}
	
	public void bubbleSort() {
		int temp = 0;
		for(int i = 0; i < sizeOfList; i++) {
			for(int j = 0; j < sizeOfList-1; j++) {
				if(listItems[j] > listItems[j+1]) {
					temp = listItems[j];
					listItems[j] = listItems[j+1];
					listItems[j+1] = temp;
				}
			}
		}
	}
	
}
