package xcx.calculator.rpn.operators;

import xcx.calculator.rpn.exceptions.InsufficientParametersException;
import java.math.BigDecimal;
import java.util.Stack;

public interface Operation {

    void run(Stack<BigDecimal> stack) throws InsufficientParametersException;
}
