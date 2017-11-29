package RSSCrawler;

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



