/**
 * QueueOverflowException class
 * @author Shah's Thermal
 *
 */
public class QueueOverflowException extends Exception {
	/**
	 * in case of exception
	 * display message that queue is full
	 */
	public QueueOverflowException() {
		super("The queue is full");
	}
}
