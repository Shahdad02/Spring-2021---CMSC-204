/**
 * StackUnderflowException class
 * @author Shah's Thermal
 *
 */
public class StackUnderflowException extends Exception {
	/**
	 * in case of an exception
	 * display message when stack is empty
	 */
	public StackUnderflowException(){
		super("The stack is empty");
	}
}
