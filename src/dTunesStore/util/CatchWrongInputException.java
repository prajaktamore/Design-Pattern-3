package dTunesStore.util;

/**
 * @author kapilbijamwar & PrajaktaMore User Defined exception class, That
 *         validates input data
 */
public class CatchWrongInputException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param s
	 */
	public CatchWrongInputException(String s) {
		super(s);
	}
}
