import java.util.ArrayList;

import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

class TryCommonMark {
    public static void main(String[] args) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(" [link](/uri)");
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        System.out.println(renderer.render(document));  // "<p>This is <em>Sparta</em></p>\n"
        Node node = parser.parse("[link](/uri title)");
        WordCountVisitor visitor = new WordCountVisitor();
        node.accept(visitor);
        System.out.println(visitor.Links);  // 4
    }
    
    

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