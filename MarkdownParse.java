//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        // minor change added
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            int lineBreak = markdown.indexOf("\n", openBracket);
            if(openBracket==-1 || closeBracket==-1 || 
                openParen==-1 || closeParen==-1){
                break;
            }
            if(closeBracket>lineBreak || 
            openParen>lineBreak || closeParen>lineBreak){
                currentIndex=closeParen+1;
                continue;
            }
            int save = closeBracket;
            while(save<lineBreak && save!=-1){
                closeBracket=save;
                save=markdown.indexOf("]", save+1);
            }save=closeParen;
            while(save<lineBreak && save!=-1){
                closeParen=save;
                save=markdown.indexOf(")", save+1);
            }
            if(openBracket!=0){
                String a=markdown.substring(openBracket-1,openBracket);
                if((closeBracket==openParen-1) && (a.equals("\n"))){
                    toReturn.add(markdown.substring(openParen + 1, closeParen));
                }
            }
            else{
                if(closeBracket==openParen-1){
                    toReturn.add(markdown.substring(openParen + 1, closeParen));
                }
            }
            currentIndex = closeParen + 1;
        }
        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
        System.out.print(fileName);
    }
}
