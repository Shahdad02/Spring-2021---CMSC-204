import java.util.ArrayList;
/**
 * 
 * @author Shah's Thermal
 *
 * @param <T>
 */
public class NotationStack<T> implements StackInterface<T>{
	
	private int stackSize;
	private ArrayList<T> stack;
	int items = 0;
	
	public NotationStack() {
		stackSize = 100;
		stack = new ArrayList<T> (stackSize);
	}
	
	public NotationStack(int size) {
		stackSize = size;
		stack = new ArrayList<T> (stackSize);
	}
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	public boolean isEmpty() {
		if(items == 0) {
			return true;
			
		}else {
			return false;
			
		}
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	public boolean isFull() {
		if(items == stackSize) {
			return true;
			
		}else {
			return false;
		}
	}
	

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 */
	public T pop() throws StackUnderflowException {
		T popElement = null;
		
		if(items == 0) {
			throw new StackUnderflowException();
			
		}else {
			popElement = stack.get(items - 1);
			stack.remove(items - 1);
			items--;
			return popElement;
		}
	}
	
	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 */
	public T top() throws StackUnderflowException {
		if(items == 0) {
			throw new StackUnderflowException();
			
		}else {
			return stack.get(items - 1);
		}
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	public int size() {
		return items;
	}
	
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	public boolean push(T e) throws StackOverflowException {
		if(items >= stackSize) {
			throw new StackOverflowException();
			
		}else {
			stack.add(e);
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
		stack.addAll(copy);
		items = stack.size();
	}
	
	
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	public String toString() {
		String str = "";
		
		for(T i: stack) {
			str += i;
		}
		return str;
	}
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	public String toString(String delimiter) {
		String str = "";
		
		for(int i = 0; i < stack.size(); i++) {
			
			if(i != stack.size()-1) {
				str += stack.get(i) + delimiter;
				
			}else {
				str += stack.get(i);
			}
		}
		return str;
	}
	
}
