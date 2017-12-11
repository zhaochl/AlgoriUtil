package cn.timeplan.queue;

public class FixedSizeQueue<E> {

	private Object[] elements;
	private int capacity;
	private int head;
	private int tail;
	private int size;

	public FixedSizeQueue(int capacity) {
		if (capacity < 0)
			throw new IllegalArgumentException("Illegal Capacity: " + capacity);
		elements = new Object[capacity];
		this.capacity = capacity;
		head = 0;
		tail = (head - 1) % capacity;
		size = 0;
	}

	public boolean add(E e) {
		tail = (tail + 1) % capacity;
		elements[tail] = e;
		size = (size + 1) > capacity ? capacity : size + 1;
		head = (tail + 1 + capacity - size) % capacity;
		return true;
	}

	public E remove() {
		if (size == 0) {
			return null;
		}
		E element = (E) elements[head];
		head = (head + 1) % capacity;
		size--;
		return element;
	}

	public E element() {
		if (size == 0) {
			return null;
		}
		E element = (E) elements[head];
		return element;
	}

	public int size() {
		return size;
	}

	public boolean empty() {
		return size == 0;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (int i = 0, j = head; i < size; j = (j + 1) % capacity, i++) {
			if (i != 0) {
				sb.append(',');
			}
			sb.append(elements[j]);
		}

		sb.append(']');
		return sb.toString();

	}

	public static void main(String[] args) {

		FixedSizeQueue<Integer> queue = new FixedSizeQueue<Integer>(10);
		for (int i = 0; i < 35; i++) {
			queue.add(i);
		}
		System.out.println(queue);
		for (int i = 0; i < 5; i++) {
			System.out.println("remove " + queue.remove());
		}
		System.out.println(queue);
		for (int i = 0; i < 7; i++) {
			queue.add(i);
		}
		System.out.println(queue);
	}

}
