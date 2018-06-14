package xcx.calculator.rpn.operators;

import java.math.BigDecimal;
import java.util.Stack;

public class ClearOperation implements Operation {

    @Override
    public void run(Stack<BigDecimal> stack) {
        while (!stack.empty()) {
            stack.pop();
        }
    }
}
