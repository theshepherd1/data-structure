package bp;

public class SortedList extends UnsortedList {	
	public final void insert(final int pValueToInsert) {
		
		int i = 0;
		// if dups or dups allowed
		if (sizeOfList == 0) {
			sizeOfList++;
			listItems[0] = pValueToInsert;
		} else if ((find(pValueToInsert) > -1 && duplicatesAllowed)) {
			// do nothing
		} else if (sizeOfList > MAX_SIZE) { // if 
			// do nothing
		} else {
			while (pValueToInsert > listItems[i] && i < sizeOfList) {
				i++;
			}
			
			sizeOfList++;
			
			for (int j = sizeOfList; j > i; j--) {
				listItems[j] = listItems[j-1];
			}
			
			listItems[i] = pValueToInsert;
		}
	}
	
	public void delete(final int pValueToDelete) {
		//delete code here
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
}
