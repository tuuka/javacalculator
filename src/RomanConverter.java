public class RomanConverter {

    final static int[] font_ar = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
    final static String[] font_rom = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};

    static int romanToDecimal(String s){
        s = s.toUpperCase();
        int result = 0, pos = 0;
        int n = font_ar.length - 1;
        while (n >= 0 & pos < s.length()) {
            if (s.startsWith(font_rom[n], pos)) {
                result += font_ar[n];
                pos += font_rom[n].length();
            } else n--;
        }
        return result;
    }

    static String arabToRoman(int num) throws CalculatorException {
        StringBuilder result = new StringBuilder();
        if (num <= 0) throw new CalculatorException("Result value is less then 1, so it can't be converted into roman!");
        int n = font_ar.length - 1;
        while (num > 0) {
            if (num >= font_ar[n]) {
                result.append(font_rom[n]);
                num -= font_ar[n];
            } else n--;
        }
        return result.toString();
    }
}

