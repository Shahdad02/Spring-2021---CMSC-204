/**
 * InvalidNotationFormatException class
 * @author Shah's Thermal
 *
 */
public class InvalidNotationFormatException extends Exception {
	/**
	 * in case of an exception
	 * display invalid notation exception
	 */
	InvalidNotationFormatException() {
		super("Format of notation is incorrect");
	}
}
