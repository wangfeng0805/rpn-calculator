package xcx.calculator.rpn.controller;

import xcx.calculator.rpn.exceptions.InsufficientParametersException;

public interface CalculatorControllerInterface {
    void process() throws InsufficientParametersException;
}
