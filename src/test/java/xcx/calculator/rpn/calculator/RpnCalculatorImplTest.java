package xcx.calculator.rpn.calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import xcx.calculator.rpn.exceptions.utils.PositionService;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Stack;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RpnCalculatorImplTest {

    private RpnCalculator rpnCalculator;
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Mock
    PositionService positionService;

    @Before
    public void setUp() throws Exception {

        rpnCalculator = new RpnCalculatorImpl(positionService);
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
        String[] keywordArray = new String[]{"1", "2", "3", "*", "5", "+", "*", "*", "6", "5"};
        when(positionService.getPositionIndex(7)).thenReturn(15);
        // when
        rpnCalculator.calculate(keywordArray);
        // then
        assertEquals("operator * (position: 15): insufficient parameters\n", errContent.toString());
    }
}