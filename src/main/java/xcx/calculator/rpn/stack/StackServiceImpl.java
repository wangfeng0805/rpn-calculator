package xcx.calculator.rpn.stack;

import org.springframework.stereotype.Service;
import xcx.calculator.rpn.operators.Operator;
import java.math.BigDecimal;
import java.util.Stack;

@Service
public class StackServiceImpl implements StackService {

    private Stack<BigDecimal> stack;
    private String[] elements;
    private final String allOperators = Operator.getAllOperators();

    public StackServiceImpl() {
        this.stack = new Stack<>();
    }

    public String[] parse(String line) {
        return line.split("\\s");
    }

    public Stack<BigDecimal> convertToStack(String line) {

        elements = parse(line);

        for (String element : elements) {
            element = element.trim();
            if (!allOperators.contains((element))) {
                stack.push(new BigDecimal(element));
            }
        }

        return stack;
    }
}
