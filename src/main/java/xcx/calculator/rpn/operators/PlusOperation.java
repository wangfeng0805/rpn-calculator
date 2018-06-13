package xcx.calculator.rpn.operators;

import java.util.Stack;

public class PlusOperation implements Operation {

    @Override
    public void run(Stack<String> stack) {
        String firstNumber = stack.pop();
        String secondNumber = stack.pop();

        Integer calculationResult = Integer.valueOf(firstNumber) + Integer.valueOf(secondNumber);

        stack.push(calculationResult.toString());
    }
}
