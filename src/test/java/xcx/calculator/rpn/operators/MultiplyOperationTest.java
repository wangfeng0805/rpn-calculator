package xcx.calculator.rpn.operators;

import org.junit.Before;
import org.junit.Test;
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
        // when
        multiplyOperation.run(stack);
        // then
        assertEquals(BigDecimal.valueOf(6), stack.pop());
    }
}