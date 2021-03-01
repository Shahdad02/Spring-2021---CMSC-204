import java.util.ArrayList;
import java.util.Collection;

public class NotationQueue<T> implements QueueInterface<T> {
	
	private int queueSize;
	private ArrayList<T> queue;
	int front, end, items = 0;
	
	public NotationQueue() {
		queueSize = 100;
		queue = new ArrayList<T> (queueSize);
	}
	
	public NotationQueue(int size) {
		queueSize = size;
		queue = new ArrayList<T> (queueSize);
	}
	
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	public boolean isEmpty() {
		if(items == 0) {
			return true;
			
		}else {
			return false;
		}
	}

	/**
	 * Determines of the Queue is empty
	 * @return
	 */
	public boolean isFull() {
		if(items == queueSize) {
			return true;
		
		}else { 
			return false;
		}
	}
	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 */
	public T dequeue() throws QueueUnderflowException {
		T dequeueElm;
		
		if(items == 0) {
			throw new QueueUnderflowException();
			
		}else {
			dequeueElm = queue.get(front);
			front++;
			items--;
		}
		return dequeueElm;
	}

	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	public int size() {
		return items;
	}
	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	public boolean enqueue(T e) throws QueueOverflowException{
		
		if(items == queueSize) {
			throw new QueueOverflowException();
			
		}else {
			queue.add(end, e);
			end++;
			items++;
			return true;
		}
	}
	
	/**
	 * Fills the stack with elements from the ArrayList
	 * @param list the elements of the stack from top to bottom
	 */
	
	public void fill(ArrayList<T> list) {
		ArrayList<T> copy = new ArrayList<T>(list);
		queue.addAll(copy);
		items = queue.size();
	}
	
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	public String toString() {
		String str = "";
		
		for(T i: queue) {
			str += i;
		}
		return str;
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	public String toString(String delimiter) {
		String str = "";
		
		for(int i = 0; i < queue.size(); i++) {
			if(i != queue.size()-1) {
				str += queue.get(i) + delimiter;
				
			}else {
				str += queue.get(i);
			}
		}
		return str;
	}
}
