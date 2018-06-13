package xcx.calculator.rpn.output;

import org.springframework.stereotype.Service;
import java.util.Stack;

@Service
public class OutputServiceImpl implements OutputService {

    @Override
    public void print(Stack<String> stack) {
        System.out.print("stack: [ ");
        for (String stackElement : stack) {
            System.out.print(stackElement + " ");
        }
        System.out.print("]\n");
        System.out.println("> ");
    }
}
