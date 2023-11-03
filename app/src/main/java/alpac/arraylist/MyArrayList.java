package alpac.arraylist;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<T> {

	private T[] array;
	private int capacity = 16;
	private int size = 0;

	public MyArrayList() {
		array = (T[]) new Object[capacity];
	}

	public void add(T t) {
		if (size == capacity) {
			increaseCapacity();
			increaseArray();
		}
		array[size] = t;
		size++;
	}

// TODO: read about "type erasure"
	@SuppressWarnings("unchecked")
	private void decreaseCapacity() {
		int newCapacity = capacity / 2;
		Object[] tempArray = new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			tempArray[i] = array[i];
		}

		T[] newArray = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), newCapacity);
		for (int i = 0; i < size; i++) {
			newArray[i] = (T) tempArray[i];
		}

		array = newArray;
		capacity = newCapacity;
	}

	private void increaseCapacity() {
		capacity = capacity << 1;
	}

	private void increaseArray() {
		T[] newArray = (T[]) new Object[capacity];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		array = newArray;
	}

	public T get(int i) {
		if (size < i + 1 || i < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return array[i];
	}

	public T remove(int index) {

		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("Index out of bounds"); // 1. check index in size[]
		}
		T removeElement = array[index]; // 2. save remove element in new array

		for (int i = index; i < size - 1; i++) { // 3. move element left, i deleted (remove) element
			array[i] = array[i + 1];
		}

		array[size - 1] = null; // 4. clear lust empty element after move elements (p.3)
		size--;

		if (size < capacity / 2) { // 5. if size < capacity more than, we change capacity (capacity/2)
			decreaseCapacity(); // 6. add method decreaseCapacity (string 27)
		}

		return removeElement;

	}

	public int indexOf(T t) { //Fiend index of array element 
		    for (int i = 0; i < size; i++) { 
		        if (array[i] != null && array[i].equals(t)) { // check element(i) is not null and avoid exception: "NullPointerException"
		            return i; // result if method true
		        }
		    }
		    return -1; // result if method false
		}

	
	
	

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		throw new RuntimeException("Not implemented");
	}

	public boolean contains(Object o) {
		throw new RuntimeException("Not implemented");
	}

	public boolean remove(T t) {
		throw new RuntimeException("Not implemented");
	}

	public boolean addAll(Collection c) {
		throw new RuntimeException("Not implemented");
	}

	public void clear() {
		throw new RuntimeException("Not implemented");
	}

	/**
	 * public boolean removeAll(Collection c) { return false; }
	 */

}
