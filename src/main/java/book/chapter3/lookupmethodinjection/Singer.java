package book.chapter3.lookupmethodinjection;

public class Singer {
	private int s = 0 ; 
	private String lyric = "I played a quick game of chess with the salt and pepper shaker... " + s ; 
	
	
	public void sing() {
		s++ ; 
	}


	public String getLyric() {
		return lyric;
	}
}
