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
