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
		throw new RuntimeException("Not implemented");
	}

	public int indexOf(T t) {
		throw new RuntimeException("Not implemented");
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
