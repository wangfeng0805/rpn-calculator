package xcx.calculator.rpn.operators;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OperatorTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void validOperatorWillReturnTrue() {
        // given
        String operator = "+";
        // when
        boolean isValid = Operator.isValidOperator(operator);
        // then
        assertTrue(isValid);
    }

    @Test
    public void invalidOperatorWillReturnFalse() {
        // given
        String operator = "jump";
        // when
        boolean isValid = Operator.isValidOperator(operator);
        // then
        assertFalse(isValid);
    }

    @Test
    public void getOperatorReturnEnumOperator() {
        // given
        String operator = "+";
        // when
        Operator PLUS = Operator.getOperator(operator);
        // then
        assertEquals(Operator.PLUS, PLUS);
    }

    @Test
    public void getOperationWillReturnRelatedOperationInstance() {
        // when
        Operation operation = Operator.getOperation(Operator.CLEAR);
        // then
        assertTrue(operation instanceof ClearOperation);
    }
}