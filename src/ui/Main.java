<<<<<<< HEAD
package ui;

import bp.UnsortedList;

public class Main {

public static void main(String[] args) {
UnsortedList ul = new UnsortedList();

//allowing dups

ul.setDuplicatesAllowed(true);

//10 points
ul.initializeWithRandomData(5);
System.out.println("Should have five random elements with dups potentially:");
System.out.println(ul);

//10 points
ul.bubbleSort();
System.out.println("Should be sorted:");
System.out.println(ul);

//10 points
System.out.println("Should have removed the first '5' if applicable");
ul.delete(5);
System.out.println(ul);

//10 points
System.out.println("Should insert two 10s");
ul.insert(10);
ul.insert(10);
System.out.println(ul);

//10 points
System.out.println("Should delete all 10s");
ul.deleteAll(10);
System.out.println(ul);

//10 points
ul.clear();
System.out.println("Should be empty");
System.out.println(ul);

//10 points
System.out.println("Should still be empty -- tried to delete from an empty list");
ul.delete(5);
System.out.println(ul);

//No dups allowed

//10 points
ul = new UnsortedList();
ul.setDuplicatesAllowed(false);
ul.initializeWithRandomData(10);
System.out.println("Should have 10 random elements without dups");
System.out.println(ul);

//10 points
ul.insert(5);
System.out.println("Should silently refuse to insert a 5 (NOTE TO SELF: make sure MAX_SIZE = 10)"); 
System.out.println(ul);

//10 points
ul.delete(5);
System.out.println("Should remove the five if applicable");
System.out.println(ul);

//10 points
ul.deleteAll(6);
System.out.println("Should remove all sixes");
System.out.println(ul);

//10 points
ul.insert(5);
System.out.println("Should insert a five if room");
System.out.println(ul);

//10 points
ul.selectionSort();
System.out.println("Should be sorted");
System.out.println(ul);

}

}

=======
package ui;

import java.lang.reflect.Array;
import java.time.LocalDate;

import bp.BinaryTree;
import bp.Data;
import bp.Queue;
import bp.Stack;
import bp.Link;
import bp.LinkedList;
import bp.Node;

//import bp.Data;

public class Main {

	public static void main(String[] args) {
		BinaryTree n = new BinaryTree();
		
		LocalDate[] dates = new LocalDate[10];
		for (int i = 1; i < 11; i ++) {
			dates[i-1] = LocalDate.of(2000 + i * (-1)^i, 2, 3);
		}
		
		for (LocalDate date : dates) {
			System.out.println(date);
			n.insert(date);
		}
		
//		
		for (int i = 1; i < 11; i ++) {
//			System.out.println(dates[i-1]);
			System.out.println(n.find(dates[i-1]));
		}
		
		System.out.println(n.getSize());

		
		System.out.println(n.getMaxHeight(n.getRootNode()));
		
		n.delete(dates[3]);
		n.delete(dates[4]);
		n.delete(dates[4]);
		n.delete(dates[4]);
		n.delete(dates[4]);

		System.out.println(n.getSize());
//		System.out.println(n.toString());
		
	}
}
>>>>>>> origin/binary-tree
