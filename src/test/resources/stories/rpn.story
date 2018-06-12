Feature: Stack numbers can be calculated with RPN

Narrative:
As a RPN calculator user
I want to get RPN calculation result when input numbers and operators

Scenario: numbers can be stored in stack
Given stack is empty
When user input numbers 2 4 5
Then stack output [2 4 5]

