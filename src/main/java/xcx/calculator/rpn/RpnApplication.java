package xcx.calculator.rpn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import xcx.calculator.rpn.controller.CalculatorControllerInterface;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class RpnApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(RpnApplication.class, args);

		CalculatorControllerInterface calculatorController = (CalculatorControllerInterface) ctx.getBean("calculatorController");
		calculatorController.process();

		ctx.close();
	}

}
