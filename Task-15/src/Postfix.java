/**
 * The Postfix class implements an evaluator for integer postfix expressions.
 *
 * Postfix notation is a simple way to define and write arithmetic expressions
 * without the need for parentheses or priority rules. For example, the postfix
 * expression "1 2 - 3 4 + *" corresponds to the ordinary infix expression
 * "(1 - 2) * (3 + 4)". The expressions may contain decimal 32-bit integer
 * operands and the four operators +, -, *, and /. Operators and operands must
 * be separated by whitespace.
 *
 * @author  Farhan Syed
 * @version 2022-02-01
 */
public class Postfix {

    public static class ExpressionException extends Exception {
        public ExpressionException(String message) {
            super(message);
        }
    }

    /**
     * Evaluates the given postfix expression.
     *
     * @param expr  Arithmetic expression in postfix notation
     * @return      The value of the evaluated expression
     * @throws      ExpressionException if the expression is wrong
     */
    public static int evaluate(String expr) throws ExpressionException {
        LinkedList<Integer> stack = new LinkedList<>();
        String[] arrayOfCharacters = expr.trim().split("\\s+");            //separates the expression into single characters. Removes all whitespace.
        int secondNumber;
        int firstNumber;
        int valueOfExpression = 0;

        for (String character: arrayOfCharacters) {
            //Character is an operand
            if(isInteger(character)){
                stack.push(Integer.parseInt(character));
            }
            //Character is an operation
            else if(isOperator(character)){
                //Exception handling
                try{                                                    //should only work for integers
                    secondNumber = stack.pop();
                    firstNumber = stack.pop();
                }
                catch(Exception e){
                    throw new ExpressionException("Not an integer!");
                }
                if(secondNumber == 0 && character.equals("/")){         //Division with 0
                    throw new ExpressionException("Can't divide with 0!");
                }

                //Performs an operation on the two numbers
                switch (character) {
                    case "+": valueOfExpression = firstNumber + secondNumber;
                        break;
                    case "-": valueOfExpression = firstNumber - secondNumber;
                        break;
                    case "/": valueOfExpression = firstNumber / secondNumber;
                        break;
                    case "*": valueOfExpression = firstNumber * secondNumber;
                        break;
                }
                stack.push(valueOfExpression);
            }
            else{
                throw new ExpressionException("Invalid character");
            }
        }
        if(stack.size() != 1) throw new ExpressionException("Invalid expression!");     //The expression is wrong if there are 2 or more characters left in the stack
        return stack.pop();                                                 //the final value of the expression is returned
    }

    /**
     * Returns true if s is an operator.
     *
     * A word of caution on using the String.matches method: it returns true
     * if and only if the whole given string matches the regex. Therefore
     * using the regex "[0-9]" is equivalent to "^[0-9]$".
     *
     * An operator is one of '+', '-', '*', '/'.
     */
    private static boolean isOperator(String s) {
        return s.matches("[+|*|\\-|/]");
    }

    /**
     * Returns true if s is an integer.
     *
     * A word of caution on using the String.matches method: it returns true
     * if and only if the whole given string matches the regex. Therefore
     * using the regex "[0-9]" is equivalent to "^[0-9]$".
     *
     * We accept two types of integers:
     *
     * - the first type consists of an optional '-'
     *   followed by a non-zero digit
     *   followed by zero or more digits,
     *
     * - the second type consists of an optional '-'
     *   followed by a single '0'.
     */
    private static boolean isInteger(String s) {
        return s.matches("-?[1-9]\\d*") || s.matches("-?0");
    }
}
