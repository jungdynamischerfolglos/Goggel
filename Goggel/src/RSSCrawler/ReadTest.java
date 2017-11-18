package RSSCrawler;



public class ReadTest {
    public static void main(String[] args) {
        RSSFeedParser parser = new RSSFeedParser(
                "http://www.tagesschau.de/xml/rss2");
        Feed feed = parser.readFeed();
        System.out.println(feed);
        
     
       
     for (FeedMessage message : feed.getMessages()) {
            System.out.println(message);
        }

    }
}