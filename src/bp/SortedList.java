package bp;

public class SortedList extends UnsortedList {
	
	private int sizeOfList;
	private int[] listItems = new int[MAX_SIZE];
	
	public final void insert(final int pValueToInsert) {
		
		int i = 0;
		if (pValueToInsert == listItems[i] && !super.duplicatesAllowed) {
			// do nothing
		} else {
			while(pValueToInsert > listItems[i] && i < sizeOfList) {
				i++;
			}
			
		}
		
		// find where to insert into
		// make sure not dup if not allowed
		// push certain elements
		//add value
	}
	
	public void delete(final int pValueToDelete) {
		//delete code here
	}
	
	public final int find(final int pValueToFind) {
		
		
		return -10;		
	}
}
