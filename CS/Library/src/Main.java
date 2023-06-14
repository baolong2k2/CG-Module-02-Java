import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Diep.Tran
 */
public class Main {
    static List<Author> authors = new ArrayList<>();
    static List<Book> books = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int choose;

        do {
            showMenu();
            choose = Integer.parseInt(scan.nextLine());

            switch(choose) {
                case 1:
                    inputAuthor();
                    break;
                case 2:
                    inputBook();
                    break;
                case 3:
                    displayBook();
                    break;
                case 4:
                    saveFile();
                    break;
                case 5:
                    readFile();
                    break;
                case 6:
                    System.out.println("Goodbye!!!");
                    break;
                default:
                    System.out.println("Input failed!!!");
                    break;
            }
        } while(choose != 6);
    }

    static void showMenu() {
        System.out.println("1. Input author");
        System.out.println("2. Input book");
        System.out.println("3. Display book");
        System.out.println("4. Save library.xml");
        System.out.println("5. Read library.xml");
        System.out.println("6. Exit");
        System.out.println("Choose: ");
    }

    private static void inputAuthor() {
        System.out.println("Enter (N) author: ");
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            Author author = new Author();
            author.input();

            authors.add(author);
        }
    }

    private static void inputBook() {
        System.out.println("Enter (N) book: ");
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            Book book = new Book();
            book.input();

            books.add(book);
        }
    }

    private static void displayBook() {
        books.forEach((book) -> {
            System.out.println(book);
        });
    }

    private static void saveFile() {
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("library.xml");

            String authorList = "";
            for (Author author : authors) {
                authorList += author.toXML();
            }

            String bookList = "";
            for (Book book : books) {
                bookList += book.toXML();
            }

            String content = toXML(authorList, bookList);

            byte[] data = content.getBytes("utf8");

            fos.write(data);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private static String toXML(String authorList, String bookList) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "\n" +
                "<library>\n" +
                "	<author-list>\n" +
                "\n" + authorList +
                "	</author-list>\n" +
                "	<book-list>\n" +
                "		\n" + bookList +
                "	</book-list>\n" +
                "</library>";
    }

    private static void readFile() {
        try {
            File file = new File("library.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            LibraryParser libraryParser = new LibraryParser();
            parser.parse(file, libraryParser);

            authors = libraryParser.authorList;
            books = libraryParser.bookList;

            displayBook();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}