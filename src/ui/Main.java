package ui;

import bp.Data;
import bp.Queue;
import bp.Stack;

//import bp.Data;

public class Main {

	public static void main(String[] args) {
		Data myData = new Data(5,2);
		System.out.println("value of data object: " + myData);
		
		//max cap for stacks
		Stack myStack = new Stack();
		System.out.println("Max Cap for stack:" + myStack.getCapacity());
		
		//push one data for stack
		myStack.push(myData);
		System.out.println("Peek stack after push data object" + myStack.peek());
		
		//peek one data for stack
		myStack.pop();
		System.out.println("Peek stack after pop" + myStack.peek());
		
		System.out.println();
		
		// push however many data for stack
		for(int i = -1; i < 5000; i++) {
			myData = new Data(i);
			myStack.push(myData);
		}
		System.out.println("Push 5 different data objects" + myStack.peek());
		
		//pop however many data for stack
		for(int i = 0; i< 3; i++) {
			myStack.pop();
		}
		
		//peek after manipulations for stack
		System.out.println("Peek stack after pop" + myStack.peek());

		Queue myQueue = new Queue();
		
		//queue one data for queue
		myQueue.enqueue(myData);
		System.out.println("Peek queue after enqueue" + myQueue.peek());
		
	}

}
