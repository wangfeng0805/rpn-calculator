package xcx.calculator.rpn.stack;

import java.util.Stack;

public interface StackService {

    String[] parse(String line);

    Stack<String> convertToStack(String line);
}
