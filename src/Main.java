public class Main {

    static int calc(int op1, String sign, int op2) throws CalculatorException {
        int result;
        switch (sign) {
            case "+" : result = op1 + op2;
                break;
            case "-" : result = op1 - op2;
                break;
            case "*" : result = op1 * op2;
                break;
            case "/" : result = (op1 - op1 % op2) / op2;
                break;
            default: throw new CalculatorException("Wrong operation sign! Don't know why it came here.");
        }
        return result;
    }

    public static void main(String[] args) {
	    try {
	        OperandsChecker checker = InputExp.getInputExpression();
	        int res = calc(checker.operand1, checker.sign, checker.operand2);
	        String result = checker.isRoman ? RomanConverter.arabToRoman(res) : String.valueOf(res);
            System.out.println("Output: " + result);
        }
	    catch(Exception ex){
            //System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
