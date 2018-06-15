package xcx.calculator.rpn.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import xcx.calculator.rpn.calculator.RpnCalculatorImpl;
import xcx.calculator.rpn.exceptions.InsufficientParametersException;
import xcx.calculator.rpn.output.OutputServiceImpl;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class CalculatorControllerTest {

    private CalculatorController calculatorController;
    private ByteArrayInputStream inContent;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        calculatorController = new CalculatorController(new OutputServiceImpl(), new RpnCalculatorImpl());
        String row = "2 3 +";
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
        assertEquals("stack: [ 5 ]\n>\n", outContent.toString());
    }
}