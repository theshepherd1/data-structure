package ui;

import bp.UnsortedList;

public class Main {

    public static void main(String[] args) {
        UnsortedList ul = new UnsortedList();

        //allowing dups
        ul.setDuplicatesAllowed(true);
        ul.initializeWithRandomData(5);
        System.out.println(ul);
        ul.insert(10);
        ul.insert(10);
        System.out.println(ul);
        ul.deleteAll(10);
        System.out.println(ul);
        ul.clear();
        System.out.println(ul);
        ul.delete(5);
        System.out.println(ul);
        
        //No dups allowed
        ul.setDuplicatesAllowed(false);
        ul.initializeWithRandomData(10);
        System.out.println(ul);
        ul.insert(5);
        System.out.println(ul);
        ul.delete(5);
        System.out.println(ul);
        ul.deleteAll(6);
        System.out.println(ul);
        ul.insert(5);
        System.out.println(ul);
    }

}