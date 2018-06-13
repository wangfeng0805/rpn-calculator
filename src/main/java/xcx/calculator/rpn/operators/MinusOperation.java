package xcx.calculator.rpn.operators;

import java.util.Stack;

public class MinusOperation implements Operation {

    @Override
    public void run(Stack<String> stack) {
        String firstNumber = stack.pop();
        String secondNumber = stack.pop();

        Integer calculationResult = Integer.valueOf(secondNumber) - Integer.valueOf(firstNumber);

        stack.push(calculationResult.toString());
    }
}
