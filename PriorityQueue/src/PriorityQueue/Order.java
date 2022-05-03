package PriorityQueue;

public interface Order {
	
	/**
	 * Returns the order of the elemet
	 * @return int order
	 */
	public abstract int getOrder();

	/**
	 * Sets the order of the elemet
	 * @param order integer representation of the order.
	 */
	public abstract void setOrder(int order);

}
