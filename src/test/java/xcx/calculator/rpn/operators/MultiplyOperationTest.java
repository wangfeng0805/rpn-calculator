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

public class MultiplyOperationTest {

    private MultiplyOperation multiplyOperation;

    @Before
    public void setUp() throws Exception {
        multiplyOperation = new MultiplyOperation();
    }

    @Test
    public void runMultiplyOperationWillPushResultToStack() throws InsufficientParametersException {
        // given
        Stack<BigDecimal> stack = new Stack<>();
        BigDecimal firstNumber = new BigDecimal(2);
        BigDecimal secondNumber = new BigDecimal(3);
        stack.push(firstNumber);
        stack.push(secondNumber);
        ExternalCommand externalCommand = new ExternalCommandImpl();
        // when
        multiplyOperation.run(stack, externalCommand);
        // then
        assertEquals(BigDecimal.valueOf(6), stack.pop());
        assertEquals(3, externalCommand.getExternalStack().size());
        assertEquals(InternalCommandType.PUSH, externalCommand.getLatestInternalCommand().getInternalCommandType());
    }
}