package RSSCrawler;

import boilerpipe.*;
import verzeichnisstruktur.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class WriteXMLs {

	public static String generateNameString(int i){
		
		String s;
		s = new String("Artikel"+i);			
		i++;
		return s;
	}
	
	
	public static void write(String s) throws Exception {
	
    	RSSFeedParser parser = new RSSFeedParser(s);
        Feed feed = parser.readFeed();

        int i = 0;
        
        for (FeedMessage message : feed.getMessages()) 
        	{
        	
        		String nameArtikel = generateNameString(i);
        		System.out.println(nameArtikel);
    	        // now write the file        	
        		RSSFeedMessageWriter writer = new RSSFeedMessageWriter(message, nameArtikel+".xml");
                System.out.println(message);
                
        		//URL der FeedMessage
        		String url = message.getGuid();
        		System.out.println(url);
        		
        		//Boilerpipe
        		String content = Boilerpipe.contentFM(url);
        			System.out.println(content);
  
				writer.writeFM(message, content);
				i++;
				
        	}
    }

}