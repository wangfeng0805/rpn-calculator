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

public class AbstractOperationTest {

    private PlusOperation plusOperation;
    private Stack<BigDecimal> stack;
    private ExternalCommand externalCommand;

    @Before
    public void setUp() throws Exception {
        plusOperation = new PlusOperation();
        stack = new Stack<>();
        externalCommand = new ExternalCommandImpl();
    }

    @Test
    public void popNumberFromStackIfNotEmpty() throws InsufficientParametersException {
        // given
        BigDecimal firstNumber = new BigDecimal(1);
        stack.push(firstNumber);
        // when
        BigDecimal number = plusOperation.popNumberFromStack(stack, externalCommand);
        // then
        assertEquals(firstNumber, number);
        assertEquals(1, externalCommand.getExternalStack().size());
        assertEquals(InternalCommandType.POP, externalCommand.getLatestInternalCommand().getInternalCommandType());
    }

    @Test(expected = InsufficientParametersException.class)
    public void popNumberFromStackThrowExceptionWhenStackEmpty() throws InsufficientParametersException {
        // when
        plusOperation.popNumberFromStack(stack, externalCommand);
    }

    @Test
    public void popSecondNumberFromStackIfStackLongEnough() throws InsufficientParametersException {
        // given
        BigDecimal firstNumber = new BigDecimal(1);
        BigDecimal secondNumber = new BigDecimal(1);
        stack.push(firstNumber);
        stack.push(secondNumber);
        // when
        BigDecimal number = plusOperation.popSecondNumberFromStack(stack, firstNumber, externalCommand);
        // then
        assertEquals(secondNumber, number);
        assertEquals(1, externalCommand.getExternalStack().size());
        assertEquals(InternalCommandType.POP, externalCommand.getLatestInternalCommand().getInternalCommandType());
    }

    @Test(expected = InsufficientParametersException.class)
    public void popSecondNumberFromStackThrowExceptionWhenStackInsufficient() throws InsufficientParametersException {
        // given
        BigDecimal firstNumber = new BigDecimal(1);
        // when
        plusOperation.popSecondNumberFromStack(stack, firstNumber, externalCommand);
    }
}