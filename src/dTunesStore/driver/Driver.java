package dTunesStore.driver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import dTunesStore.IdataStore.IMusicStore;
import dTunesStore.IdataStore.IPopulateWorker;
import dTunesStore.IdataStore.ISearchWorker;
import dTunesStore.Iutil.ICreateFile;
import dTunesStore.Iutil.IResults;
import dTunesStore.dataStore.MusicStore;
import dTunesStore.dataStore.PopulateWorker;
import dTunesStore.dataStore.SearchWorker;
import dTunesStore.util.CatchWrongInputException;
import dTunesStore.util.CreateFile;
import dTunesStore.util.Debug;
import dTunesStore.util.Results;

/**
 * @author kapilbijamwar & PrajaktaMore Driver class is the driver that creates
 *         objects of all Interfaces of classes and control complete program
 *         flow
 */
public class Driver {

	public Driver() {
		Debug.setDEBUG_VALUE(4, this.getClass().getName());
	}

	static FileReader fileReader;
	static BufferedReader br;
	static String musicFileName;
	static String searchFileName;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		System.out.println(args[3]);
		setMusicFileName(args[0]);
		String NNString = args[1];
		int NN = Integer.parseInt(NNString);
		try {
			checkUserInput(NN);

		} catch (CatchWrongInputException e) {
			System.err.println("Exception Occured :: "+e.getMessage());
			System.exit(0);
		} finally {
			System.out.println("Program Execution Started");

		}

		setSearchFileName(args[2]);

		String MMString = args[3];
		int MM = Integer.parseInt(MMString);
		try {
			checkUserInput(MM);
		} catch (CatchWrongInputException e) {
			System.err.println("Exception Occured :: "+e.getMessage());
			System.exit(0);
		} finally {
			System.out.println("Program Execution Started");

		}

		try {
			if (null == musicFileName || null == searchFileName
					|| musicFileName.equalsIgnoreCase(searchFileName)) {
				throw new CatchWrongInputException(
						"MusicFileName and SearchFileName are Same");
			}
		} catch (CatchWrongInputException e) {
			System.err.println("Exception Occured :: "+e.getMessage());
			System.exit(0);
		} finally {
			System.out.println("Program Execution Started");

		}
		ICreateFile createFile = new CreateFile();
		createFile.createFile(musicFileName);

		createFile.createSearchFile(searchFileName);

		IPopulateWorker populateWorker = new PopulateWorker();
		populateWorker.threadPoolMethod(MM);

		IMusicStore musicStore = new MusicStore();
		musicStore.printMusicStore(MusicStore.getPopulated());

		ISearchWorker searchWorker = new SearchWorker();
		searchWorker.threadSearchMethod(NN);

		IResults display = new Results();
		display.browserRead();
	}

	/**
	 * @param input
	 * @throws CatchWrongInputException
	 */
	public static void checkUserInput(int input)
			throws CatchWrongInputException {
		try {
			if (input < 1 || input > 5) {
				throw new CatchWrongInputException(
						"MM and NN should be between 1 to 5");
			}
		} catch (CatchWrongInputException e) {
			System.err.println("Exception Occured :: "+e.getMessage());
			System.exit(0);

		} finally {
			System.out.println("Program Failed to Execute");
		}
	}

	/**
	 * @return the fileReader
	 */
	public static FileReader getFileReader() {
		return fileReader;
	}

	/**
	 * @param fileReader
	 *            the fileReader to set
	 */
	public static void setFileReader(FileReader fileReader) {
		Driver.fileReader = fileReader;
	}

	/**
	 * @return the br
	 */
	public static BufferedReader getBr() {
		return br;
	}

	/**
	 * @param br
	 *            the br to set
	 */
	public static void setBr(BufferedReader br) {
		Driver.br = br;
	}

	/**
	 * @return the musicFileName
	 */
	public static String getMusicFileName() {
		return musicFileName;
	}

	/**
	 * @param musicFileName
	 *            the musicFileName to set
	 */
	public static void setMusicFileName(String musicFileName) {
		Driver.musicFileName = musicFileName;
	}

	/**
	 * @return the searchFileName
	 */
	public static String getSearchFileName() {
		return searchFileName;
	}

	/**
	 * @param searchFileName
	 *            the searchFileName to set
	 */
	public static void setSearchFileName(String searchFileName) {
		Driver.searchFileName = searchFileName;
	}

}
