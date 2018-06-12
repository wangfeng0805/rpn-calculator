package xcx.calculator.rpn.controller;

import org.springframework.stereotype.Component;
import xcx.calculator.rpn.stack.StackService;
import java.util.Scanner;

@Component
public class CalculatorController implements CalculatorControllerInterface {

    private StackService stackService;

    public CalculatorController(StackService stackServiceImpl) {
        this.stackService = stackServiceImpl;
    }

    @Override
    public void process() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n<RPN Calculator> Enter a white-spaced list of numbers and operators then press enter:");
        System.out.println(">");

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();

            System.out.print("stack: [");
            for (String stackElement : stackService.convertToStack(line)) {
                System.out.print(stackElement + " ");
            }
            System.out.print("]\n");
            System.out.println("> ");
        }


    }




}
