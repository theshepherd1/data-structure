package ui;

import bp.SortedList;
import bp.UnsortedList;

public class Main {

public static void main(String[] args) {
	
	SortedList sl = new SortedList();
	sl.setDuplicatesAllowed(true);

	sl.insert(5);
	sl.insert(64);
	sl.insert(7);
	sl.insert(1);
	sl.insert(1);
	sl.insert(7);
	sl.insert(64);
	sl.insert(1);
	
	System.out.println(sl.getSizeOfList());
	
	sl.initializeWithRandomData(-1);
	
	System.out.println(sl.getSizeOfList());
	System.out.println(sl.toString());
	
	
	
	System.out.println(sl.find(-3));
	
	for (int index : sl.findAll(-3)) {
		System.out.print(index);
	}
	
	sl.delete(5);
	sl.deleteAll(-3);
	System.out.println(sl.toString());

}

}

