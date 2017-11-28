package nerTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.util.CoreMap;

public class Beispiel 
{
	public static void main(String[] args) 
	{
		Properties props = new Properties();
        props.setProperty("annotators",
            "tokenize, ssplit, pos, lemma, ner");
        props.setProperty("tokenize.whitespace", "true");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
//        String [] tokensArray = {"Stephen","Colbert","hosts","a","show","on","CBS","."};
        String [] tokensArray = {"Thomas","Tyrach","publiziert","seine","Seminararbeit","bei","Siemens","."};
        List<String> tokensList = Arrays.asList(tokensArray);
        String docString = String.join(" ",tokensList);
        Annotation annotation = new Annotation(docString);
        pipeline.annotate(annotation);
        List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
        ArrayList<String> liste = new ArrayList<>();
        for (CoreMap sentence : sentences) 
        {
            List<CoreLabel> tokens = sentence.get(CoreAnnotations.TokensAnnotation.class);
            for (CoreLabel token : tokens) 
            {
            	if (!token.get(CoreAnnotations.NamedEntityTagAnnotation.class).equals("O")) 
            	{
					liste.add(token.word());
				}
                System.out.println(token.word()+" "+token.get(CoreAnnotations.NamedEntityTagAnnotation.class));
            }
        }
        for (String element : liste) 
        {
        	System.out.println(element);
		}
		
	}

}
