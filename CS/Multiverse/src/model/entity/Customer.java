package model.entity;

public class Customer extends User{

    public Customer(int id, String name, String passWord, String type, String phoneNumber, String email) {
        super(id, name, passWord, type, phoneNumber, email);
    }

    public Customer(String name, String passWord, String type, String phoneNumber, String email) {
        super(name, passWord, type, phoneNumber, email);
    }

    public Customer(String name, String phoneNumber, String email, String passWord) {
        super(name, phoneNumber, email, passWord);
        this.setType("CUSTOMER");
    }


    @Override
    public String toString() {
        return String.format("""
                Khách hàng: %s
                SĐT: %s
                Email: %s
                """, getName(), getPhoneNumber(), getEmail());
    }
}
