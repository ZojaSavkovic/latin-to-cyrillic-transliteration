package lettersProject;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JekyllMarkdownTransliterator {

    public static void main(String[] args) throws IOException {	       	
    	String hrFileName = getHrFileName();
        String fileText = new String(Files.readAllBytes(Paths.get(hrFileName)));
                
        //TODO: don't transliterate anything:
        // - for the included images in the markdown, except for the image alternative text
        // - in the Jekyll "Front Matter" (YAML set between triple-dashed lines) except for:
        // -- do transliterate the heading
        // -- change the language variable to "sr" for the transliterated file
                
        String outText = transliterate(fileText);
    
        String srFileName = hrFileName.replace("-hr-", "-sr-");
        PrintWriter writer = new PrintWriter(srFileName, "UTF-8");
        writer.println(outText);
        writer.close();
                
        System.out.println("End");     
    }
	    
    private static String getHrFileName() {
        File curDir = new File(".");
        File[] filesList = curDir.listFiles();
        for(File f : filesList){
            if(f.isFile() && f.toString().substring(2).contains("-hr-")){
                System.out.println(f.getName());
                return f.getName();
            }
        }
        return "none";
	}

	private static String transliterate(String inText){  
    	// 2 letters that map to 1 letter, need to be mapped first: 	
    	String outText = inText.replace("Dž", "Џ");
    	outText = outText.replace("dž", "џ");
    	
    	outText = outText.replace("Lj", "Љ");
    	outText = outText.replace("lj", "љ");
    	
    	outText = outText.replace("Nj", "Њ");
    	outText = outText.replace("nj", "њ");
    		    
    	// 1 letter maps to 1 letter
    	outText = outText.replace("B", "Б");
    	outText = outText.replace("b", "б");
    	
    	outText = outText.replace("C", "Ц");
    	outText = outText.replace("c", "ц");
    	
    	outText = outText.replace("Č", "Ч");
    	outText = outText.replace("č", "ч");
    	
    	outText = outText.replace("Ć", "Ћ");
    	outText = outText.replace("ć", "ћ");
    	
    	outText = outText.replace("D", "Д");
    	outText = outText.replace("d", "д");
    	
    	outText = outText.replace("Đ", "Ђ");
    	outText = outText.replace("đ", "ђ");
    	
    	outText = outText.replace("F", "Ф");
    	outText = outText.replace("f", "ф");
    	
    	outText = outText.replace("G", "Г");
    	outText = outText.replace("g", "г");
    		    	
    	outText = outText.replace("H", "Х");
    	outText = outText.replace("h", "х");
    		    	
    	outText = outText.replace("I", "И");
    	outText = outText.replace("i", "и");
    		    	
    	outText = outText.replace("L", "Л");
    	outText = outText.replace("l", "л");
    		    	
    	outText = outText.replace("N", "Н");
    	outText = outText.replace("n", "н");
    		    	
    	outText = outText.replace("P", "П");
    	outText = outText.replace("p", "п");
    	
    	outText = outText.replace("R", "Р");
    	outText = outText.replace("r", "р");
    	
    	outText = outText.replace("S", "С");
    	outText = outText.replace("s", "с");
    	
    	outText = outText.replace("Š", "Ш");
    	outText = outText.replace("š", "ш");
    	
    	outText = outText.replace("U", "У");
    	outText = outText.replace("u", "у");
    	
    	outText = outText.replace("V", "В");
    	outText = outText.replace("v", "в");
    	
    	outText = outText.replace("Z", "З");
    	outText = outText.replace("z", "з");
    	
    	outText = outText.replace("Ž", "Ж");
    	outText = outText.replace("ž", "ж");
    	    	
    	// 1 letter maps to 1 letter - tiny difference in character
    	outText = outText.replace("K", "К");
    	outText = outText.replace("k", "к");
    	
    	outText = outText.replace("M", "М");
    	outText = outText.replace("m", "м");
    	
    	outText = outText.replace("T", "Т");
    	outText = outText.replace("t", "т");
    	
    	// No change for: Letters that are completely the same in both alphabets:
    	// A, a, E, e, J, j, O, o

    	return outText;
    }
}