package main;

import java.util.LinkedList;
import java.util.List;

import boilerpipe.*;
import RSSCrawler.*;

public class MainClass {

	public static void main(String[] args) throws Exception {
		
		
		//1. RSS-CRAWLER liefert LINKs der RSS-FEED-Newsseiten
		
		RSSFeedParser parser = new RSSFeedParser(
                "http://www.tagesschau.de/xml/tagesschau-meldungen/");
        Feed feed = parser.readFeed();
		List<String> linkListeFeedMessages = new LinkedList<String>();
        for (FeedMessage message : feed.getMessages()) {
            linkListeFeedMessages.add(message.getGuid());
        }
		
        System.out.println(linkListeFeedMessages);
        
		//2. Diese Links werden in die Boilerpipe geleitet und der extracted Text rausgeholt
		
        
		
		
		//3. XML-Documente erzeugen und in Verzeichnisstruktur ablegen
		
		
		
		//4. Gleichzeitig extracted Text in NER-Stanford leiten
		
		
		
		//5. Lucene verarbeitet XML-DOkumente
		
		// TODO Auto-generated method stub
		Boilerpipe bp = new Boilerpipe();
	//	System.out.println(bp.contentFM("http://www.tagesschau.de/xml/tagesschau-meldungen/"));

	}

}
