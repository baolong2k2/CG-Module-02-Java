package Entity;

public class User {
    private final long id;
    private String userName;
    private String passWord;
    private String phone;
    private Address address;
    private static long count = 0;

    public User (String userName, String passWord, String phone, Address address){
        this.id = ++count;
        this.userName = userName;
        this.passWord = passWord;
        this.phone = phone;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static long getCount() {
        return count;
    }

    public static void setCount(long count) {
        User.count = count;
    }

    @Override
    public String toString(){
        return "Id: " + getId() + "\nUsername: " + getUserName() + "\nPassword: " + getPassWord() + "\nPhone Number: " + getPhone() + "\nAddress: " + getAddress();
    }
}
