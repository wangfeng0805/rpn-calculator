package xcx.calculator.rpn.output;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Stack;

import static org.junit.Assert.*;

public class OutputServiceImplTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private OutputServiceImpl outputService;

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        outputService = new OutputServiceImpl();
    }

    @Test
    public void print() {
        // given
        Stack<BigDecimal> stack = new Stack<>();
        BigDecimal firstNumber = new BigDecimal(1);
        BigDecimal secondNumber = new BigDecimal(2);
        stack.push(firstNumber);
        stack.push(secondNumber);
        // when
        outputService.print(stack);
        // then
        assertEquals("stack: [ 1 2 ]\n>\n", outContent.toString());
    }
}