package xcx.calculator.rpn.operators;

import java.math.BigDecimal;
import java.util.Stack;

public class MinusOperation implements Operation {

    @Override
    public void run(Stack<BigDecimal> stack) {
        BigDecimal firstNumber = stack.pop();
        BigDecimal secondNumber = stack.pop();

        BigDecimal calculationResult = secondNumber.subtract(firstNumber);

        stack.push(calculationResult);
    }
}
