package main;

import RSSCrawler.Feed;
import RSSCrawler.RSSFeedParser;
import RSSCrawler.WriteXMLs;
import boilerpipe.*;
import verzeichnisstruktur.Verzeichnisbaum;

public class MainClass {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
//		Boilerpipe pipe = new Boilerpipe();
//		System.out.println(pipe.contentFM("http://www.tagesschau.de/wirtschaft/schlecker-urteile-101.html"));
//		
		//1. Writer wird erzeugt: In diesem wird RSS Crawler aufgerufen; der liefert LINKs 
		// der RSS-FEED-Newsseite (hier: tagesschau) und diese werden in Boilerpipe eingeleitet
		// und es werden im RSSFeedMessageWriter XMLs die einzelnen Dokumente dazu erzeugt
		// alles in WriteXMLs kombiniert
		WriteXMLs writer = new WriteXMLs();
		Verzeichnisbaum vzbaum = new Verzeichnisbaum();
		
		String[] linkliste = {"http://www.spiegel.de/schlagzeilen/index.rss",
				"http://www.wiwo.de/contentexport/feed/rss/schlagzeilen",
				
				"https://www.stern.de/feed/standard/all/"};
		
        for(int i=0;i<linkliste.length;i++)
        {
        	RSSFeedParser parser = new RSSFeedParser(linkliste[i]);
        	Feed feed = parser.readFeed();
        	vzbaum.verzeichnisErstellen(feed);
        }
		


		//2. XML-Dokumente erzeugen und in Verzeichnisstruktur ablegen
		
        
        
		
		
		//3. Gleichzeitig extracted Text in NER-Stanford leiten
		
		
		
		//5. Lucene verarbeitet XML-DOkumente
		
		// TODO Auto-generated method stub
		

	}

}
