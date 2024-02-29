import java.util.Stack;
public class Postfix {
    /*
    Given a String input containing an infix expression. Return a String output containing the equivalent
    postfix expression.
    Infix expression: The expression of the form a op b. When an operator is in-between every pair of
    operands.
    Postfix expression: The expression of the form a b op. When an operator is followed for every pair of
    operands.
    Note: The order of precedence is: ^ greater than * equals to / greater than + equals to -. Ignore the right
    associativity of ^.
    Hint:
    o If the scanned character is a ( , push it to the stack.
    o If the scanned character is a ) , pop the stack and output it until a ( is encountered, and discard both
    the parenthesis.
    Constraints
    • The input is guaranteed to be a valid expression
    sample Input
    a+b*(c^d-e)^(f+g*h)-i
    Sample Output
    abcd^e-fgh*+^*+i-
     */

    // check if a character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    //get the precedence of an operator
    private static int getPrecedence(char operator) {
        switch (operator) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            // if invalid characters
            default:
                return -1;
        }
    }

    // convert infix expression to postfix expression
    private static String infixToPostfix(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        for (char ch : infixExpression.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch); // add directly to output
            } else if (ch == '(') {
                operatorStack.push(ch); // push opening parenthesis to  stack
            } else if (ch == ')') {
                // pop ops from stack and append to the output until
                // an opening parenthesis is encountered
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop());
                }
                if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    operatorStack.pop(); //get rid of parentheses
                }
            } else if (isOperator(ch)) {
                // pop operators from  stack and append to the output until the stack
                // is empty or a lower precedence operator is encountered
                while (!operatorStack.isEmpty() && getPrecedence(ch) <= getPrecedence(operatorStack.peek())) {
                    postfix.append(operatorStack.pop());
                }
                // push the current operator to the stack
                operatorStack.push(ch);
            }
        }

        // pop remaining operators from the stack
        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        String infixExpression = "a+b*(c^d-e)^(f+g*h)-i";
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println(postfixExpression);
    }

}
