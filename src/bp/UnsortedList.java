package bp;

import java.util.Arrays;

public class UnsortedList implements IUnsortedList {
	
	public static final int MAX_SIZE = 100;
	private int sizeOfList;
	private int[] listItems = new int[MAX_SIZE];
	private boolean duplicatesAllowed;
	
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
		
		if (find(pValueToInsert) > -1 && !duplicatesAllowed) {
			// don't insert
		} else {
			listItems[sizeOfList++] = pValueToInsert;
		}
	}

	@Override
	public void delete(int pValueToDelete) {
		//can we use 0's for the trailing spaces?
		
		int n = find(pValueToDelete);
		
		if(n >= 0) {
			for(int i = n; i < sizeOfList - 1; i++) {
				listItems[i] = listItems[i+1];
			}
			sizeOfList--;
		}
	}

	@Override
	public void deleteAll(int pValueToDelete) {
		for(int i = 0; i < sizeOfList; i++) {
			delete(pValueToDelete);
		}
	}

	@Override
	public void initializeWithRandomData(int pSizeOfList) {
		for (int n = 0; n < pSizeOfList; ++n) {
			insert(getRandomNumber(10));
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
		
		temp = temp + listItems[sizeOfList-1] + "]";
		
		return temp;
		
	}
	
	private int getRandomNumber(int pMaxValue) {
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
