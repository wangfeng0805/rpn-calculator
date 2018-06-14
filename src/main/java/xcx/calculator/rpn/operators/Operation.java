package xcx.calculator.rpn.operators;

import java.math.BigDecimal;
import java.util.Stack;

public interface Operation {

    void run(Stack<BigDecimal> stack);
}
