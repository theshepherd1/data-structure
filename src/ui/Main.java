
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

