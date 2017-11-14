package boilerpipe;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
 

import de.l3s.boilerpipe.document.TextDocument;
import de.l3s.boilerpipe.extractors.CommonExtractors;
import de.l3s.boilerpipe.sax.BoilerpipeSAXInput;
import de.l3s.boilerpipe.sax.HTMLDocument;
import de.l3s.boilerpipe.sax.HTMLFetcher;
 
public class Boilerpipe {
	
	public static String contentFM(String url) throws Exception {
		final HTMLDocument htmlDoc = HTMLFetcher.fetch(new URL(url));
		final TextDocument doc = new BoilerpipeSAXInput(htmlDoc.toInputSource()).getTextDocument();
		String content = CommonExtractors.ARTICLE_EXTRACTOR.getText(doc);
		return content;
	}
	
	public static void main(String[] args) throws Exception{
		
		String a = contentFM("http://www.sportschau.de/fussball/bundesliga2/spielbericht-holstein-kiel-dynamo-dresden-100.html");
		System.out.println(a);
		
	}
}