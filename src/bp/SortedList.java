package bp;

public class SortedList extends UnsortedList {	
	
	public final void insert(final int pValueToInsert) {
		int i = 0;
		// if dups or dups allowed
		if (sizeOfList == 0) {
			sizeOfList++;
			listItems[0] = pValueToInsert;
		} else if ((find(pValueToInsert) > -1 && !duplicatesAllowed) || sizeOfList >= MAX_SIZE) {
			// do nothing
		} else {
			while (pValueToInsert > listItems[i] && i < sizeOfList) {
				i++;
			}
			sizeOfList++;
			for (int j = sizeOfList-1; j > i; j--) {
				listItems[j] = listItems[j-1];
			}
			listItems[i] = pValueToInsert;
		}
	}
	
	public void delete(final int pValueToDelete) {
		int n = find(pValueToDelete);
		
		if(n != -1 && sizeOfList > 0) {
			for(int i = n; i < sizeOfList - 1; i++) {
				listItems[i] = listItems[i+1];
			}
			sizeOfList--;
		}
	}
	
	public void deleteAll(int pValueToDelete) {
		while (sizeOfList > 0 && find(pValueToDelete) != -1) {
			delete(pValueToDelete);
		}
	}

	
	public final int find(final int pValueToFind) {
		int mid = ((int) Math.floor((sizeOfList) / 2));
		int low = 0;
		int high = sizeOfList;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (listItems[mid] == pValueToFind) {
				return mid;
			} else if (listItems[mid] < pValueToFind) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		return -1;
	}
	
	public int[] findAll(int pValueToFind) {
		int[] indexList = new int[MAX_SIZE];
		int i = 0;
		int index = find(pValueToFind);
		
		if (!this.duplicatesAllowed) {
			indexList[0] = index;
			return indexList;
		} else {
			indexList[i] = index;
			while (index < sizeOfList-1 && listItems[index+1] == pValueToFind) {
				i++;
				index++;
				indexList[i] = index;
			}
			index = find(pValueToFind);
			while (index > 0 && listItems[index-1] == pValueToFind) {
				i++;
				index--;
				indexList[i] = index;
			}
		}
		return indexList;
	}
}
