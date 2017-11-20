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
		
		
		public static void write(FeedMessage fm, String content, String path) throws Exception {
				
	        		String nameArtikel = path + "RSS" + generateNameString(fm) +".xml";
	        		
	    	        // now write the file        	
	        		RSSFeedMessageWriter writer = new RSSFeedMessageWriter(fm,nameArtikel);
	        		
					writer.writeFM(fm, content);					
	        	}
   }



