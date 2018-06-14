package xcx.calculator.rpn.operators;

import xcx.calculator.rpn.exceptions.InsufficientParametersException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Stack;
import static java.lang.StrictMath.sqrt;

public class SqrtOperation extends AbstractOperation implements Operation {
    @Override
    public void run(Stack<BigDecimal> stack) throws InsufficientParametersException {
        BigDecimal firstNumber = popNumberFromStack(stack);
        BigDecimal calculationResult = new BigDecimal(sqrt(firstNumber.doubleValue()), MathContext.DECIMAL64);

        stack.push(calculationResult);
    }
}
