package xcx.calculator.rpn.operators;

import org.junit.Test;
import xcx.calculator.rpn.commands.ExternalCommand;
import xcx.calculator.rpn.commands.ExternalCommandImpl;
import java.math.BigDecimal;
import java.util.Stack;
import static org.junit.Assert.*;

public class ClearOperationTest {

    private ClearOperation clearOperation;

    public ClearOperationTest() {
        clearOperation = new ClearOperation();
    }

    @Test
    public void clearOperationEmptyStack() {
        // given
        Stack<BigDecimal> stack = new Stack<>();
        BigDecimal firstNumber = new BigDecimal(1);
        BigDecimal secondNumber = new BigDecimal(2);
        stack.push(firstNumber);
        stack.push(secondNumber);
        ExternalCommand externalCommand = new ExternalCommandImpl();
        // when
        clearOperation.run(stack, externalCommand);
        // then
        assertEquals(0, stack.size());
        assertEquals(2, externalCommand.getExternalStack().size());
    }
}