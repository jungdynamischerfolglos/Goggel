package RSSCrawler;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class WriteTest {

    public static void main(String[] args) {
        // create the rss feed
    	
    	 RSSFeedParser parser = new RSSFeedParser(
                 "http://www.tagesschau.de/xml/tagesschau-meldungen/");
         Feed feed = parser.readFeed();
    	
        String copyright = feed.copyright;
        String title = feed.title;
        String description = feed.description;
        String language = feed.language;
        String link = feed.link;
        Calendar cal = new GregorianCalendar();
        Date creationDate = cal.getTime();
        SimpleDateFormat date_format = new SimpleDateFormat(
                "EEE', 'dd' 'MMM' 'yyyy' 'HH:mm:ss' 'Z", Locale.US);
        String pubdate = date_format.format(creationDate);
        Feed rssFeeder = new Feed(title, link, description, language,
                copyright, pubdate);

        // now add one example entry
        FeedMessage feedM = new FeedMessage();
        
        feedM.setTitle(feedM.getTitle());
        feedM.setDescription(feedM.getDescription());
        feedM.setAuthor(feedM.getAuthor());
        feedM.setGuid(feedM.getGuid());
        feedM.setLink(feedM.getLink());
        rssFeeder.getMessages().add(feedM);

        // now write the file
        RSSFeedWriter writer = new RSSFeedWriter(rssFeeder, "articles.rss");
        try {
            writer.write();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}