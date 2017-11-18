package verzeichnisstruktur;

import java.io.File;
import java.io.IOException;

import RSSCrawler.*;


public class Verzeichnisbaum {

	Feed feed;
	String link;
	WriteXMLs writer = new WriteXMLs();
	
	public static void checkDir(String path){
		 
		Boolean bool;
		File vz = new File(path);
		if (!vz.exists())    // �berpr�fen, ob es den Ordner gibt
	    {
	           vz.mkdir();    // Erstellen des Ordners
	    }
	}
	

	 private static void createDir(Feed feed, FeedMessage fm, String path)
	    { 
		    String dirCat = fm.getCategory();
		 	String neuerPath = path + "/" + dirCat;
	        File vz1 = new File(neuerPath);
	        
	        checkDir(neuerPath);

	        neuerPath = neuerPath + "/" + feed.getTitle();
	        
	        checkDir(neuerPath);
	    }
	
	
	
	public static void verzeichnisErstellen(Feed feed){
	
		  String dirNameLan = feed.getLanguage();
		  if(dirNameLan.contains("de-de"))
		  {
			  dirNameLan="de";
		  }
		  String path = "C:/Users/Maximilian.Bock/git/Goggel/Goggel/RSSFeeds" + "/" + dirNameLan;
		  checkDir(path);
		  
		  for(FeedMessage fm : feed.getMessages())
		  {
			  createDir(feed, fm,path);
		  }
	}
		
}
