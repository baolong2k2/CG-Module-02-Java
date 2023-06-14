import java.util.Scanner;

/**
 *
 * @author Diep.Tran
 */
public class Author {
    String nickname, fullname, email, address, birthday;

    public Author() {
    }

    public Author(String nickname, String fullname, String email, String address, String birthday) {
        this.nickname = nickname;
        this.fullname = fullname;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
    }

    public void input() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter nickname: ");
        nickname = scan.nextLine();

        System.out.println("Enter fullname: ");
        fullname = scan.nextLine();

        System.out.println("Enter email: ");
        email = scan.nextLine();

        System.out.println("Enter address: ");
        address = scan.nextLine();

        System.out.println("Enter birthday (dd/mm/yyyy): ");
        birthday = scan.nextLine();
    }

    public String toXML() {
        return "		<author>\n" +
                "			<nickname>"+nickname+"</nickname>\n" +
                "			<fullname>"+fullname+"</fullname>\n" +
                "			<email>"+email+"</email>\n" +
                "			<address>"+address+"</address>\n" +
                "			<birthday>"+birthday+"</birthday>\n" +
                "		</author>\n";
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Author{" + "nickname=" + nickname + ", fullname=" + fullname + ", email=" + email + ", address=" + address + ", birthday=" + birthday + '}';
    }
}
