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

	// Find index of array element
	public int indexOf(T t) { 
		for (int i = 0; i < size; i++) {
			if (array[i] != null && array[i].equals(t)) { // check element(i) is not null and avoid exception:
															// "NullPointerException"
				return i; // result if true
			}
		}
		return -1; // result if false
	}

	// Method just may show array size
	public int size() { 
		return size;
	}

	public boolean isEmpty() {
		return size == 0; // true if size = 0 (array is empty) and false if array is not empty
		}

	// Does your MyArrayList contain the specified object o?
	public boolean contains(Object o) {
		for (int i = 0; i<size; i++) { // if object o = element with index '1', return true
											// if o != element with index '1' , return false
			if (o == null) {			// we checking if object o = null
				if (array[i] == null) {
					return true;
				}
			} else if (o.equals(array[i])) {
					return true;
				}
			}
			return false;
		}
		


	
	// Delete 
	public boolean remove(T t) {
		
	}

	
	
//	public boolean remove(T t) {
//	    for (int i = 0; i < size; i++) {
//	        if (t == null) {
//	            if (array[i] == null) {
//	                removeAt(i);
//	                return true;
//	            }
//	        } else if (t.equals(array[i])) {
//	            removeAt(i);
//	            return true;
//	        }
//	    }
//	    return false;
//	}

	
	
	
	
	
	
	
	
	
	
	
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
