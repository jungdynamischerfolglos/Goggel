package verzeichnisstruktur;

import java.io.File;
import boilerpipe.Boilerpipe;
import nerTool.Beispiel;
import nerTool.NERBeispiel;
import sun.security.action.GetLongAction;
import RSSCrawler.*;


public class Verzeichnisbaum {

	Feed feed;
	String link;
	
	public static void checkDir(String path)
	{
		File vz = new File(path);
		if (!vz.exists())    // Überprüfen, ob es den Ordner gibt
	    {
	           vz.mkdir();    // Erstellen des Ordners
	    }
	}
	

	 @SuppressWarnings("static-access")
	private static void createDir(Feed feed, FeedMessage fm, String path) throws Exception
	    { 
			WriteXMLs writer = new WriteXMLs();   
			String dirCat = fm.getCategory();
		 	String neuerPath = path + "/" + dirCat;
	        
	        checkDir(neuerPath);

	        neuerPath = neuerPath + "/" + feed.getTitle();
	        
	        checkDir(neuerPath);
	        
	        neuerPath = neuerPath + "/";

    		//Boilerpipe
    		String content = Boilerpipe.contentFM(fm.getGuid());
    		System.out.println("Guid: " + fm.getGuid());
    		NERBeispiel nerBeispiel = new NERBeispiel(content);
	        writer.write(fm,content, neuerPath);
	    }
	
	
	
	public static void verzeichnisErstellen(Feed feed) throws Exception{
	
		  String dirNameLan = feed.getLanguage();
		  if(dirNameLan.contains("de-de") || dirNameLan.contains("de-DE"))
		  {
			  dirNameLan="de";
		  }
		  System.out.println(System.getProperty("user.dir"));
		  String path = "feedMessages" + "/" + dirNameLan;
//		  String path = "C:/Users/Maximilian.Bock/git/Goggel/Goggel/RSSFeeds" + "/" + dirNameLan;
		  checkDir(path);
		  
		  for(FeedMessage fm : feed.getMessages())
		  {
			  createDir(feed, fm, path);
		  }
	}
		
}
