package model.entity;

public abstract class User {
    private int id;
    private String name;
    private String passWord;
    private static int count;
    private String type;
    private String phoneNumber;
    private String email;

    public User(int id, String name, String passWord, String type, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.passWord = passWord;
        this.type = type;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User(String name, String passWord, String type, String phoneNumber, String email) {
        this.name = name;
        this.passWord = passWord;
        this.type = type;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.id = ++count;
    }

    public User(String name, String passWord, String phoneNumber, String email) {
        this.name = name;
        this.passWord = passWord;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.id = ++count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract String toString();
}
