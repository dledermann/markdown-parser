//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;

public class MarkdownParse {

    public ArrayList<String> getLinks(String markdown) {
        Parser parser = Parser.builder().build();
        Node node = parser.parse(markdown);
        WordCountVisitor visitor = new WordCountVisitor();
        node.accept(visitor);
        return visitor.Links;
    }
    class WordCountVisitor extends AbstractVisitor {
        ArrayList<String> Links = new ArrayList<>();

        @Override
        public void visit(Link link) {
            // This is called for all Text nodes. Override other visit methods for other node types.

            // Count words (this is just an example, don't actually do it this way for various reasons).
            Links.add(link.getDestination());
            

            // Descend into children (could be omitted in this case because Text nodes don't have children).
            visitChildren(link);
        }
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        MarkdownParse test=new MarkdownParse();
        ArrayList<String> links = test.getLinks(content);
	    System.out.println(links);
        System.out.print(fileName);
    }
}
