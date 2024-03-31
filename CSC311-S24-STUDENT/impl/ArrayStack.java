

package com.usman.csudh.csc311.adt.impl;

import com.usman.csudh.csc311.adt.Stack;
import com.usman.csudh.csc311.adt.StackEmptyException;
/**
 * This class represents a stack implemented using an array.
 * 
 * The stack dynamically resizes its underlying array to accommodate more elements
 * as needed.
 * 
 * @param <T> the type of elements stored in the stack
 * @since 2024-03-08
 */
public class ArrayStack<T> implements Stack<T> {
    private static final int DEFAULT_CAPACITY = 50;
    private static final int GROW_BY = 2;

    private T[] data;
    private int stackPointer = 0;

    /**
     * Constructs a stack with the default initial capacity.
     */
    public ArrayStack() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Constructs a stack with the specified initial capacity.
     * 
     * @param size the initial capacity of the stack
     */
    public ArrayStack(int size) {
        data = (T[]) new Object[size];
    }

    /**
     * Pushes an item onto the top of this stack.
     * 
     * @param item the item to be pushed onto this stack
     */
    public void push(T item) {
        if (stackPointer == data.length) {
            resizeArray();
        }
        data[stackPointer++] = item;
    }

    /**
     * Removes the object at the top of this stack and returns that object.
     * 
     * @return the item removed from the top of the stack
     * @throws StackEmptyException if the stack is empty
     */
    public T pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }
        return data[--stackPointer];
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     * 
     * @return the item at the top of the stack
     * @throws StackEmptyException if the stack is empty
     */
    public T peek() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }
        return data[stackPointer - 1];
    }

    /**
     * Returns the number of elements in the stack.
     * 
     * @return the number of elements in the stack
     */
    public int size() {
        return stackPointer;
    }

    /**
     * Tests if this stack is empty.
     * 
     * @return true if and only if this stack contains no items; false otherwise
     */
    public boolean isEmpty() {
        return stackPointer == 0;
    }

    /**
     * Removes all of the elements from this stack. The stack will be empty after this call returns.
     */
    public void clear() {
        stackPointer = 0;
    }

    private void resizeArray() {
        int newCapacity = data.length * GROW_BY;
        T[] newData = (T[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = stackPointer - 1; i >= 0; i--) {
            result.append(data[i]).append("\n");
        }
        return result.toString();
    }
}
