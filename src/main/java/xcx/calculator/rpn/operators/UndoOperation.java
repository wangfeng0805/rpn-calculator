package xcx.calculator.rpn.operators;

import xcx.calculator.rpn.exceptions.InsufficientParametersException;

import java.math.BigDecimal;
import java.util.Stack;

public class UndoOperation extends AbstractOperation implements Operation{

    public UndoOperation() {
    }

    @Override
    public void run(Stack<BigDecimal> stack) throws InsufficientParametersException {

    }
}
