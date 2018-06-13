package xcx.calculator.rpn.operators;

import java.util.Stack;

public interface Operation {

    void run(Stack<String> stack);
}
