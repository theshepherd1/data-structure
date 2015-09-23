package ui;

import java.lang.reflect.Array;

import bp.Data;
import bp.Queue;
import bp.Stack;
import bp.Link;
import bp.LinkedList;

//import bp.Data;

public class Main {

	public static void main(String[] args) {
		Link [] links =  new Link[5];
		LinkedList myLL = new LinkedList();
		
		//*************empty list right now
		System.out.println(myLL.getSize());
		System.out.println(myLL.getFirst());
		System.out.println(myLL.toString());
		
		//************filled list
		Data data1 = new Data(1,1);
		Data data2 = new Data(2,2);
		Data data3 = new Data(3,3);
		Data data4 = new Data(4,4);
		Data data5 = new Data(5,5);

		
		Link link1 = new Link();
		Link link2 = new Link();
		Link link3 = new Link();
		Link link4 = new Link();
		Link link5 = new Link();

		
		link1.setData(data1);
		link2.setData(data2);
		link3.setData(data3);
		link4.setData(data4);
		link5.setData(data5);
		
		myLL.setFirst(link1);
		myLL.setLast(link5);
		
		link1.setNext(link2);
		link2.setNext(link3);
		link3.setNext(link4);
		link4.setNext(link5);
		
		link2.setPrevious(link1);
		link3.setPrevious(link2);
		link4.setPrevious(link3);
		link5.setPrevious(link4);

		System.out.println(myLL.getSize());
		
		System.out.println(myLL.getFirst().getData());
		
		System.out.println(myLL.toString());
		
		System.out.println(myLL.isEmpty());
		
		myLL.insertLeft(data3);
		myLL.insertRight(data3);
		
		System.out.println(myLL.toString());
		System.out.println(myLL.getFirst().getData().toString());
		System.out.println(myLL.getLast().getData().toString());

		//*************empty list
		
		myLL.clear();
		
		System.out.println(myLL.isEmpty());
		
		myLL.removeLeft();
		myLL.removeRight();
		
		System.out.println(myLL.toString());
	
		myLL.insertLeft(data3);
		myLL.insertRight(data5);
		myLL.insertLeft(data1);
		
		System.out.println(myLL.getSize());

		
		System.out.println(myLL.toString());
		
		System.out.println(myLL.removeRight());
		System.out.println(myLL.removeLeft());

		System.out.println(myLL.getSize());

		System.out.println(myLL.toString());
		
		System.out.println(myLL.getFirst().getData().toString());
		System.out.println(myLL.getLast().getData().toString());

		System.out.println(myLL.getFirst()==myLL.getLast());
		
		myLL.removeLeft();
		myLL.removeRight();
		
		
		System.out.println(myLL.toString());
		
		myLL.removeLeft();
		myLL.removeRight();

	}
}
