import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    public static final String PHONENUMBER_REGEX = "^[(]{1}\\d{2}[)]{1}[-]{1}[(]{1}\\d{9}[)]{1}$";
    private static Pattern pattern;
    private Matcher matcher;

    public PhoneNumber() {
        pattern = pattern.compile(PHONENUMBER_REGEX);
    }

    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
