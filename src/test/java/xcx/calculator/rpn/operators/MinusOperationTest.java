package xcx.calculator.rpn.operators;

import org.junit.Before;
import org.junit.Test;
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
    public void rnMinusOperationWillPushResultToStack() throws InsufficientParametersException {
        // given
        Stack<BigDecimal> stack = new Stack<>();
        BigDecimal firstNumber = new BigDecimal(3);
        BigDecimal secondNumber = new BigDecimal(2);
        stack.push(firstNumber);
        stack.push(secondNumber);
        // when
        minusOperation.run(stack);
        // then
        assertEquals(BigDecimal.valueOf(1), stack.pop());
    }
}