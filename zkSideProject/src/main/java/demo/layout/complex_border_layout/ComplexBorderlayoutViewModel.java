package demo.layout.complex_border_layout;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

//import org.apache.commons.lang.StringUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.sound.AAudio;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.MouseEvent;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Area;
import org.zkoss.zul.Audio;
import org.zkoss.zul.PieModel;
import org.zkoss.zul.SimplePieModel;

public class ComplexBorderlayoutViewModel {

	private static final String searchUrl = "http://www.zkoss.org/doc/searchresult.jsp?cx=008321236477929467003%3A63kdpeqkkvw&cof=FORID%3A11&q=";

	private String search;
	private List<Contribution> contributions = new ArrayList<Contribution>();
	private List<Music> musics = new ArrayList<Music>();
	private Music selectedMusic;
	private PieModel pieModel;

	@Init
	public void init() throws IOException {
		
		contributions.add(new Contribution("Europe", 31,  Files.readAllBytes(Paths.get("D:\\linkedin_16.png"))));
		contributions.add(new Contribution("Africa", 4, Files.readAllBytes(Paths.get("D:\\linkedin_16.png"))));
		contributions.add(new Contribution("Americas", 25, Files.readAllBytes(Paths.get("D:\\linkedin_16.png"))));
		contributions.add(new Contribution("Oceania", 4, Files.readAllBytes(Paths.get("D:\\linkedin_16.png"))));
		contributions.add(new Contribution("Asia", 29, Files.readAllBytes(Paths.get("D:\\linkedin_16.png"))));
		contributions.add(new Contribution("Others", 4, Files.readAllBytes(Paths.get("D:\\linkedin_16.png"))));
		
		musics.add(new Music("Call ln 計劃 ep.03 Keep Up", "陳嫺靜", Files.readAllBytes(Paths.get("D:\\1.jfif")), Files.readAllBytes(Paths.get("D:\\1.wav"))));
		musics.add(new Music("餘生慢慢", "陳嫺靜2", Files.readAllBytes(Paths.get("D:\\2.jfif")), Files.readAllBytes(Paths.get("D:\\1.wav"))));
		musics.add(new Music("HOLY SHIT", "FOSTER", Files.readAllBytes(Paths.get("D:\\3.jfif")),Files.readAllBytes(Paths.get("D:\\1.wav"))));
		musics.add(new Music("SCHEISSE", "GGHH", Files.readAllBytes(Paths.get("D:\\4.jfif")), Files.readAllBytes(Paths.get("D:\\1.wav"))));
		musics.add(new Music("草尼瑪", "PYTHON HELLO WORLD", Files.readAllBytes(Paths.get("D:\\5.jfif")), Files.readAllBytes(Paths.get("D:\\1.wav"))));
		createPieModel();
	}

	private void createPieModel() {
		pieModel = new SimplePieModel();

		for (Contribution contribution : contributions) {
			pieModel.setValue(contribution.getArea(), contribution.getValue());
		}
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public PieModel getPieModel() {
		return pieModel;
	}

	public List<Contribution> getContributions() {
		return contributions;
	}

//	@Command
//	public void search() {
//		if(StringUtils.isEmpty(search)) {
//			Clients.showNotification("Search field must not be empty");
//		} else {
//			Executions.getCurrent().sendRedirect(searchUrl.concat(search), "_zk");
//		}
//	}
	
	@Command
	public void showMusic(@BindingParam("songName")String songName) {
//		System.out.println(selectedMusic);
//		System.out.println("sss="+selectedMusic.getSongName());
//		System.out.println(songName);
	}
	
//	@Command
//	public void playMusic(@BindingParam("audio")File audio) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
//		System.out.println(audio);
//		
//		 Audio player = new AAudio(audio);
//		
//	}
	
	@Command
	public void displayArea(@ContextParam(ContextType.TRIGGER_EVENT) MouseEvent event) {
		Component component = event.getAreaComponent();

		if (component instanceof Area) {
			Area area = (Area) component;
			Clients.alert(area.getAttribute("entity") + ":"
					+ area.getTooltiptext());
		}
	}

	@Command
	@NotifyChange("pieModel")
	public void updatePieModel() {
		createPieModel();
	}

	public static class Contribution {
		private String area;
		private int value;
		private byte[] picture;

		public Contribution(String country, int value, byte[] picture) {
			super();
			this.area = country;
			this.value = value;
			this.picture = picture;
		}

		public String getArea() {
			return area;
		}

		public void setArea(String area) {
			this.area = area;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public byte[] getPicture() {
			return picture;
		}

		public void setPicture(byte[] picture) {
			this.picture = picture;
		}

	}

	public List<Music> getMusics() {
		return musics;
	}

	public void setMusics(List<Music> musics) {
		this.musics = musics;
	}

	

	public Music getSelectedMusic() {
		return selectedMusic;
	}

	public void setSelectedMusic(Music selectedMusic) {
		this.selectedMusic = selectedMusic;
	}
}
