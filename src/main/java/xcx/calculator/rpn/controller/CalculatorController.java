package xcx.calculator.rpn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import xcx.calculator.rpn.exceptions.InsufficientParametersException;
import xcx.calculator.rpn.operators.Operator;
import xcx.calculator.rpn.output.OutputService;
import xcx.calculator.rpn.stack.StackService;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Stack;

@Component
public class CalculatorController implements CalculatorControllerInterface {

    private StackService stackService;
    private Stack<BigDecimal> stack;
    private OutputService outputService;
    protected final Logger log = LoggerFactory.getLogger(getClass());

    public CalculatorController(
            StackService stackService,
            OutputService outputService
    ) {
        this.stackService = stackService;
        this.outputService = outputService;
        stack = new Stack<>();
    }

    @Override
    public void process() {

        Scanner scanner = new Scanner(System.in);

        while(true) {
            String row = scanner.nextLine();
            if(row.equals("exit")) break;

            String[] keywordArray = stackService.parse(row);
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

            outputService.print(stack);
        }


    }




}
