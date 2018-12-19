package lettersProject;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JekyllMarkdownTransliterator {

    public static void main(String[] args) throws IOException {	        	                
        String fileText;
        fileText = new String(Files.readAllBytes(Paths.get("hr-file.md")));

        //TODO: don't transliterate anything:
        // - for the included images in the markdown, except for the image alternative text
        // - in the Jekyll "Front Matter" (YAML set between triple-dashed lines) except for:
        // -- do transliterate the heading
        // -- change the language variable to "sr" for the transliterated file
                
        String outText = transliterate(fileText);
    
        PrintWriter writer = new PrintWriter("sr-file.md", "UTF-8");
        writer.println(outText);
        writer.close();
                
        System.out.println("End");     
    }
	    
    private static String transliterate(String inText){
        
    	// 2 letters that map to 1 letter, need to be mapped first: 	
    	String outText = inText.replace("Dž", "?");
    	outText = outText.replace("dž", "?");
    	
    	outText = outText.replace("Lj", "?");
    	outText = outText.replace("lj", "?");
    	
    	outText = outText.replace("Nj", "?");
    	outText = outText.replace("nj", "?");
    		    
    	// 1 letter maps to 1 letter
    	outText = outText.replace("B", "?");
    	outText = outText.replace("b", "?");
    	
    	outText = outText.replace("C", "?");
    	outText = outText.replace("c", "?");
    	
    	outText = outText.replace("C", "?");
    	outText = outText.replace("c", "?");
    	
    	outText = outText.replace("C", "?");
    	outText = outText.replace("c", "?");
    	
    	outText = outText.replace("D", "?");
    	outText = outText.replace("d", "?");
    	
    	outText = outText.replace("Ð", "?");
    	outText = outText.replace("d", "?");
    	
    	outText = outText.replace("F", "?");
    	outText = outText.replace("f", "?");
    	
    	outText = outText.replace("G", "?");
    	outText = outText.replace("g", "?");
    		    	
    	outText = outText.replace("H", "?");
    	outText = outText.replace("h", "?");
    		    	
    	outText = outText.replace("I", "?");
    	outText = outText.replace("i", "?");
    		    	
    	outText = outText.replace("L", "?");
    	outText = outText.replace("l", "?");
    		    	
    	outText = outText.replace("N", "?");
    	outText = outText.replace("n", "?");
    		    	
    	outText = outText.replace("P", "?");
    	outText = outText.replace("p", "?");
    	
    	outText = outText.replace("R", "?");
    	outText = outText.replace("r", "?");
    	
    	outText = outText.replace("S", "?");
    	outText = outText.replace("s", "?");
    	
    	outText = outText.replace("Š", "?");
    	outText = outText.replace("š", "?");
    	
    	outText = outText.replace("U", "?");
    	outText = outText.replace("u", "?");
    	
    	outText = outText.replace("V", "?");
    	outText = outText.replace("v", "?");
    	
    	outText = outText.replace("Z", "?");
    	outText = outText.replace("z", "?");
    	
    	outText = outText.replace("Ž", "?");
    	outText = outText.replace("ž", "?");
    	    	
    	// 1 letter maps to 1 letter - tiny difference in character
    	outText = outText.replace("K", "?");
    	outText = outText.replace("k", "?");
    	
    	outText = outText.replace("M", "?");
    	outText = outText.replace("m", "?");
    	
    	outText = outText.replace("T", "?");
    	outText = outText.replace("t", "?");
    	
    	// No change for: Letters that are completely the same in both alphabets:
    	// A, a, E, e, J, j, O, o
    	
    	System.out.printf("%s\n",outText);
    	return outText;
    }
}


