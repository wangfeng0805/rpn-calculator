package xcx.calculator.rpn.operators;

import org.junit.Before;
import org.junit.Test;
import xcx.calculator.rpn.commands.ExternalCommand;
import xcx.calculator.rpn.commands.ExternalCommandImpl;
import xcx.calculator.rpn.commands.InternalCommandImpl;
import xcx.calculator.rpn.commands.InternalCommandType;
import xcx.calculator.rpn.exceptions.InsufficientParametersException;
import java.math.BigDecimal;
import java.util.Stack;
import static org.junit.Assert.*;

public class UndoOperationTest {

    private Stack<BigDecimal> stack;
    private Stack<ExternalCommand> commandHistory;
    private BigDecimal firstNumber;
    private BigDecimal secondNumber;

    @Before
    public void setUp() throws Exception {
        stack = new Stack<>();
        commandHistory = new Stack<>();
        firstNumber = new BigDecimal(1);
        secondNumber = new BigDecimal(2);
        stack.push(firstNumber);
        stack.push(secondNumber);
    }

    @Test
    public void UndoOperationRevertPreviousOperation() throws InsufficientParametersException {
        // given
        ExternalCommand externalCommand1 = new ExternalCommandImpl();
        externalCommand1.addInternalCommand(
                new InternalCommandImpl(
                        InternalCommandType.PUSH,
                        firstNumber
                )
        );
        ExternalCommand externalCommand2 = new ExternalCommandImpl();
        externalCommand2.addInternalCommand(
                new InternalCommandImpl(
                        InternalCommandType.PUSH,
                        secondNumber
                )
        );
        commandHistory.push(externalCommand1);
        commandHistory.push(externalCommand2);
        // when
        UndoOperation.run(stack, commandHistory);
        // then
        assertEquals(1, stack.size());
    }
}