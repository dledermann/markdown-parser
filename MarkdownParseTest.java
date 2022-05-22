import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void testFile() throws IOException {
        ArrayList<String> test= new ArrayList<>();
        test.add("https://something.com");
        test.add("some-thing.html");
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        assertEquals(test, MarkdownParse.getLinks(content));
    }
    @Test
    public void testFile2() throws IOException {
        ArrayList<String> test= new ArrayList<>();
        test.add("https://something.com");
        test.add("some-page.html");
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        assertEquals(test, MarkdownParse.getLinks(content));
    }
    @Test
    public void testFile3() throws IOException {
        ArrayList<String> test= new ArrayList<>();
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        assertEquals(test, MarkdownParse.getLinks(content));
    }
    @Test
    public void testFile4() throws IOException {
        ArrayList<String> test= new ArrayList<>();
        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);
        assertEquals(test, MarkdownParse.getLinks(content));
    }

    @Test
    public void testFile5() throws IOException {
        ArrayList<String> test= new ArrayList<>();
        Path fileName = Path.of("test-file5.md");
        String content = Files.readString(fileName);
        assertEquals(test, MarkdownParse.getLinks(content));
    }
    @Test
    public void testFile6() throws IOException {
        ArrayList<String> test= new ArrayList<>();
        Path fileName = Path.of("test-file6.md");
        String content = Files.readString(fileName);
        assertEquals(test, MarkdownParse.getLinks(content));
    }
    @Test
    public void testFile7() throws IOException {
        ArrayList<String> test= new ArrayList<>();
        Path fileName = Path.of("test-file7.md");
        String content = Files.readString(fileName);
        assertEquals(test, MarkdownParse.getLinks(content));
    }
    @Test
    public void testFile8() throws IOException {
        ArrayList<String> test= new ArrayList<>();
        test.add("a link on the first line");
        Path fileName = Path.of("test-file8.md");
        String content = Files.readString(fileName);
        assertEquals(test, MarkdownParse.getLinks(content));
    }
    @Test
    public void testSnippet1() throws IOException{
        ArrayList<String> test= new ArrayList<>();
        test.add("`google.com");
        test.add("google.com");
        test.add("ucsd.edu");
        Path fileName = Path.of("snippet1.md");
        String content = Files.readString(fileName);
        assertEquals(test, MarkdownParse.getLinks(content));
    }
    @Test
    public void testSnippet2() throws IOException{
        ArrayList<String> test= new ArrayList<>();
        test.add("a.com");
        test.add("a.com(())");
        test.add("example.com");
        Path fileName = Path.of("snippet2.md");
        String content = Files.readString(fileName);
        assertEquals(test, MarkdownParse.getLinks(content));
    }
    @Test
    public void testSnippet3() throws IOException{
        ArrayList<String> test= new ArrayList<>();
        test.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        Path fileName = Path.of("snippet3.md");
        String content = Files.readString(fileName);
        assertEquals(test, MarkdownParse.getLinks(content));
    }
}