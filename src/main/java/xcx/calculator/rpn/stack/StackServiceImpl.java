package xcx.calculator.rpn.stack;

import org.springframework.stereotype.Service;
import xcx.calculator.rpn.operators.Operators;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Service
public class StackServiceImpl implements StackService {

    private Stack<String> stack;
    private String[] elements;
    private final String allOperators = Operators.getAllOperators();

    public StackServiceImpl() {
        this.stack = new Stack<>();
    }

    public String[] parse(String line) {
        return line.split("\\s");
    }

    public Stack<String> convertToStack(String line) {

        elements = parse(line);

        for (String element : elements) {
            element = element.trim();
            if (!allOperators.contains((element))) {
                stack.push(element);
            }
        }

        return stack;
    }
}
