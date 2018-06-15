package xcx.calculator.rpn.operators;

import org.junit.Before;
import org.junit.Test;
import xcx.calculator.rpn.exceptions.InsufficientParametersException;
import java.math.BigDecimal;
import java.util.Stack;
import static org.junit.Assert.*;

public class AbstractOperationTest {

    private PlusOperation plusOperation;
    private Stack<BigDecimal> stack;

    @Before
    public void setUp() throws Exception {
        plusOperation = new PlusOperation();
        stack = new Stack<>();
    }

    @Test
    public void popNumberFromStackIfNotEmpty() throws InsufficientParametersException {
        // given
        BigDecimal firstNumber = new BigDecimal(1);
        stack.push(firstNumber);
        // when
        BigDecimal number = plusOperation.popNumberFromStack(stack);
        // then
        assertEquals(firstNumber, number);
    }

    @Test(expected = InsufficientParametersException.class)
    public void popNumberFromStackThrowExceptionWhenStackEmpty() throws InsufficientParametersException {
        // when
        plusOperation.popNumberFromStack(stack);
    }

    @Test
    public void popSecondNumberFromStackIfStackLongEnough() throws InsufficientParametersException {
        // given
        BigDecimal firstNumber = new BigDecimal(1);
        BigDecimal secondNumber = new BigDecimal(1);
        stack.push(firstNumber);
        stack.push(secondNumber);
        // when
        BigDecimal number = plusOperation.popSecondNumberFromStack(stack, firstNumber);
        // then
        assertEquals(secondNumber, number);
    }

    @Test(expected = InsufficientParametersException.class)
    public void popSecondNumberFromStackThrowExceptionWhenStackInsufficient() throws InsufficientParametersException {
        // given
        BigDecimal firstNumber = new BigDecimal(1);
        // when
        plusOperation.popSecondNumberFromStack(stack, firstNumber);
    }
}