/**
 * Title: Stack.java
 * Abstract: This program implements a stack using an array. 
 * It has push, pop, peek, size, and isEmpty methods.
 * he underlying data structure is an array. 
 * Array is a fixed size data structure, where is the List is supposed to be flexible. Therefore, to create 
 * flexible list, the array is created with a fixed size and when the array is full, a new array is created  
 * with higher capacity and the data is copied to the new array.
 * @author Usman Aslam
 * @version 1.0
 * @since 2024-03-08
 * 
 */

package com.usman.csudh.csc311.adt.impl;

import com.usman.csudh.csc311.adt.Stack;
import com.usman.csudh.csc311.adt.StackEmptyException;

public class ArrayStack implements Stack {
	/**
	 * The default capacity of the stack.
	 *
	 */
	private static final int DEFAULT_CAPACITY = 50;
	
	
	/**
	 * The underlying array will grow by this number when the it is full.
	 */
	private static final int GROW_BY = 25;
	
	
	/**
	 * The underlying array to hold the data.
	 */
	private int[] data;
	
	/**
	 * The pointer variable to keep track the current position of the array
	 */
	int stackPointer=0;
	
	/**
	 * The default constructor to create a stack with the initial capacity.
	 *
	 */
	public ArrayStack() {
		data= new int[DEFAULT_CAPACITY];
	}
	
	/**
	 * The constructor to create a stack with the given size.
	 * 
	 * @param size the size of the stack
	 *
	 */
	public ArrayStack(int size) {
		data = new int[size];
	}
	
	/**
	 * The method to add an item to the stack.
	 * 
	 * @param item the value to be added to the stack
	 *
	 */
	public void push(int item) {
		//check if the array is full and if so, resize it
		if (stackPointer == data.length) {
			resizeArray();
		}
		
		//add the item to the stack
		data[stackPointer++] = item;

	}
	
	/**
	 * The method to remove an item from the stack.
	 * @return the item removed from the stack
	 * @throws StackEmptyException if the stack is empty
	 */
	public int pop() throws StackEmptyException{
		//check if the stack is empty
		if (stackPointer == 0) {
			throw new StackEmptyException("Stack is empty");
		}
		
		//remove the item from the stack
		return data[--stackPointer];
	}
	
	/**
	 * The method to get the value at the top of the stack. It will not remove the
	 * value from the stack.
	 * 
	 * @return the value at the top of the stack
	 * @throws StackEmptyException if the stack is empty
	 */
	public int peek() throws StackEmptyException {
		//check if the stack is empty
		if (stackPointer == 0) {
			throw new StackEmptyException("Stack is empty");
		}
		return data[stackPointer-1];
	}
	
	/**
	 * The method returns the size of the stack.
	 * 
	 * @return the size of the stack
	 */
	public int size() {
		return stackPointer;
	}

	/**
	 * The method returns true if the stack is empty, otherwise it returns false.
	 * 
	 * @return true if the stack is empty, otherwise false
	 */
	public boolean isEmpty() {
		return stackPointer == 0;
	}
	
	/**
	 * The method to clear the stack.
	 *
	 */
	public void clear() {
		stackPointer = 0;
	}
	
	
	/**
	 * The method to resize the array when it is full.
	 *
	 */
	private void resizeArray() {
		int loopCount = 0;
		int[] newData = new int[data.length +GROW_BY];
		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
			loopCount++;
		}
		data = newData;
		System.out.println("Resize: "+loopCount);
	}
	
	/**
	 * This method returns String representation of the stack.
	 * 
	 * @return the value at the given index
	 */
	@Override
	public String toString() {
		String result = "";
		for (int i = stackPointer-1; i >= 0; i--) {
			result += data[i] + "\n";
		}
		return result;
	}

}
