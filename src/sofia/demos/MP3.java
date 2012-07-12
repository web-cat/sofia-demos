package sofia.demos;

import java.util.Date;

import sofia.data.Property;

public class MP3
{
	private String artist;
	private String albumTitle;
	private Date releaseDate;
	private boolean gapless;
	
	
	public String getArtist()
	{
		return artist;
	}


	public void setArtist(String artist)
	{
		this.artist = artist;
	}


	@Property(hint = "Enter the album title", order = 9999)
	public String getAlbumTitle()
	{
		return albumTitle;
	}
	
	
	public void setAlbumTitle(String title)
	{
		this.albumTitle = title;
	}
	
	
	public Date getReleaseDate()
	{
		return releaseDate;
	}
	
	
	public void setReleaseDate(Date date)
	{
		this.releaseDate = date;
	}	


	@Property(label = "Gapless playback?")
	public boolean isGapless()
	{
		return gapless;
	}
	
	
	public void setGapless(boolean gapless)
	{
		this.gapless = gapless;
	}
	
	
	@Override
	public String toString()
	{
		return "" + albumTitle + " - " + artist + " (" + releaseDate + ")";
	}
}
