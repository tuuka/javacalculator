import java.util.Scanner;


class InputExp {
    static Scanner systemInputScanner = new Scanner(System.in);

    static OperandsChecker getInputExpression () throws CalculatorException {
        System.out.print("Input:");
        String userInput = systemInputScanner.nextLine()
                .toUpperCase()
                .replaceAll("\\s+", "");
        OperandsChecker checker = new OperandsChecker();
        if (!checker.checkInput(userInput)) throw new CalculatorException("Wrong input expression!");
        return checker;
    }
}
