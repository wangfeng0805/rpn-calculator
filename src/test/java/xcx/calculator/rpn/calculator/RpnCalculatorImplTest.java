package xcx.calculator.rpn.calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Stack;
import static org.junit.Assert.*;

public class RpnCalculatorImplTest {

    private RpnCalculator rpnCalculator;
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {

        rpnCalculator = new RpnCalculatorImpl();
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setErr(System.err);
    }

    @Test
    public void calculateAndPushResultToStack() {
        // given
        String[] keywordAraay = new String[]{"2","3","+"};
        // when
        Stack<BigDecimal> stack = rpnCalculator.calculate(keywordAraay);
        // then
        assertEquals(1, stack.size());
        assertEquals(BigDecimal.valueOf(5), stack.pop());
    }

    @Test
    public void insufficientParameterInputWillPrintSystemErrorMessage() {
        // given
        String[] keywordAraay = new String[]{"2","+"};
        // when
        rpnCalculator.calculate(keywordAraay);
        // then
        assertEquals("operator + (position: 1): insufficient parameters\n", errContent.toString());
    }
}