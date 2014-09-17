package dTunesStore.dataStore;

/**
 * MusicInfo class will act like POJO
 */
public class MusicInfo {

	/**
	 * String variable songName
	 */
	private String songName;
	/**
	 * String variable albumName
	 */
	private String albumName;
	/**
	 * String variable singerName
	 */
	private String singerName;
	/**
	 * String variable duration
	 */
	private int duration;

	/**
	 * @return the songName
	 */
	public String getSongName() {
		return songName;
	}

	/**
	 * @param songName
	 *            the songName to set
	 */
	public void setSongName(String songName) {
		this.songName = songName;
	}

	/**
	 * @return the albumName
	 */
	public String getAlbumName() {
		return albumName;
	}

	/**
	 * @param albumName
	 *            the albumName to set
	 */
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	/**
	 * @return the singerName
	 */
	public String getSingerName() {
		return singerName;
	}

	/**
	 * @param singerName
	 *            the singerName to set
	 */
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

}
