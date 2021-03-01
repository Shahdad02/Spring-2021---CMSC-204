/**
 * QueueUnderflowException class
 * @author Shah's Thermal
 *
 */
public class QueueUnderflowException extends Exception {
	/**
	 * in case of exception
	 * display message that queue is empty
	 */
	public QueueUnderflowException() {
		super("The queue is empty");
	}
}
