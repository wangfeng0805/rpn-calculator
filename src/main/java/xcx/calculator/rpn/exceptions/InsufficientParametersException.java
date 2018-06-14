package xcx.calculator.rpn.exceptions;

import xcx.calculator.rpn.operators.Operator;

public class InsufficientParametersException extends Exception {

    private Operator operator = null;

    private int position = 0;

    public InsufficientParametersException() {
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String getMessage() {

        return "operator " + this.operator.getOperator() + " (position: " + this.getPosition() + "): insufficient parameters";
    }
}
