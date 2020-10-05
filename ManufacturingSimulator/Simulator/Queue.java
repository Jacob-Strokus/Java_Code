import Blueprint.Order;

/**
 * This class creates a Queue data structure to simulate first in first out
 * (FIFO) of data storage and retrieval. This uses a singly Linked List.
 * 
 * @author Jacob Strokus
 *
 */
public class Queue {

	/**
	 * This is an nested-inner anonymous class to create Node Objects in a Linked
	 * List.
	 */
	class Node {

		/**
		 * The order contained in each node.
		 */
		protected Order order;

		/**
		 * Reference to the next node.
		 */
		protected Node next;

		/**
		 * constructs a node
		 * 
		 * @param val the order contained in each node.
		 * @param n   reference to the next node.
		 */
		Node(Order val, Node n) {
			order = val;
			next = n;
		}
	}

	// fields

	/**
	 * Reference to the head of the Queue.
	 */
	protected Node front = null;

	/**
	 * Reference to the tail of the Queue.
	 */
	protected Node rear = null;

	/**
	 * Integer representing the size of the Queue.
	 */
	protected int size;

	/**
	 * Add elements to the end of the Queue.
	 * 
	 * @param o orders to be added.
	 */
	public void enqueue(Order o) {
		if (rear != null) {
			rear.next = new Node(o, null);
			rear = rear.next;
		} else {
			rear = new Node(o, null);
			front = rear;
		}
		size++;
	}

	/**
	 * Remove from end of Queue.
	 */
	public void removeRear() {
		Node p = front;
		Node prev = null;
		if (empty())
			throw new EmptyQueueException("Queue is empty.");
		else if (front == rear) {
			rear = null;
			front = null;
		} else {
			while (p.next != null) {
				rear = prev;
				prev = p;
				p = p.next;
			}
			rear = prev;
			prev.next = null;
		} // end else
		size--;
	}// end method

	/**
	 * This method checks to see if the Queue is empty.
	 * 
	 * @return true if and only if Queue is empty.
	 */
	public boolean empty() {
		return front == null;
	}

	/**
	 * This method peek returns value at the front of the Queue.
	 * 
	 * @return item at front of Queue.
	 * @exception EmptyQueueException When the Queue is empty.
	 */

	public Order peek() {
		if (empty()) {
			throw new EmptyQueueException("Queue is empty.");
		} else
			return front.order;
	}

	/**
	 * This method removes and returns the item at the front of the Queue.
	 * 
	 * @return item at front of Queue.
	 * @exception EmptyQueueException When the Queue is empty.
	 */

	public Order dequeue() {
		if (empty())
			throw new EmptyQueueException("Queue is empty.");
		else {
			Order value = front.order;
			front = front.next;
			size--;
			if (front == null)
				rear = null;
			return value;
		}
	}

	/**
	 * This method to get the size of the Queue.
	 * 
	 * @return size of Queue.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * This method concatenates all strings in the queue to give a string
	 * representation of the contents of the Queue.
	 * 
	 * @return string representation of this Queue.
	 */

	public String toString() {
		StringBuilder sBuilder = new StringBuilder();

		// Walk down the list and append all values
		Node p = front;
		while (p != null) {
			sBuilder.append(p.order + " \n");
			p = p.next;
		}
		return sBuilder.toString();
	}
}
