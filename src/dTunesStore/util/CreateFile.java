package dTunesStore.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import dTunesStore.Iutil.ICreateFile;

/**
 * @author kapilbijamwar & PrajaktaMore Class creates DataFile and SearchFile
 * 
 */
public class CreateFile implements ICreateFile {
	/*
	 * (non-Javadoc)
	 * 
	 * @see dTunesStore.Iutil.ICreateFile#createFile(java.lang.String)
	 */
	@Override
	public void createFile(String dataFile) throws FileNotFoundException,
			UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(dataFile, "UTF-8");
		for (int i = 0; i < 200; i++) {
			String value = new Integer(i).toString();
			writer.print("aaa".concat(value) + " ");
			writer.print("bbb".concat(value) + " ");
			writer.print("ccc".concat(value) + " ");
			writer.println(value);
		}
		writer.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dTunesStore.Iutil.ICreateFile#createSearchFile(java.lang.String)
	 */
	@Override
	public void createSearchFile(String searchFile)
			throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(searchFile, "UTF-8");
		for (int i = 0; i < 20; i++) {
			String value = new Integer(i).toString();
			writer.println("aaa".concat(value));
			if(i<5){
				writer.println("ddd".concat(value));
			}
			i = i +1;
		}
		writer.close();
	}

}
