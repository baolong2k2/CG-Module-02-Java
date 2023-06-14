import java.util.Scanner;

/**
 *
 * @author Diep.Tran
 */
public class Book {
    String title, nickname, nxb, description;
    float price;

    public Book() {
    }

    public Book(String title, String nickname, String nxb, String description, float price) {
        this.title = title;
        this.nickname = nickname;
        this.nxb = nxb;
        this.description = description;
        this.price = price;
    }

    public void input() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter title: ");
        title = scan.nextLine();

        System.out.println("Enter nickname: ");
        nickname = scan.nextLine();

        System.out.println("Enter nha xuat ban: ");
        nxb = scan.nextLine();

        System.out.println("Enter description: ");
        description = scan.nextLine();

        System.out.println("Enter price: ");
        price = Float.parseFloat(scan.nextLine());
    }

    public String toXML() {
        return "		<book>\n" +
                "			<title>"+title+"</title>\n" +
                "			<nickname>"+nickname+"</nickname>\n" +
                "			<price>"+price+"</price>\n" +
                "			<nxb>"+nxb+"</nxb>\n" +
                "			<description>"+description+"</description>\n" +
                "		</book>\n";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", nickname=" + nickname + ", nxb=" + nxb + ", description=" + description + ", price=" + price + '}';
    }
}
