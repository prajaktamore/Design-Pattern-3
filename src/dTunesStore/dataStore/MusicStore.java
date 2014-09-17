package dTunesStore.dataStore;

import java.util.Vector;

import dTunesStore.IdataStore.IMusicStore;
import dTunesStore.util.Debug;

/**
 * @author kapilbijamwar & PrajaktaMore MusicStore class stores Data populated
 *         from DataFile which is further used in SearchWorker class
 * 
 */
public class MusicStore implements IMusicStore {

	public MusicStore() {
		Debug.setDEBUG_VALUE(4, this.getClass().getName());
	}

	private static Vector<MusicInfo> populated = new Vector<MusicInfo>();

	/**
	 * @return the populated
	 */
	public static Vector<MusicInfo> getPopulated() {
		return populated;
	}

	/**
	 * @param populated
	 *            the populated to set
	 */
	public static void setPopulated(Vector<MusicInfo> populated) {
		MusicStore.populated = populated;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dTunesStore.IdataStore.IMusicStore#printMusicStore(java.util.Vector)
	 */
	@Override
	public void printMusicStore(Vector<MusicInfo> populated) {
		System.out.println("Music Store Output::::::::::::::");
		for (MusicInfo musicStore : populated) {
			System.out.print(musicStore.getSongName() + " ");
			System.out.print(musicStore.getAlbumName() + " ");
			System.out.print(musicStore.getSingerName() + " ");
			System.out.println(musicStore.getDuration());
		}
	}

}
