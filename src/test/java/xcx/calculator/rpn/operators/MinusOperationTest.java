package xcx.calculator.rpn.operators;

import org.junit.Before;
import org.junit.Test;
import xcx.calculator.rpn.commands.ExternalCommand;
import xcx.calculator.rpn.commands.ExternalCommandImpl;
import xcx.calculator.rpn.commands.InternalCommandType;
import xcx.calculator.rpn.exceptions.InsufficientParametersException;
import java.math.BigDecimal;
import java.util.Stack;
import static org.junit.Assert.*;

public class MinusOperationTest {

    private MinusOperation minusOperation;

    @Before
    public void setUp() throws Exception {
        minusOperation = new MinusOperation();
    }

    @Test
    public void runMinusOperationWillPushResultToStack() throws InsufficientParametersException {
        // given
        Stack<BigDecimal> stack = new Stack<>();
        BigDecimal firstNumber = new BigDecimal(3);
        BigDecimal secondNumber = new BigDecimal(2);
        stack.push(firstNumber);
        stack.push(secondNumber);
        ExternalCommand externalCommand = new ExternalCommandImpl();
        // when
        minusOperation.run(stack, externalCommand);
        // then
        assertEquals(BigDecimal.valueOf(1), stack.pop());
        assertEquals(3, externalCommand.getExternalStack().size());
        assertEquals(InternalCommandType.PUSH, externalCommand.getLatestInternalCommand().getInternalCommandType());
    }
}