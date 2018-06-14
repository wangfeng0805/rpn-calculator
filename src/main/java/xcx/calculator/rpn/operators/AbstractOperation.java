package xcx.calculator.rpn.operators;

import xcx.calculator.rpn.exceptions.InsufficientParametersException;
import java.math.BigDecimal;
import java.util.Stack;

public class AbstractOperation {

    private BigDecimal number;

    public BigDecimal popNumberFromStack(Stack<BigDecimal> stack) throws InsufficientParametersException {

        if (!stack.empty()) {
            number = stack.pop();
        } else {
            throw new InsufficientParametersException();
        }

        return number;
    }

    public BigDecimal popSecondNumberFromStack(Stack<BigDecimal> stack, BigDecimal firstNumber) throws InsufficientParametersException {
        try {
            return popNumberFromStack(stack);
        } catch (InsufficientParametersException e) {
            stack.push(firstNumber);
            throw e;
        }
    }
}
