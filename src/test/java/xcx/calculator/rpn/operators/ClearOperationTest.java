package xcx.calculator.rpn.operators;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Stack;
import static org.junit.Assert.*;

public class ClearOperationTest {

    private ClearOperation clearOperation;

    public ClearOperationTest() {
        clearOperation = new ClearOperation();
    }

    @Test
    public void clearOperationEmptyStack() {
        // given
        Stack<BigDecimal> stack = new Stack<>();
        BigDecimal firstNumber = new BigDecimal(1);
        BigDecimal secondNumber = new BigDecimal(2);
        stack.push(firstNumber);
        stack.push(secondNumber);
        // when
        clearOperation.run(stack);
        // then
        assertEquals(0, stack.size());
    }
}