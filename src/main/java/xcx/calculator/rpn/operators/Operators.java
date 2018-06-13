package xcx.calculator.rpn.operators;

public enum Operators {

    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/"), SQRT("sqrt"), CLEAR("clear"),  UNDO("undo");

    private String operator;

    Operators(String value) {
        operator = value;
    }

    public String getOperator() {
        return operator;
    }

    public static String getAllOperators() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Operators operator : Operators.values()) {
            stringBuilder.append(operator.getOperator()).append(" ");
        }
        return stringBuilder.toString();
    }

    public static Operation getOperation(Operators operator) {
        switch (operator) {
            case PLUS:
                return new PlusOperation();
            case MINUS:
                return new MinusOperation();
            case MULTIPLY:
                return new MultiplyOperation();
            case DIVIDE:
                return new DivideOperation();
            default:
                return new PlusOperation();
        }
    }

//    public static boolean isValidOperator(String inputOperator) {
//
//        for (CalculatorOperator validOp : CalculatorOperator.values()) {
//            if (validOp.getOperator().equalsIgnoreCase(inputOperator)) {
//                return true;
//            }
//        }
//
//        return false;
//    }

    public static Operators getOperator(String inputOperator) {

        for (Operators validOp : Operators.values()) {
            if (validOp.getOperator().equalsIgnoreCase(inputOperator)) {
                return validOp;
            }
        }

        return null;
    }

}
