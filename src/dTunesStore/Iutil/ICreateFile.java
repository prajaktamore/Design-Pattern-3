package dTunesStore.Iutil;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * @author kapilbijamwar & PrajaktaMore Interface for CreateFile class
 */
public interface ICreateFile {
	/**
	 * @param dataFile
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public void createFile(String dataFile) throws FileNotFoundException,
			UnsupportedEncodingException;

	/**
	 * @param searchFile
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public void createSearchFile(String searchFile)
			throws FileNotFoundException, UnsupportedEncodingException;
}
