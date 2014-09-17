package dTunesStore.dataStore;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import dTunesStore.IdataStore.ISearchWorker;
import dTunesStore.driver.Driver;
import dTunesStore.util.Debug;
import dTunesStore.util.Results;

/**
 * @author kapilbijamwar & PrajaktaMore SearchWorker class searches data from
 *         SearchFile in MusicStore and generate output to result class
 */
public class SearchWorker implements ISearchWorker {
	private static Vector<MusicInfo> searchPopulated = new Vector<MusicInfo>();

	public SearchWorker() {
		Debug.setDEBUG_VALUE(4, this.getClass().getName());
	}

	/**
	 * @return the searchPopulated
	 */
	public static Vector<MusicInfo> getSearchPopulated() {
		return searchPopulated;
	}

	/**
	 * @param searchPopulated
	 *            the searchPopulated to set
	 */
	public static void setSearchPopulated(Vector<MusicInfo> searchPopulated) {
		SearchWorker.searchPopulated = searchPopulated;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dTunesStore.IdataStore.ISearchWorker#threadSearchMethod(int)
	 */
	@Override
	public void threadSearchMethod(int NN) {
		try {
			Driver.setFileReader(new FileReader(Driver.getSearchFileName()));
		} catch (FileNotFoundException e) {
			System.err.println("Exception Occured :: "+e.getMessage());
		}
		Driver.setBr(new BufferedReader(Driver.getFileReader()));
		Thread[] thread = new Thread[NN];
		for (int i = 0; i < NN; i++) {
			thread[i] = new Thread(new ExecuteThreadSearch());
			thread[i].start();
			try {
				thread[i].join();
			} catch (InterruptedException e) {
				System.err.println("Exception Occured :: "+e.getMessage());
			}finally{
				System.out.println("Thread Joined");
			}
		}
		Results.setResultPopulated(getSearchPopulated());
	}

}

/**
 * @author kapilbijamwar & PrajaktaMore This class implements Runnable, which in
 *         multithreading environment read data from Searchfile and compares
 *         data with MusicStore producing matching results
 */
class ExecuteThreadSearch implements Runnable {
	SearchWorker searchWorker = new SearchWorker();
	static Vector<MusicInfo> tempMap = new Vector<MusicInfo>();
	MusicStore musicStore = new MusicStore();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Debug.setDEBUG_VALUE(3, this.getClass().getName());
		if (null != MusicStore.getPopulated()) {
			searchData(MusicStore.getPopulated());
		}
		SearchWorker.setSearchPopulated(tempMap);
	}

	/**
	 * @param populated
	 */
	private synchronized void searchData(Vector<MusicInfo> populated) {

		String fileData = null;
		if (Driver.getBr() != null) {
			System.out.println("Thread that searched:::"
					+ Thread.currentThread().getName());
			try {
				while ((fileData = Driver.getBr().readLine()) != null) {
					for (MusicInfo populatedMusicStore : populated) {
						if (fileData.equalsIgnoreCase(populatedMusicStore
								.getSongName())
								|| fileData
										.equalsIgnoreCase(populatedMusicStore
												.getAlbumName())
								|| fileData
										.equalsIgnoreCase(populatedMusicStore
												.getSingerName())) {
							MusicInfo musicInfo = new MusicInfo();
							musicInfo = populatedMusicStore;
							tempMap.add(musicInfo);
							break;
						}

					}

				}

			} catch (IOException e) {
				System.err.println("Exception Occured :: "+e.getMessage());
			}finally{
				System.out.println("Running Search");
			}
		}
	}
}
