/**
 * This class represents a list of integers. The underlying data structure is an array. 
 * Array is a fixed size data structure, where is the List is supposed to be flexible. Therefore, to create 
 * flexible list, the array is created with a fixed size and when the array is full, a new array is created  
 * with higher capacity and the data is copied to the new array.
 * 
 * The creation of new array and copying of data is an expensive operation will impact on the performance
 * of the list and its Big O notation.
 * 
 * @author Usman Aslam
 * @version 1.0
 * @since 2024-03-08
 * 
 */

package com.usman.csudh.csc311.adt.impl;

import com.usman.csudh.csc311.adt.List;
import com.usman.csudh.csc311.adt.ListInvalidIndexException;

/**
 * This class represents a list that dynamically resizes its underlying array
 * to accommodate more elements as needed.
 * 
 * The resizing strategy used here is to double the array's capacity whenever
 * it becomes full, reducing the frequency of resizing operations and improving
 * performance.
 * 
 * This implementation supports storing elements of any type.
 * 
 * @param <T> the type of elements stored in the list
 * @since 2024-03-08
 */
public class ArrayList<T> implements List<T> {

    /**
     * The initial capacity of the list.
     */
    private static final int INITIAL_CAPACITY = 50;

    /**
     * The factor by which the array is resized when it becomes full.
     */
    private static final int RESIZE_FACTOR = 2;

    /**
     * The underlying array to hold the data.
     */
    private Object[] data;

    /**
     * The pointer variable to keep track of the current position of the array.
     */
    private int arrayPointer = 0;

    /**
     * Constructs an ArrayList with the initial capacity.
     */
    public ArrayList() {
        data = new Object[INITIAL_CAPACITY];
    }

    /**
     * Constructs an ArrayList with the specified size.
     * 
     * @param size the initial size of the list
     */
    public ArrayList(int size) {
        data = new Object[size];
    }

    /**
     * Adds an item to the end of the list. If the underlying array is full, it is
     * resized to accommodate more elements.
     * 
     * @param item the value to add to the list
     */
    public void add(T item) {
        if (arrayPointer == data.length) {
            resizeArray();
        }
        data[arrayPointer++] = item;
    }

    /**
     * Adds an array of items to the end of the list. If the underlying array is
     * full, it is resized to accommodate more elements.
     * 
     * @param items the array to add to the list
     */
    public void add(T[] items) {
        for (T item : items) {
            add(item);
        }
    }

    /**
     * Replaces the value at the specified index with the given item.
     * 
     * @param index the index of the value to replace
     * @param item  the new value to set
     * @throws ListInvalidIndexException if the index is out of bounds
     */
    public void put(int index, T item) throws ListInvalidIndexException {
        if (index >= arrayPointer || index < 0) {
            throwInvalidIndexException();
        }
        data[index] = item;
    }

    /**
     * Returns the size of the list.
     * 
     * @return the size of the list
     */
    public int size() {
        return arrayPointer;
    }

    /**
     * Checks whether the list is empty.
     * 
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return arrayPointer == 0;
    }

    /**
     * Clears the list by resetting the array pointer and creating a new array with
     * the initial capacity.
     */
    public void clear() {
        arrayPointer = 0;
        data = new Object[INITIAL_CAPACITY];
    }

    /**
     * Inserts the given value at the specified index. If the array is full, it is
     * resized to accommodate more elements.
     * 
     * @param index the index at which to insert the value
     * @param item  the value to insert
     * @throws ListInvalidIndexException if the index is out of bounds
     */
    public void insert(int index, T item) throws ListInvalidIndexException {
        if (index > arrayPointer || index < 0) {
            throwInvalidIndexException();
        }

        if (arrayPointer == data.length) {
            resizeArray();
        }

        System.arraycopy(data, index, data, index + 1, arrayPointer - index);
        data[index] = item;
        arrayPointer++;
    }

    /**
     * Retrieves the value at the specified index.
     * 
     * @param index the index of the value to retrieve
     * @return the value at the specified index
     * @throws ListInvalidIndexException if the index is out of bounds
     */
    public T get(int index) throws ListInvalidIndexException {
        if (index >= arrayPointer || index < 0) {
            throwInvalidIndexException();
        }
        return (T) data[index];
    }

    /**
     * Removes the value at the specified index from the list.
     * 
     * @param index the index of the value to remove
     * @return the value that was removed
     * @throws ListInvalidIndexException if the index is out of bounds
     */
    public T remove(int index) throws ListInvalidIndexException {
        if (index >= arrayPointer || index < 0) {
            throwInvalidIndexException();
        }

        T removedItem = (T) data[index];
        System.arraycopy(data, index + 1, data, index, arrayPointer - index - 1);
        arrayPointer--;
        return removedItem;
    }

    /**
     * Returns a string representation of the list.
     * 
     * @return a string representation of the list
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arrayPointer; i++) {
            result.append(data[i]).append(" ");
        }
        return result.toString();
    }

    /**
     * Resizes the underlying array by creating a new array with double the
     * capacity and copying the data to the new array.
     */
    private void resizeArray() {
        Object[] newData = new Object[data.length * RESIZE_FACTOR];
        System.arraycopy(data, 0, newData, 0, arrayPointer);
        data = newData;
    }

    /**
     * Throws a ListInvalidIndexException with the message "Invalid index".
     * 
     * @throws ListInvalidIndexException always
     */
    private void throwInvalidIndexException() throws ListInvalidIndexException {
        throw new ListInvalidIndexException("Invalid index");
    }
    