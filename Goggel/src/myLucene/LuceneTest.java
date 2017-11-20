package myLucene;

import java.io.*;
import org.apache.lucene.document.*;
import org.apache.lucene.store.*;
import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.standard.*;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.queryparser.classic.*;

public class LuceneTest {

  public static void main(String[] args) throws Exception {
    Document document = new Document();
    String text = "This is a lucene test";
    document.add(new TextField("title", "Title 1", Field.Store.YES));
    document.add(new TextField("content", text, Field.Store.NO));

    NIOFSDirectory indexDir = new NIOFSDirectory(new File("testIndexDir").toPath()); 
    Analyzer analyzer = new StandardAnalyzer(); // analyzer formatiert den Text
    IndexWriter writer = new IndexWriter(indexDir, new IndexWriterConfig(analyzer));
    writer.addDocument(document);
    writer.close();
    
    DirectoryReader dr = DirectoryReader.open(indexDir);
    IndexSearcher searcher = new IndexSearcher(dr);
    QueryParser qp = new QueryParser("content",analyzer); // content = Suchfeld
    String search = "lucene"; // lucene = Suchtext
    Query query = qp.parse(search);

    TopDocs td = searcher.search(query,10);
    ScoreDoc[] sd = td.scoreDocs;
    for (int i=0; i < sd.length; i++) {
        Document doc = searcher.doc(sd[i].doc);
        System.out.println(doc.get("title"));
    }
    
    /*
    TopScoreDocCollector collector = TopScoreDocCollector.create(10, true);
    searcher.search(query, collector);
    ScoreDoc[] hits = collector.topDocs().scoreDocs;

    for(int i=0;i<hits.length;++i) {
      int docId = hits[i].doc;
      Document d = searcher.doc(docId);
      System.out.println(d.get("title"));
    }
    */
    System.out.println("done");
  }
}
