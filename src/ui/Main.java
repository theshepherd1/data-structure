package ui;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Data myData = new Data(5,2);
		System.out.println(myData);
		Stack myStack = new Stack();
		myStack.push(myData);
		System.out.println(myStack);
		
	}

}
