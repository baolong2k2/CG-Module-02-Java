package model.factory;

import model.entity.Customer;
import model.entity.Scientist;
import model.entity.User;

//SINGLETON
public class UserFactory {
    private static final UserFactory userFactory = new UserFactory();

    private UserFactory() {
    } //Singleton để private trong constructor vì nếu để public sẽ bị tạo đối tượng dư thừa và lung tung

    public static UserFactory getInstance() {
        return userFactory;
    } //Muốn gọi đến phương thức trong class này thì phải gọi thông qua getInstance
    // phải để static vì nếu ko có thì bên ngoài sẽ ko đc truy cập vào
    //getInstance trả về đối tượng duy nhất


    //FACTORY
    public User getUser(String name, String passWord, String type, String phoneNumber, String email) {
        if (type.equalsIgnoreCase("SCIENTIST")) {
            return new Scientist(name, passWord, type, phoneNumber, email);
        } else if (type.equalsIgnoreCase("CUSTOMER")) {
            return new Customer(name, passWord, type, phoneNumber, email);
        }
        return null;
    }
    public User getUser(String name, String passWord, String type, String phoneNumber, String email,String rank,String permision) {
        if (type.equalsIgnoreCase("SCIENTIST")) {
            return new Scientist(name, passWord, type, phoneNumber, email,rank,permision);
        } else if (type.equalsIgnoreCase("CUSTOMER")) {
            return new Customer(name, passWord, type, phoneNumber, email);
        }
        return null;
    }
}




