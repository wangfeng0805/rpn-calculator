package xcx.calculator.rpn.stack;

import java.util.Stack;

public interface StackService {

    void parseString(String line);

    Stack<String> convertToStack(String line);
}
