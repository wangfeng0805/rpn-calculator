package xcx.calculator.rpn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import xcx.calculator.rpn.operators.Operation;
import xcx.calculator.rpn.operators.Operators;
import xcx.calculator.rpn.operators.PlusOperation;
import xcx.calculator.rpn.output.OutputService;
import xcx.calculator.rpn.stack.StackService;
import java.util.Scanner;
import java.util.Stack;

@Component
public class CalculatorController implements CalculatorControllerInterface {

    private StackService stackService;
    private Stack<String> stack;
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
            String line = scanner.nextLine();
            if(line.equals("exit")) break;

            String[] stackArray = stackService.parse(line);
            for (String s : stackArray) {
                if (!Operators.getAllOperators().contains(s)) {
                    stack.push(s);
                } else {

                    Operators.getOperation(Operators.getOperator(s)).run(stack);

                }
            }

            outputService.print(stack);
        }


    }




}
