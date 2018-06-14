package xcx.calculator.rpn.output;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Stack;

@Service
public class OutputServiceImpl implements OutputService {

    @Override
    public void print(Stack<BigDecimal> stack) {
        System.out.print("stack: [ ");
        for (BigDecimal stackElement : stack) {
            System.out.print(stackElement + " ");
        }
        System.out.print("]\n");
        System.out.println("> ");
    }
}
