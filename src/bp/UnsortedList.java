package bp;

import java.util.Arrays;

public class UnsortedList implements IUnsortedList {
	public static final int MAX_SIZE = 1000;
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
		listItems[sizeOfList++] = pValueToInsert;
	}

	@Override
	public void delete(int pValueToDelete) {
		
	}

	@Override
	public void deleteAll(int pValueToDelete) {
		
	}

	@Override
	public void initializeWithRandomData(int pSizeOfList) {
		
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
		return null;
	}

	public String toString() {
		String temp = "[";
		for(int n=0;n<sizeOfList;++n) {
			temp = temp + listItems[n] + ", ";
		}
		
		temp = temp + "]";
		
		return temp;
		
	}
	
}
