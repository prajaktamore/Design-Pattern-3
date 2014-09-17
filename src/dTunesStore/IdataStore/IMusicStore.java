package dTunesStore.IdataStore;

import java.util.Vector;

import dTunesStore.dataStore.MusicInfo;

/**
 * @author kapilbijamwar & Prajakta Interface for MusicStore class
 * 
 */
public interface IMusicStore {
	/**
	 * @param populated
	 */
	public void printMusicStore(Vector<MusicInfo> populated);
}
