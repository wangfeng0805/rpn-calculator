package xcx.calculator.rpn.stack;

import java.math.BigDecimal;
import java.util.Stack;

public interface StackService {

    String[] parse(String line);

    Stack<BigDecimal> convertToStack(String line);
}
