package xcx.calculator.rpn.operators;

import org.junit.Before;
import org.junit.Test;
import xcx.calculator.rpn.exceptions.InsufficientParametersException;
import java.math.BigDecimal;
import java.util.Stack;
import static org.junit.Assert.*;

public class DivideOperationTest {

    private DivideOperation divideOperation;

    @Before
    public void setUp() throws Exception {
        divideOperation = new DivideOperation();
    }

    @Test
    public void runDivideOperationWillPushResultToStack() throws InsufficientParametersException {
        // given
        Stack<BigDecimal> stack = new Stack<>();
        BigDecimal firstNumber = new BigDecimal(6);
        BigDecimal secondNumber = new BigDecimal(2);
        stack.push(firstNumber);
        stack.push(secondNumber);
        // when
        divideOperation.run(stack);
        // then
        assertEquals(BigDecimal.valueOf(3).setScale(15), stack.pop());
    }
}