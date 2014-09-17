package dTunesStore.dataStore;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import dTunesStore.IdataStore.IPopulateWorker;
import dTunesStore.driver.Driver;
import dTunesStore.util.Debug;

/**
 * @author kapilbijamwar & PrajaktaMore Creates pool of Threads that read Data
 *         from DataFile to populate MusicStore class
 * 
 */
public class PopulateWorker implements IPopulateWorker {
	public PopulateWorker() {
		Debug.setDEBUG_VALUE(4, this.getClass().getName());
	}

	
	/* (non-Javadoc)
	 * @see dTunesStore.IdataStore.IPopulateWorker#threadPoolMethod(int)
	 */
	@Override
	public void threadPoolMethod(int NN) {
		try {
			Driver.setFileReader(new FileReader(Driver.getMusicFileName()));
		} catch (FileNotFoundException e) {
			System.err.println("Exception Occured :: "+e.getMessage());
		}
		Driver.setBr(new BufferedReader(Driver.getFileReader()));
		Thread[] threads = new Thread[NN];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new ExecuteThreads());
			threads[i].start();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.err.println("Exception Occured :: "+e.getMessage());
		}finally{
			System.out.println("Thread Interrupted Exception");
		}

	}

}

/**
 * @author kapilbijamwar & PrajaktMore This class implements Runnable, which in
 *         multithreading environment read data from DataFile and stores it in a
 *         MusicStore
 * 
 */
class ExecuteThreads implements Runnable {
	static Vector<MusicInfo> populated1 = new Vector<MusicInfo>();
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Debug.setDEBUG_VALUE(3, this.getClass().getName());
		try {

			if (Driver.getBr() != null) {
				System.out.println(Thread.currentThread().getName());
					readFile();
			}
			MusicStore.setPopulated(populated1);
		} catch (IOException e) {
			System.err.println("Exception Occured :: "+e.getMessage());
		}finally{
			System.out.println("Running PopulateWorker");
		}

	}

	/**
	 * @throws IOException
	 */
	public synchronized void readFile() throws IOException {
		String fileData = null;
		while ((fileData = Driver.getBr().readLine()) != null) {
			System.out.println("Thread########## ::"
					+ Thread.currentThread().getName());
			System.out.println("Data:::::::" + fileData);
			MusicInfo musicInfo = new MusicInfo();
			String strConcat = fileData;
			String[] splitted = strConcat.split(" ");
			musicInfo.setSongName(splitted[0].trim());
			musicInfo.setAlbumName(splitted[1].trim());
			musicInfo.setSingerName(splitted[2].trim());
			musicInfo.setDuration(Integer.parseInt(splitted[3]));
			populated1.add(musicInfo);
		}
	}
}
