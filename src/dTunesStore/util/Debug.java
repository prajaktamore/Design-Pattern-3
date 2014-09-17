package dTunesStore.util;

/**
 * @author kapilbijamwar & PrajaktaMore Debugger class that maintains logging
 *         information
 */
public class Debug {

	/**
	 * Integer Variable DEBUG_VALUE used for Logger
	 */
	private static int DEBUG_VALUE;

	// accessor and mutator for DEBUG_VALUE

	/**
	 * @return the dEBUG_VALUE
	 */
	public static int getDEBUG_VALUE() {
		return DEBUG_VALUE;
	}

	/**
	 * @param dEBUG_VALUE
	 *            the dEBUG_VALUE to set
	 */
	public static void setDEBUG_VALUE(int dEBUG_VALUE, String className) {
		DEBUG_VALUE = dEBUG_VALUE;
		if (DEBUG_VALUE == 4) {
			System.out.println(className + "Constructor is Called");
		} else if (DEBUG_VALUE == 3) {
			System.out.println(className + "Thread's run() method is called");
		} else if (DEBUG_VALUE == 2) {
			System.out.println("Entry is added to the Results data structure");
		} else if (DEBUG_VALUE == 1) {
			System.out.println("Stdout the search results");
		} else if (DEBUG_VALUE == 0) {
			System.out.println("No Output");
		}
	}

}