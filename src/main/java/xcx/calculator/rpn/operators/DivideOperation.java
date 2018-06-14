package xcx.calculator.rpn.operators;

import xcx.calculator.rpn.exceptions.InsufficientParametersException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class DivideOperation extends AbstractOperation implements Operation {

    @Override
    public void run(Stack<BigDecimal> stack) throws InsufficientParametersException {

        BigDecimal firstNumber = popNumberFromStack(stack);
        BigDecimal secondNumber = popSecondNumberFromStack(stack, firstNumber);
        BigDecimal calculationResult = secondNumber.divide(firstNumber, 15, RoundingMode.UP);

        stack.push(calculationResult);
    }
}
