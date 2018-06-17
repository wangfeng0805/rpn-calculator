package xcx.calculator.rpn.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import xcx.calculator.rpn.calculator.RpnCalculatorImpl;
import xcx.calculator.rpn.exceptions.InsufficientParametersException;
import xcx.calculator.rpn.exceptions.utils.PositionService;
import xcx.calculator.rpn.output.OutputServiceImpl;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorControllerTest {

    private CalculatorController calculatorController;
    private ByteArrayInputStream inContent;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Mock
    PositionService positionService;

    @Before
    public void setUp() throws Exception {
        calculatorController = new CalculatorController(new OutputServiceImpl(), new RpnCalculatorImpl(positionService));
        String row = "1 2 3 4 5 * * + sqrt undo 6 7 * undo 8 9 undo undo undo undo";
        inContent = new ByteArrayInputStream(row.getBytes());
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void controllerCaptureInputAndProcessAndOutputThem() throws InsufficientParametersException {
        // given
        System.setIn(inContent);
        // when
        calculatorController.process();
        // then
        assertEquals("stack: [ 1 62 2 60 8 3 ]\n>\n", outContent.toString());
    }
}