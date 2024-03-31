package com.usman.csudh.csc311.adt.impl;

import com.usman.csudh.csc311.adt.Queue;
import com.usman.csudh.csc311.adt.QueueEmptyException;
public class ArrayQueue  implements Queue{
	/**
	 * The initial capacity of the list.
	 *
	 */

	static final int INITIAL_CAPACITY = 50;
	static final int QUEUE_HEAD=0;

	/**
	 * The underlying array will grow by this number when the it is full.
	 */

	static final int GROW_BY = 25;

	/**
	 * The underlying array to hold the data.
	 */
	private int[] data;

	/**
	 * The pointer variable to keep track the current position of the array
	 */
	int qPointer = 0;

	/**
	 * The default constructor to create a list with the initial capacity.
	 *
	 */
	public ArrayQueue() {
		data = new int[INITIAL_CAPACITY];
	}

	/**
	 * The constructor to create a list with the given size.
	 * 
	 * @param size the size of the list
	 *
	 */
	public ArrayQueue(int size) {
		data = new int[size];
	}
	
	public void add(int item) {
		if (qPointer == data.length) {
			resizeArray();
		}
		data[qPointer++] = item;

	}

	public int remove() throws QueueEmptyException {
		
		// Check if the index is valid
		if (qPointer==0) {
			throw new QueueEmptyException("Queue is empty");
		}
		int itemToReturn = data[QUEUE_HEAD];
		int loopCount = 0;

		// Move the values to the left to fill the space created by the deleted value
		for (int i = 0; i < qPointer; i++) {
			data[i] = data[i + 1];
			loopCount++;
		}
		// Decrement the array pointer because the value is deleted
		qPointer--;
		System.out.println("Delete: " + loopCount);
		return itemToReturn;
	}
	
	// Method resizes the array by creating a new array with higher capacity and
	// copying the data to the new array
	private void resizeArray() {
		int loopCount = 0;
		int[] newData = new int[data.length + GROW_BY];
		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
			loopCount++;
		}
		data = newData;
		System.out.println("Resize: " + loopCount);
	}

	@Override
	public int peek() throws QueueEmptyException {
		
		if (qPointer == 0) {
			throw new QueueEmptyException("Queue is empty");
		}
		return data[QUEUE_HEAD];
	}
	

	@Override
	public int size() {
		return qPointer;
	}

	@Override
	public boolean isEmpty() {
		return qPointer == 0;
	}

	@Override
	public void clear() {
		qPointer = 0;
		
	}

	

}
