package ui;

import bp.UnsortedList;

public class Main {

    public static void main(String[] args) {
        UnsortedList ul = new UnsortedList();
        
        //allowing dups
        ul.setDuplicatesAllowed(true);
        ul.initializeWithRandomData(100);
        System.out.println(ul);
//        ul.insert(10);
//        ul.insert(10);
//        System.out.println(ul);
//        ul.deleteAll(10);
//        System.out.println(ul);
//        ul.clear();
//        System.out.println(ul);
//        ul.delete(5);
//        System.out.println(ul);
//        
//        //No dups allowed
//        ul.setDuplicatesAllowed(false);
//        ul.initializeWithRandomData(10);
//        System.out.println(ul);
//        ul.insert(5);
//        System.out.println(ul);
//        ul.delete(5);
//        System.out.println(ul);
//        ul.deleteAll(6);
//        System.out.println(ul);
//        ul.insert(5);
        
//        ul.bubbleSort();
//        System.out.println(ul);
//        
//        System.out.println(ul.getSizeOfList());
        
        System.out.println(ul.find(10));
        for (int index : ul.findAll(10)) {
        	if (index != 0) {
        		System.out.println(index);
        		}
        }
        
        System.out.println(ul);

        System.out.println(ul.getSizeOfList());
        System.out.println(ul);
        ul.deleteAll(1);
        System.out.println(ul.getSizeOfList());
        
        ul.insert(1);
        System.out.println(ul.getSizeOfList());

        ul.delete(1);
        System.out.println(ul.getSizeOfList());


    }

}