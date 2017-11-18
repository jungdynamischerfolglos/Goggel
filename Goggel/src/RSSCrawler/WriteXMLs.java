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


		public static String generateNameString(FeedMessage fm){
			
			String s = "" + fm.getDescription().hashCode();
			return s;
		}
		
		
		public static void write(Feed feed) throws Exception {
		
	        
	        for (FeedMessage message : feed.getMessages()) 
	        	{
	        		String nameArtikel = "RSS" + generateNameString(message) +".xml";
	        		System.out.println(nameArtikel);
	        		
	    	        // now write the file        	
	        		RSSFeedMessageWriter writer = new RSSFeedMessageWriter(message,nameArtikel);
	                System.out.println(message);
	                
	        		//URL der FeedMessage
	        		String url = message.getGuid();
	        		System.out.println(url);
	        		
	        		//Boilerpipe
	        		String content = Boilerpipe.contentFM(url);
	        		System.out.println(content);
	  
					writer.writeFM(message, content);
					
	        	}
	    }

	}

