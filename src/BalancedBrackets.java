import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class BalancedBrackets {
    /*
    A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a
closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {},
and ().
A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For
example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square
brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single,
unbalanced closing square bracket, ].
By this logic, we say a sequence of brackets is balanced if the following conditions are met:
• It contains no unmatched brackets
• The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched
pair of brackets
Given a String of brackets, determine whether the sequence of brackets is balanced. If a String is balanced,
return YES. Otherwise, return NO.
Function Description: Write a function named isBalanced.
isBalanced has the following parameter(s):
• String s: a String of brackets
Returns
• String: either YES or NO
Input Format
A single String s will contain only a sequence of brackets. Can be empty.
Constraints
• 1 ≤ |𝑠| ≤ 10! , where |𝒔| is the length of the sequence
• All characters in the sequences ∈ { ‘{‘, ‘}’, ‘(‘, ‘)’, ‘[‘, ‘]’ }
• You are allowed to use the LinkedList class but only the add(), remove(), and peek() methods
Output Format
For each String, return YES or NO
     */


    static String isBalanced(String s) {

        //use stack to keep track of the brackets
        Deque<Character> stack = new ArrayDeque<>();
        //checks for opening brackets
        for (char bracket : s.toCharArray()) {
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.addLast(bracket);
            } else {
                //if stack is empty then its not balanced
                if (stack.isEmpty()) {
                    return "NO";
                }
                //check that they match the ending bracket
                char top = stack.removeLast();
                //if a pair of brackets don't match, return no- not balanced
                if ((bracket == ')' && top != '(') ||
                        (bracket == '}' && top != '{') ||
                        (bracket == ']' && top != '[')) {
                    return "NO";
                }
            }
        }
        //if the remaining stack is empty then yes it was balanced, if no then wasn't balanced
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        // provided examples
        System.out.println(isBalanced("{[()]}"));        // output: YES
        System.out.println(isBalanced("{[(])}"));        // output: NO
        System.out.println(isBalanced("{{[[(())]]}}"));  // output: YES
    }



}
