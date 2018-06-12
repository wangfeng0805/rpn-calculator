package xcx.calculator.rpn.stack;

import org.springframework.stereotype.Service;
import java.util.Stack;

@Service
public class StackServiceImpl implements StackService {

    private Stack<String> stack;
    private String[] parts;

    public StackServiceImpl() {
        this.stack = new Stack<>();

    }

    public void parseString(String line) {
        parts = line.split(" ");
    }

    public Stack<String> convertToStack(String line) {

        parseString(line);

        for (String part : parts) {
            stack.push(part);
        }

        return stack;
    }
}
