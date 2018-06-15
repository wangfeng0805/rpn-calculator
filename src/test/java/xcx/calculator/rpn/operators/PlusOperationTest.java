package xcx.calculator.rpn.operators;

import org.junit.Before;
import org.junit.Test;
import xcx.calculator.rpn.exceptions.InsufficientParametersException;
import java.math.BigDecimal;
import java.util.Stack;
import static org.junit.Assert.*;

public class PlusOperationTest {

    private PlusOperation plusOperation;

    @Before
    public void setUp() throws Exception {
        plusOperation = new PlusOperation();
    }

    @Test
    public void runPlusOperationWillPushResultToStack() throws InsufficientParametersException {
        // given
        Stack<BigDecimal> stack = new Stack<>();
        BigDecimal firstNumber = new BigDecimal(1);
        BigDecimal secondNumber = new BigDecimal(2);
        stack.push(firstNumber);
        stack.push(secondNumber);
        // when
        plusOperation.run(stack);
        // then
        assertEquals(BigDecimal.valueOf(3), stack.pop());
    }
}