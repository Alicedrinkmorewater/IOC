package zheyan.com;

import org.junit.Assert;
import org.junit.Test;
import zheyan.com.tools.RegexPractice;

public class TestRegexPractice {
    @Test
    public void testIsEmail() {
        RegexPractice regexPractice = new RegexPractice();

        Assert.assertTrue(regexPractice.isEmail("alice@amazon.com"));
        Assert.assertTrue(regexPractice.isEmail("alice123@syr.com"));
        Assert.assertTrue(regexPractice.isEmail("ali_+000ce@yahoo.com"));

        Assert.assertFalse(regexPractice.isEmail("alice@amazon..com"));
        Assert.assertFalse(regexPractice.isEmail("alice_amazon.com"));
        Assert.assertFalse(regexPractice.isEmail("alice@amazon.com0000com"));
        Assert.assertFalse(regexPractice.isEmail("alice@amazon.co+m"));
        Assert.assertFalse(regexPractice.isEmail("alice@amaz_on.com"));
    }

    @Test
    public void testIsNumberAtEnd() {
        RegexPractice regexPractice = new RegexPractice();

        Assert.assertTrue(regexPractice.isNumberAtEnd("alice@amazon.com00000"));
        Assert.assertTrue(regexPractice.isNumberAtEnd("alice12alice3@syr.com3"));
        Assert.assertTrue(regexPractice.isNumberAtEnd("ali_+000ce@yahoo.com1"));

        Assert.assertFalse(regexPractice.isNumberAtEnd("alice@amazon..com."));
        Assert.assertFalse(regexPractice.isNumberAtEnd("alice_amazon.com"));
        Assert.assertFalse(regexPractice.isNumberAtEnd("alice@amazon.com0000com"));
        Assert.assertFalse(regexPractice.isNumberAtEnd("alice@amazon.co+m"));
        Assert.assertFalse(regexPractice.isNumberAtEnd("alice@amaz_on.com"));
    }

    @Test
    public void testContainsAlice() {
        RegexPractice regexPractice = new RegexPractice();

        Assert.assertTrue(regexPractice.containsAlice("alice@amazon.com00000"));
        Assert.assertTrue(regexPractice.containsAlice("alIce12alice3@syr.com3"));
        Assert.assertTrue(regexPractice.containsAlice("aliCE+000ce@yahoo.com1"));

        Assert.assertFalse(regexPractice.containsAlice("al ice@amazon..com."));
        Assert.assertFalse(regexPractice.containsAlice("alicce_amazon.com"));
        Assert.assertFalse(regexPractice.containsAlice("AAlLice@amazon.com0000com"));
        Assert.assertFalse(regexPractice.containsAlice("al(i)ce@amazon.co+m"));
        Assert.assertFalse(regexPractice.containsAlice("a+lice@amaz_on.com"));
    }

    @Test
    public void testIsPhoneNumber() {
        RegexPractice regexPractice = new RegexPractice();

        Assert.assertTrue(regexPractice.isPhoneNumber("1234567890"));
        Assert.assertTrue(regexPractice.isPhoneNumber("123-456-7890"));
        Assert.assertTrue(regexPractice.isPhoneNumber("(123)456-7890"));
        Assert.assertTrue(regexPractice.isPhoneNumber("(123)4567890"));

        Assert.assertFalse(regexPractice.isPhoneNumber("12345678901"));
        Assert.assertFalse(regexPractice.isPhoneNumber("12-34567890"));
        Assert.assertFalse(regexPractice.isPhoneNumber("(1234)567890"));
        Assert.assertFalse(regexPractice.isPhoneNumber("123456-7890"));
    }

    @Test
    public void testIsFiveLetters() {
        RegexPractice regexPractice = new RegexPractice();

        Assert.assertTrue(regexPractice.isFiveLetters("ASXDC"));
        Assert.assertTrue(regexPractice.isFiveLetters("lSSSS"));
        Assert.assertTrue(regexPractice.isFiveLetters("aaaaa"));
        Assert.assertTrue(regexPractice.isFiveLetters("ASlDC"));

        Assert.assertFalse(regexPractice.isFiveLetters(")SXDC"));
        Assert.assertFalse(regexPractice.isFiveLetters("AS XDC"));
        Assert.assertFalse(regexPractice.isFiveLetters("ASGXDC"));
        Assert.assertFalse(regexPractice.isFiveLetters("ASX4DC"));
    }
}
