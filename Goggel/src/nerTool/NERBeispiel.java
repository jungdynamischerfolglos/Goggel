package nerTool;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.StringUtils;

public class NERBeispiel 
{
	public NERBeispiel( String extractedText)
	{
		Properties props = StringUtils.argsToProperties(
				new String[]{"-props", "StanfordCoreNLP-german.properties"});
	    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
	    
//	    String docString = " Zwei Gruppen gibt es. Zur ersten gehören Christian Lindner (FDP), Jürgen Trittin (Grüne) und Sigmar Gabriel (SPD). Sie waren oder sind die Treiber. "
//	    		+ "Lindner hat Jamaika platzen lassen, weil er das so wollte. Er hatte ein Ziel und die Ruchlosigkeit, es durchzusetzen, obwohl er von Hoffnungen auf Jamaika umgeben war. "
//	    		+ "Trittin hat Lindner die Vorlage gegeben, indem er mittels Interviews schlechte Stimmung verbreitete, und er wusste, was das bedeuten konnte. "
//	    		+ "Gabriel hat entschieden, dass eine Große Koalition für ihn richtig ist. Nun treibt er Martin Schulz vor sich her, untergräbt den Rest von dessen Autorität mit Kritik an seiner Führungsschwäche. "
//	    		+ "Zur zweiten Gruppe zählen Angela Merkel, Katrin Göring-Eckardt, Cem Özdemir und Martin Schulz. Sie waren bislang die Getriebenen. Alle vier haben es nicht geschafft, ihre Ziele durchzusetzen. "
//	    		+ "Merkel, Göring-Eckardt und Özdemir wollten Jamaika, Schulz wollte keine Gespräche über eine Große Koalition. "
//	    		+ "Was Lindner, Trittin und Gabriel verbindet, ist der dominante Charakter, sie können ruchlos und egozentrisch sein. Wenn's schweflig wird, fühlen sie sich jedenfalls nicht unwohl. "
//	    		+ "Merkel, Göring-Eckart, Özdemir und Schulz haben nicht diese dicken Egos, sie sind zurückhaltender, stärker auf Harmonie bedacht. Ihr Hauptnachteil war allerdings, dass sie andere brauchten, um ihre Ziele zu erreichen. "
//	    		+ "Zu den anderen gehörten aber die großen Egos, hier Lindner und Trittin, dort Gabriel. Lindner und Trittin sind aus dem Spiel, Merkel und Gabriel haben nun dasselbe Ziel, die Große Koalition. "
//	    		+ "Aber auch auf dem Weg dorthin wird noch Schwefel aufsteigen. Horst Seehofer übrigens ist einerseits dominant, hat sich bei den Sondierungsgesprächen aber konstruktiv verhalten, nicht egozentrisch. "
//	    		+ "Insofern steht er in der Mitte. Vom schlechten Wahlergebnis geschwächt, wird er bald wohl von Markus Söder aus dem Amt des Ministerpräsidenten gejagt werden, wie heute die \"Süddeutsche Zeitung\" andeutet. "
//	    		+ "Söder gehört eindeutig zum ersten Typus.";
//	    Annotation annotation = new Annotation(docString);
	    Annotation annotation = new Annotation(extractedText);
	    pipeline.annotate(annotation);
	    List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
	    ArrayList<String> locListe = new ArrayList<>();
	    ArrayList<String> perListe = new ArrayList<>();
	    ArrayList<String> orgListe = new ArrayList<>();
	    for (CoreMap sentence : sentences) 
	    {
	        List<CoreLabel> tokens = sentence.get(CoreAnnotations.TokensAnnotation.class);
	        for (CoreLabel token : tokens) 
	        {
	        	if (!token.get(CoreAnnotations.NamedEntityTagAnnotation.class).equals("O") && 
	        			token.get(CoreAnnotations.NamedEntityTagAnnotation.class).equals("I-LOC")) 
	        	{
					locListe.add(token.word());
				}
	        	if (!token.get(CoreAnnotations.NamedEntityTagAnnotation.class).equals("O") && 
	        			token.get(CoreAnnotations.NamedEntityTagAnnotation.class).equals("I-PER")) 
	        	{
					perListe.add(token.word());
				}
	        	if (!token.get(CoreAnnotations.NamedEntityTagAnnotation.class).equals("O") && 
	        			token.get(CoreAnnotations.NamedEntityTagAnnotation.class).equals("I-ORG")) 
	        	{
					orgListe.add(token.word());
				}
//	            System.out.println(token.word()+" "+token.get(CoreAnnotations.NamedEntityTagAnnotation.class));
	        }
	    }
	    
	    for (String element : locListe) 
	    {
	    	System.out.println("I-LOC" + ": " + element);
		}
	    for (String element : perListe) 
	    {
	    	System.out.println("I-PER" + ": " + element);
		}
	    for (String element : orgListe) 
	    {
	    	System.out.println("I-ORG" + ": " + element);
		}
	}
}
