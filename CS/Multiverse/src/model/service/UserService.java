package model.service;

import model.entity.Customer;
import model.entity.Scientist;
import model.entity.User;
import model.exception.InvalidAccountException;
import model.exception.InvalidChoiceException;
import model.factory.UserFactory;
import model.ulti.FileReaderUtils;
import model.ulti.Input;
import model.ulti.WriteFileUlti;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static final UserService userService = new UserService();
    private boolean checkCustomer = false;
    private boolean checkScientist = false;

    private UserService() {
    }

    public static UserService getInstance() {
        return userService;
    }

    private static final List<Customer> CUSTOMER_LIST = new ArrayList<>();
    private static final List<Scientist> SCIENTIST_LIST = new ArrayList<>();
    private static final List<User> USER_LIST = new ArrayList<>();
    private static User currentUser;

    static {
        List<Customer> customerList = FileReaderUtils.fileReadingCustomer("src/model/data/customer.csv");
        CUSTOMER_LIST.addAll(customerList);
        List<Scientist> scientistList = FileReaderUtils.fileReadingScientist("src/model/data/scientist.csv");
        SCIENTIST_LIST.addAll(scientistList);
        USER_LIST.addAll(SCIENTIST_LIST);
        USER_LIST.addAll(CUSTOMER_LIST);
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public List<Customer> getCustomerList() {
        return CUSTOMER_LIST;
    }

    public List<Scientist> getScientistList() {
        return SCIENTIST_LIST;
    }

    public boolean isCheckCustomer() {
        return checkCustomer;
    }

    public boolean isCheckScientist() {
        return checkScientist;
    }

    public void logIn() {
        do {
            try {
                String userName = Input.prompt("Nhập tài khoản: ");
                String passWord = Input.prompt("Nhập mật khẩu: ");
                String logIn = Input.prompt("Xác nhận đăng nhập (Y/N): ");
                if (logIn.equalsIgnoreCase("Y")) {
                    for (User user : USER_LIST) {
                        if (userName.equals(user.getName())) {
                            for (Customer customer : CUSTOMER_LIST) {
                                if (userName.equals(customer.getName())) {
                                    if (passWord.equals(customer.getPassWord())) {
                                        System.out.println("Đăng nhập thành công! Chào mừng khách hàng: " + userName + " trở lại ");
                                        currentUser = customer;
                                        checkCustomer = true;
                                        return;
                                    }
                                }
                            }
                            for (Scientist scientist : SCIENTIST_LIST) {
                                if (userName.equals(scientist.getName())) {
                                    if (passWord.equals(scientist.getPassWord())) {
                                        System.out.println(" SUCCESSFUL ! WELCOME SCIENTIST: " + userName + " COMEBACK");
                                        currentUser = scientist;
                                        checkScientist = true;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    throw new InvalidAccountException(" Incorrect account or password ");
                } else return;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }

    public void register() {
        System.out.println("""
                (1) SCIENTIST ??? 🧐
                (2) USER ??? 😘
                (3) BACK TO MENU ↩
                """);
        int choice = Input.choiceIntegerInput(" \uD83D\uDD2ABE SMART TO CHOICE\uD83D\uDD2A ");
        do {
            try {
                User newUser;
                switch (choice) {

                    case 1:
                        String scientistName = Input.prompt("Enter name: ");
                        boolean checkExistScientist = false;
                        for (User user : SCIENTIST_LIST) {
                            if (scientistName.equals(user.getName())) {
                                checkExistScientist = true;
                                break;
                            }
                        }
                        if (checkExistScientist) {
                            throw new InvalidAccountException("This account has been exist");
                        } else {
                            String passWord = Input.prompt("Enter a passWord(Prove you're worth it): ", "PASSWORD");
                            String phoneNumber = Input.prompt("Enter a phone number: ", "PHONE_NUMBER");
                            String email = Input.prompt("Enter email: ", "EMAIL");
                            String rank = Input.prompt("Enter your rank(NEWBIE JUST TIGER): ");
                            String permission = Input.prompt("Enter your permission(NEWBIE JUST B): ");
                            UserFactory userFactory = UserFactory.getInstance();
                            newUser = userFactory.getUser(scientistName, passWord, "Scientist", phoneNumber, email, rank, permission);
                            WriteFileUlti.writeFileScientist("src\\model\\data\\scientist.csv", (Scientist) newUser); //ép kiểu
                            SCIENTIST_LIST.add((Scientist) newUser);
                            USER_LIST.add(newUser);
                            System.out.println("CONGRATULATION YOU ARE A PART OF US NOW!");
                        }
                        return;

                    case 2:
                        String userName = Input.prompt("Enter name: ");
                        boolean checkExistUser = false;
                        for (User user : CUSTOMER_LIST) {
                            if (userName.equals(user.getName())) {
                                checkExistUser = true;
                                break;
                            }
                        }
                        if (checkExistUser) {
                            throw new InvalidAccountException("This account has been exist");
                        } else {
                            String passWord = Input.prompt("Enter a passWord(Prove you're worth it): ", "PASSWORD");
                            String phoneNumber = Input.prompt("Enter a phone number: (+840xxxx hoặc 0xxxx,10 chữ số) ", "PHONE_NUMBER");
                            String email = Input.prompt("Enter Email: ", "EMAIL");
                            UserFactory userFactory = UserFactory.getInstance();
                            newUser = userFactory.getUser(userName, passWord, "Customer", phoneNumber, email);
                            WriteFileUlti.writeFileUser("src\\model\\data\\customer.csv", newUser);
                            CUSTOMER_LIST.add((Customer) newUser);
                            USER_LIST.add(newUser);
                            System.out.println("\uD83C\uDFE9WELCOME TO OUR HOME\uD83C\uDFE9");
                        }
                        return;

                    case 3:
                        return;

                    default:
                        throw new InvalidChoiceException("Please re-enter! ");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }

    public User getScientistById(int indexOfScientistId) {
        for (User user : SCIENTIST_LIST) {
            if (user.getId() == indexOfScientistId) {
                return user;
            }
        }
        return null;
    }
    public User getCustomerById(int indexOfCustomerId) {
        for (User user : CUSTOMER_LIST) {
            if (user.getId() == indexOfCustomerId) {
                return user;
            }
        }
        return null;
    }
}
