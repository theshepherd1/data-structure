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
import bp.Hash;
import bp.Heap;


//import bp.Data;

public class Main {

	public static void main(String[] args) {

		Heap h = new Heap();
		
		LocalDate[] dates = new LocalDate[10];
		for (int i = 1; i < 11; i ++) {
			dates[i-1] = LocalDate.of(2000 + -(2*i)^2, 2, 3);
		}
		
		for (LocalDate date : dates) {
			h.insert(date);
		}
		System.out.println("Date3" + dates[3].toString());

		System.out.println(h.toString());
		
		h.delete();
		
		System.out.println("Deleted first" + h.toString());
		
		h.delete(dates[3]);
		
		System.out.println("Deleted Date3" + h.toString());


	}
}
