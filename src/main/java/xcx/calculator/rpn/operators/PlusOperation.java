package xcx.calculator.rpn.operators;

import xcx.calculator.rpn.exceptions.InsufficientParametersException;
import java.math.BigDecimal;
import java.util.Stack;

public class PlusOperation extends AbstractOperation implements Operation {

    @Override
    public void run(Stack<BigDecimal> stack) throws InsufficientParametersException {

        BigDecimal firstNumber = popNumberFromStack(stack);
        BigDecimal secondNumber = popSecondNumberFromStack(stack, firstNumber);
        BigDecimal calculationResult = firstNumber.add(secondNumber);

        stack.push(calculationResult);
    }
}
