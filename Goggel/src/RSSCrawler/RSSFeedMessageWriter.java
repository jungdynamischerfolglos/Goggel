package RSSCrawler;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;



public class RSSFeedMessageWriter{

	
	private String outputFile;
	private FeedMessage fm;

    public RSSFeedMessageWriter(FeedMessage fm, String outputFile) {
        this.fm= fm;
        this.outputFile = outputFile;
    }
	

	public void writeFM(FeedMessage fm, String contentBoilerpipe) throws Exception{
		
		  // create a XMLOutputFactory
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();

        // create XMLEventWriter
        XMLEventWriter eventWriter = outputFactory
                .createXMLEventWriter(new FileOutputStream(outputFile));

        // create a EventFactory

        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        XMLEvent end = eventFactory.createDTD("\n");

        // create and write Start Tag

        StartDocument startDocument = eventFactory.createStartDocument();

        eventWriter.add(startDocument);

        // create open tag
        eventWriter.add(end);

        StartElement rssStart = eventFactory.createStartElement("", "", "rss");
        eventWriter.add(rssStart);
        eventFactory.createDTD("\n");
        eventWriter.add(eventFactory.createAttribute("version", "2.0"));
        eventFactory.createDTD("\n");
        eventWriter.add(end);
        eventWriter.add(eventFactory.createDTD("\n"));
        eventWriter.add(eventFactory.createStartElement("", "", "channel"));
        eventWriter.add(end);

        
        createNode(eventWriter, "title", fm.getTitle());

        createNode(eventWriter, "description",fm.getDescription());
        
        createNode(eventWriter, "link", fm.getLink());

        if(fm.getAuthor()=="")
        {
        	fm.setAuthor("Unbekannt");
        }
        createNode(eventWriter, "language", fm.getAuthor());

        createNode(eventWriter, "copyright", fm.getGuid());
       
	    
        createNode(eventWriter, "extractedText", contentBoilerpipe);
            
        eventWriter.add(end);
        eventWriter.add(eventFactory.createEndElement("", "", "channel"));
        eventWriter.add(end);
        eventWriter.add(eventFactory.createEndElement("", "", "rss"));

        eventWriter.add(end);

        eventWriter.add(eventFactory.createEndDocument());

        eventWriter.close();
		
	}
	
	

	 private void createNode(XMLEventWriter eventWriter, String name, String value) throws XMLStreamException {
			
		 XMLEventFactory eventFactory = XMLEventFactory.newInstance();
			        XMLEvent end = eventFactory.createDTD("\n");
			        XMLEvent tab = eventFactory.createDTD("\t");
			        // create Start node
			        StartElement sElement = eventFactory.createStartElement("", "", name);
			        eventWriter.add(tab);
			        eventWriter.add(sElement);
			        // create Content
			        Characters characters = eventFactory.createCharacters(value);
			        eventWriter.add(characters);
			        // create End node
			        EndElement eElement = eventFactory.createEndElement("", "", name);
			        eventWriter.add(eElement);
			        eventWriter.add(end);
			    }	
}
