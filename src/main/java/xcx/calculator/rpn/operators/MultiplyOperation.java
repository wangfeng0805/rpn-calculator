package xcx.calculator.rpn.operators;

import java.math.BigDecimal;
import java.util.Stack;

public class MultiplyOperation implements Operation {

    @Override
    public void run(Stack<BigDecimal> stack) {
        BigDecimal firstNumber = stack.pop();
        BigDecimal secondNumber = stack.pop();

        BigDecimal calculationResult = firstNumber.multiply(secondNumber);

        stack.push(calculationResult);
    }
}
