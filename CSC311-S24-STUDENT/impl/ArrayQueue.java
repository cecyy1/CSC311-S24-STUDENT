package com.usman.csudh.csc311.adt.impl;

import com.usman.csudh.csc311.adt.Queue;
import com.usman.csudh.csc311.adt.QueueEmptyException;
/**
 * This class represents a queue implemented using an array.
 * 
 * The queue dynamically resizes its underlying array to accommodate more elements
 * as needed.
 * 
 * @param <T> the type of elements stored in the queue
 * @since 2024-03-08
 */
public class ArrayQueue<T> implements Queue<T> {
    private static final int INITIAL_CAPACITY = 50;
    private static final int GROW_BY = 25;

    private T[] data;
    private int front;
    private int rear;
    private int size;

    /**
     * Constructs a queue with the default initial capacity.
     */
    public ArrayQueue() {
        data = (T[]) new Object[INITIAL_CAPACITY];
        front = 0;
        rear = -1; // Initially, there are no elements in the queue
        size = 0;
    }

    /**
     * Constructs a queue with the specified initial capacity.
     * 
     * @param initialCapacity the initial capacity of the queue
     */
    public ArrayQueue(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        data = (T[]) new Object[initialCapacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    /**
     * Adds an item to the end of the queue.
     * 
     * @param item the item to add
     */
    public void add(T item) {
        if (size == data.length) {
            resizeArray();
        }
        rear = (rear + 1) % data.length;
        data[rear] = item;
        size++;
    }

    /**
     * Removes and returns the item at the front of the queue.
     * 
     * @return the item removed from the queue
     * @throws QueueEmptyException if the queue is empty
     */
    public T remove() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue is empty");
        }
        T removedItem = data[front];
        front = (front + 1) % data.length;
        size--;
        return removedItem;
    }

    private void resizeArray() {
        T[] newData = (T[]) new Object[data.length + GROW_BY];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        rear = size - 1;
    }

    /**
     * Retrieves, but does not remove, the item at the front of the queue.
     * 
     * @return the item at the front of the queue
     * @throws QueueEmptyException if the queue is empty
     */
    public T peek() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue is empty");
        }
        return data[front];
    }

    /**
     * Returns the number of elements in the queue.
     * 
     * @return the number of elements in the queue
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the queue is empty.
     * 
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Clears the queue, removing all elements.
     */
    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
    }
}