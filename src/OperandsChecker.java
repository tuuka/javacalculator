import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class OperandsChecker {
    final int maxValue = 10;
    final Pattern pattern = Pattern.compile("^(1?\\d|[IVX]{1,4})([\\+\\-\\*\\/])(1?\\d|[IVX]{1,4})$");
    final static List AcceptableRomans = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");

    public int operand1, operand2;
    public String sign;
    public boolean isRoman;

    public boolean checkInput(String userInput){
        Matcher matcher = pattern.matcher(userInput);
        if (!matcher.find()) return false;
        if (userInput.matches(".*\\d.*") && (userInput.matches(".*[IVX].*"))) return false;
        if (matcher.group(1).matches("^1?\\d$") &&
            matcher.group(3).matches("^1?\\d$")) {
            if (Integer.parseInt(matcher.group(1)) > maxValue ||
                Integer.parseInt(matcher.group(3)) > maxValue) return false;
            this.isRoman = false;
        }
        else {
            if (AcceptableRomans.contains(matcher.group(1)) &&
                AcceptableRomans.contains(matcher.group(3))) this.isRoman = true;
            else return false;
        }
        this.sign = matcher.group(2);
        if (this.isRoman){
            this.operand1 = RomanConverter.romanToDecimal(matcher.group(1));
            this.operand2 = RomanConverter.romanToDecimal(matcher.group(3));
        } else {
            this.operand1 = Integer.parseInt(matcher.group(1));
            this.operand2 = Integer.parseInt(matcher.group(3));
        }
        return true;
    }
}
