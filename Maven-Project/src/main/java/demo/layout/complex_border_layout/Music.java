package demo.layout.complex_border_layout;

import java.io.File;

public class Music {
	
	String songName;
	String singerName;
	byte[] picture;
	byte[] audio;
	
	public Music( String songName, String singerName, byte[] picture, byte[] audio) {
		super();
		
		this.songName = songName;
		this.singerName = singerName;
		this.picture = picture;
		this.audio = audio;
	}
	
	
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getSingerName() {
		return singerName;
	}
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}


	public byte[] getAudio() {
		return audio;
	}


	public void setAudio(byte[] audio) {
		this.audio = audio;
	}
	
	

}
