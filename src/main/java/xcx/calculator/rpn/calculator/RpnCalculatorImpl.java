package xcx.calculator.rpn.calculator;

import org.springframework.stereotype.Component;
import xcx.calculator.rpn.exceptions.InsufficientParametersException;
import xcx.calculator.rpn.operators.Operator;
import java.math.BigDecimal;
import java.util.Stack;

@Component
public class RpnCalculatorImpl implements RpnCalculator {

    private Stack<BigDecimal> stack;

    public RpnCalculatorImpl() {
        stack = new Stack<>();
    }

    public Stack<BigDecimal> calculate(String[] keywordArray) {

        int position = 0;
        for (String keyword : keywordArray) {

            if (!Operator.getAllOperators().contains(keyword)) {
                stack.push(new BigDecimal(keyword));
            } else {
                if (!Operator.isValidOperator(keyword)) {
                    throw new RuntimeException("Invalid operator: " + keyword);
                }

                try {
                    Operator.getOperation(Operator.getOperator(keyword)).run(stack);
                } catch (InsufficientParametersException e) {
                    e.setOperator(Operator.getOperator(keyword));
                    e.setPosition(position);
                    System.err.println(e.getMessage());
                    System.err.flush();
                }
            }

            position++;
        }

        return stack;
    }

}
