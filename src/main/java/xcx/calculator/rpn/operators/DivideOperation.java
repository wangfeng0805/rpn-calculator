package xcx.calculator.rpn.operators;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class DivideOperation implements Operation {

    @Override
    public void run(Stack<BigDecimal> stack) {
        BigDecimal firstNumber = stack.pop();
        BigDecimal secondNumber = stack.pop();

        BigDecimal calculationResult = secondNumber.divide(firstNumber, 15, RoundingMode.UP);

        stack.push(calculationResult);
    }
}
