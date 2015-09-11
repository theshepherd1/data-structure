package ui;

import bp.SortedList;

public class Main {

public static void main(String[] args) {
	SortedList sl = new SortedList();
	
	sl.insert(5);
	sl.insert(64);
	sl.insert(7);
	sl.insert(1);
	
	sl.setDuplicatesAllowed(false);
	sl.initializeWithRandomData(10);
	
	System.out.println(sl.getSizeOfList());
	System.out.println(sl.toString());
	
	System.out.println(sl.find(4));
}

}

