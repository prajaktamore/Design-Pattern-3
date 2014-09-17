package dTunesStore.util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import dTunesStore.Iutil.IResults;
import dTunesStore.dataStore.MusicInfo;
import dTunesStore.driver.Driver;

/**
 * @author kapilbijamwar and PrajaktaMore Result class stores matched values and
 *         acts as Input source for output to be displayed
 */
public class Results implements IResults {

	public Results() {
		Debug.setDEBUG_VALUE(4, this.getClass().getName());
	}

	/**
	 * Vector variable name resultPopulated
	 */
	private static Vector<MusicInfo> resultPopulated = new Vector<MusicInfo>();

	/**
	 * @return the resultPopulated
	 */
	public static Vector<MusicInfo> getResultPopulated() {
		return resultPopulated;
	}

	/**
	 * @param resultPopulated
	 *            the resultPopulated to set
	 */
	public static void setResultPopulated(Vector<MusicInfo> resultPopulated) {
		Results.resultPopulated = resultPopulated;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dTunesStore.Iutil.IDisplay#browserRead()
	 */
	@Override
	public void browserRead() throws IOException {
		Debug.setDEBUG_VALUE(1, Driver.class.getName());
		PrintWriter writer = new PrintWriter("Result.txt", "UTF-8");
		if (null != Results.getResultPopulated()) {
			for (MusicInfo vectorValue : Results.getResultPopulated()) {
				writer.print(vectorValue.getSongName() + " ");
				writer.print(vectorValue.getAlbumName() + " ");
				writer.print(vectorValue.getSingerName() + " ");
				writer.println(vectorValue.getDuration());
			}
			writer.flush();
			writer.close();
			String htmlFile = "Result.txt";
			File file = new File(htmlFile);
			// Desktop.getDesktop().browse(file.toURI());
			Desktop.getDesktop().open(file);
		} else {
			Debug.setDEBUG_VALUE(0, Driver.class.getName());
		}

	}
}
