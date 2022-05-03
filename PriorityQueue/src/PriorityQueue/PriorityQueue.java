package PriorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PriorityQueue<E extends Priority & Order & Comparable<E>> implements Queue<E> {

	private List<E> list;
	private int highestPriority = 10;
	private int order = 1;

	public PriorityQueue() {
		list = new ArrayList<>();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void enqueue(E element) {
		element.setOrder(order++);
		list.add(element);
		// if (element.getPriority() < highestPriority) {
		// 	highestPriority = element.getPriority();
		// }
		int index = list.indexOf(element);
		while (list.get(index).compareTo(list.get((index-1)/2)) < 0) {
			E temp = list.get((index-1)/2);
			list.set((index-1)/2, list.get(index));
			list.set(index, temp);
			index = (index-1)/2;
		}

	}

	public E dequeue() throws NoSuchElementException {

		if (list.isEmpty()) {
			return null;
		}

		E remElement = list.get(0);
		list.set(0, list.get(list.size()-1));
		list.remove(list.size()-1);

		try {

			int index = 0;

			while (list.get(index).compareTo(list.get(index*2+1)) > 0 || list.get(index).compareTo(list.get(index*2+2)) > 0) {

				if (list.size() <= index*2+2) {
					E temp = list.get(index);
					list.set(index, list.get(index*2+1));
					list.set(index*2+1, temp);
					index = index*2+1;
				}
				else if (list.get(index*2+2).compareTo(list.get(index*2+1)) < 0) {
					E temp = list.get(index);
					list.set(index, list.get(index*2+2));
					list.set(index*2+2, temp);
					index = index*2+2;
				}
				else {
					E temp = list.get(index);
					list.set(index, list.get(index*2+1));
					list.set(index*2+1, temp);
					index = index*2+1;
				}

			}

		}
		catch (Exception e) {}

		return remElement;

	}

	public E front() throws NoSuchElementException {
		return list.get(0);
	}

}
