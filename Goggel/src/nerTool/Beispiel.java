package nerTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.StringUtils;

public class Beispiel 
{
	public static void main(String[] args) 
	{
//		Properties props = new Properties();
//        props.setProperty("annotators",
//            "tokenize, ssplit, pos, lemma, ner");
//        props.setProperty("tokenize.whitespace", "true");
		Properties props = StringUtils.argsToProperties(
				new String[]{"-props", "StanfordCoreNLP-german.properties"});
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
//        String [] tokensArray = {"Stephen","Colbert","hosts","a","show","on","CBS","."};
//        String [] tokensArray = {"Thomas","Tyrach","publiziert","seine","Seminararbeit","bei","Siemens","."};
//        List<String> tokensList = Arrays.asList(tokensArray);
//        String docString = String.join(" ",tokensList);
        String docString = " Zwei Gruppen gibt es. Zur ersten geh�ren Christian Lindner (FDP), J�rgen Trittin (Gr�ne) und Sigmar Gabriel (SPD). Sie waren oder sind die Treiber. "
        		+ "Lindner hat Jamaika platzen lassen, weil er das so wollte. Er hatte ein Ziel und die Ruchlosigkeit, es durchzusetzen, obwohl er von Hoffnungen auf Jamaika umgeben war. "
        		+ "Trittin hat Lindner die Vorlage gegeben, indem er mittels Interviews schlechte Stimmung verbreitete, und er wusste, was das bedeuten konnte. "
        		+ "Gabriel hat entschieden, dass eine Gro�e Koalition f�r ihn richtig ist. Nun treibt er Martin Schulz vor sich her, untergr�bt den Rest von dessen Autorit�t mit Kritik an seiner F�hrungsschw�che. "
        		+ "Zur zweiten Gruppe z�hlen Angela Merkel, Katrin G�ring-Eckardt, Cem �zdemir und Martin Schulz. Sie waren bislang die Getriebenen. Alle vier haben es nicht geschafft, ihre Ziele durchzusetzen. "
        		+ "Merkel, G�ring-Eckardt und �zdemir wollten Jamaika, Schulz wollte keine Gespr�che �ber eine Gro�e Koalition. "
        		+ "Was Lindner, Trittin und Gabriel verbindet, ist der dominante Charakter, sie k�nnen ruchlos und egozentrisch sein. Wenn's schweflig wird, f�hlen sie sich jedenfalls nicht unwohl. "
        		+ "Merkel, G�ring-Eckart, �zdemir und Schulz haben nicht diese dicken Egos, sie sind zur�ckhaltender, st�rker auf Harmonie bedacht. Ihr Hauptnachteil war allerdings, dass sie andere brauchten, um ihre Ziele zu erreichen. "
        		+ "Zu den anderen geh�rten aber die gro�en Egos, hier Lindner und Trittin, dort Gabriel. Lindner und Trittin sind aus dem Spiel, Merkel und Gabriel haben nun dasselbe Ziel, die Gro�e Koalition. "
        		+ "Aber auch auf dem Weg dorthin wird noch Schwefel aufsteigen. Horst Seehofer �brigens ist einerseits dominant, hat sich bei den Sondierungsgespr�chen aber konstruktiv verhalten, nicht egozentrisch. "
        		+ "Insofern steht er in der Mitte. Vom schlechten Wahlergebnis geschw�cht, wird er bald wohl von Markus S�der aus dem Amt des Ministerpr�sidenten gejagt werden, wie heute die \"S�ddeutsche Zeitung\" andeutet. "
        		+ "S�der geh�rt eindeutig zum ersten Typus.";
        Annotation annotation = new Annotation(docString);
        pipeline.annotate(annotation);
        List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
        ArrayList<String> liste = new ArrayList<>();
        for (CoreMap sentence : sentences) 
        {
            List<CoreLabel> tokens = sentence.get(CoreAnnotations.TokensAnnotation.class);
            for (CoreLabel token : tokens) 
            {
            	if (!token.get(CoreAnnotations.NamedEntityTagAnnotation.class).equals("O") && 
            			token.get(CoreAnnotations.NamedEntityTagAnnotation.class).equals("I-LOC")) 
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
