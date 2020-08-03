public class CalculatorException extends Exception {
    CalculatorException(String error){
        super(error);
    }

    CalculatorException(){
        super("Wrong input!");
    }
}
