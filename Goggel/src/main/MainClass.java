package main;

import java.util.LinkedList;
import java.util.List;

import boilerpipe.*;
import RSSCrawler.*;

public class MainClass {

	public static void main(String[] args) throws Exception {
		
		
		//1. Writer wird erzeugt: Dieser enthält einen RSS-CRAWLER; der liefert LINKs 
		// der RSS-FEED-Newsseite (hier: tagesschau) und diese wird in Boilerpipe eingeleitet
		// und es werden im RSSFeedMessageWriter XMLs der einzelnen Dokumente erzeugt
		// alles in WriteXMLs kombiniert
        
        WriteXMLs writer = new WriteXMLs();
        writer.write("http://www.tagesschau.de/xml/tagesschau-meldungen/");
        
		
		
		//3. XML-Documente erzeugen und in Verzeichnisstruktur ablegen
		
		
		
		//4. Gleichzeitig extracted Text in NER-Stanford leiten
		
		
		
		//5. Lucene verarbeitet XML-DOkumente
		
		// TODO Auto-generated method stub
		

	}

}
