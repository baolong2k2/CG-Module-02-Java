public class Main {
    private static PhoneNumber phoneNumber;
    public static final String [] isphoneNumber = new String[] {"(84)-(912311625)", "(a8)-(912311625)", "((84)-(912311625)"};

    public static void main(String[] args) {
        phoneNumber = new PhoneNumber();

        for (String phone : isphoneNumber) {
            boolean isvalid = phoneNumber.validate(phone);
            System.out.println("Phone Number is " + phone + " is valid: " + isvalid);
        }
    }
}