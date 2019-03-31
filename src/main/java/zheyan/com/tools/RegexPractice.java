package zheyan.com.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice {
    public static boolean isEmail(String target) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        return target.matches(regex);
    }

    public static boolean isNumberAtEnd(String target) {
        Pattern pattern = Pattern.compile("[0-9]+$");
        Matcher matcher = pattern.matcher(target);
        return matcher.find();
    }

    public static boolean containsAlice(String target) {
        Pattern pattern = Pattern.compile("[A|a][L|l][I|i][C|c][E|e]");
        Matcher matcher = pattern.matcher(target);
        return matcher.find();
    }

    public static boolean isPhoneNumber(String target) {
        Pattern pattern = Pattern.compile("^\\d{10}$|^(?:\\d{3}-){2}\\d{4}$|^\\(\\d{3}\\)\\d{3}-?\\d{4}$");
        Matcher matcher = pattern.matcher(target);
        return matcher.find();
    }

    public static boolean isFiveLetters(String target) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]{5}$");
        Matcher matcher = pattern.matcher(target);
        return matcher.find();
    }
}
