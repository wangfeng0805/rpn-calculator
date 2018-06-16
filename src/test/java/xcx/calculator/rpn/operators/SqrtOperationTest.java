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

public class SqrtOperationTest {

    private SqrtOperation sqrtOperation;

    @Before
    public void setUp() throws Exception {
        sqrtOperation = new SqrtOperation();
    }

    @Test
    public void runSqrtOperationWillPushResultToStack() throws InsufficientParametersException {
        // given
        Stack<BigDecimal> stack = new Stack<>();
        BigDecimal firstNumber = new BigDecimal(4);
        stack.push(firstNumber);
        ExternalCommand externalCommand = new ExternalCommandImpl();
        // when
        sqrtOperation.run(stack, externalCommand);
        // then
        assertEquals(BigDecimal.valueOf(2), stack.pop());
        assertEquals(2, externalCommand.getExternalStack().size());
        assertEquals(InternalCommandType.PUSH, externalCommand.getLatestInternalCommand().getInternalCommandType());
    }
}