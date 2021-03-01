/**
 * StackOverflowException class
 * @author Shah's Thermal
 *
 */
public class StackOverflowException extends Exception {
	/**
	 * in case of an exception
	 * displays message when stack is full
	 */
	public StackOverflowException() {
		super("The stack is full");
	}
}
