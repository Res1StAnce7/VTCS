// On my honor:
// - I have not used source code obtained from another student,
//   or any other unauthorized source, either modified or
//   unmodified.
//
// - All source code and documentation used in my program is
//   either my original work, or was derived by me from the
//   source code published in the textbook for this course.
//
// - I have not discussed coding details about this project
//   with anyone other than my partner (in the case of a joint
//   submission), instructor, ACM/UPE tutors or the TAs assigned
//   to this course. I understand that I may discuss the concepts
//   of this program with other students, and that another student
//   may help me debug my program so long as neither of us writes
//   anything during the discussion or modifies any computer file
//   during the discussion. I have violated neither the spirit nor
//   letter of this restriction.
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

/**
 * Perform the calculation based on the input file.
 * 
 * @author Siliang Zhang
 * 
 * @version 2022.05.25
 */
public class BigNumArithmetic {
    /**
     * Create a new BigNumArithmetic object and call the calculate method.
     * 
     * Variable Explanation:
     * bna is the BigNumArithmetic object which will call the calculate method
     * 
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        BigNumArithmetic bna = new BigNumArithmetic();
        bna.calculate(args[0]);
    }

    /**
     * The function takes a file name as an argument and calculate the
     * result based on expressions in the file.
     *
     * Variable Explanation:
     * sc is the Scanner object which will read and traverse the file
     * line is used to store the reformatted expression
     * stack is the stack which will store either the result of the expression
     * or the error codes
     * @param fileName Specify the file to be read
     */
    public void calculate(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));

            while (sc.hasNextLine()) {
                String line = rebuild(sc.nextLine().replace("\t", "").trim());
                Stack<LinkedList<String>> stack = getStack(line);

                if (!stack.peek().getEntry(1).equals("$")) {
                    System.out.print(line + "= ");
                    if (!stack.peek().getEntry(1).equals("&")) {
                        System.out.println(toString(stack.peek()));
                    } 
                    else {
                        System.out.println();
                    }
                }
            }
            sc.close();
        } 
        catch (IOException e) {
            System.exit(1);
        }
    }

    /**
     * The function takes a string as an argument and perform the calculation
     * 
     * Variable Explanation:
     * sc is the Scanner object which will read and traverse the expression.
     * stack is used to store the result of each calculation.
     * list is used to store the operands
     * operand and operator are two counters that help to determine if
     * the expression is valid.
     * op1 and op2 are the two top operands in the stack.
     * 
     * @param line The expression to be calculated
     *
     * @return The stack which either contains the result or error message
     *
     */
    public Stack<LinkedList<String>> getStack(String line) {
        Scanner sc = new Scanner(line);
        Stack<LinkedList<String>> stack = new Stack<LinkedList<String>>();
        LinkedList<String> list = new LinkedList<String>();
        int operand = 0;
        int operator = 0;

        while (sc.hasNext()) {
            String str = sc.next();

            if (str.matches("[0-9]+")) {
                operand++;
                stack.push(toList(str));
            } 
            else if (str.equals("+") || str.equals("*")
                    || str.equals("^")) {
                if (stack.size() >= 2) {
                    LinkedList<String> op1 = stack.peek();
                    stack.pop();
                    LinkedList<String> op2 = stack.peek();
                    stack.pop();

                    if (str.equals("+")) {
                        stack.push(toList(add(toString(op1), toString(op2))));
                    } 
                    else if (str.equals("*")) {
                        stack.push(toList(multiply(toString(op1), toString(op2))));
                    } 
                    else if (str.equals("^")) {
                        stack.push(toList(power(toString(op2),
                                    Integer.parseInt(toString(op1)))));
                    }
                }
                operator++;
            }
        }
        if (operand == 0 && operator == 0) {
            list.insert(1, "$");
            stack.push(list);
        } 
        else if (operand != operator + 1) {
            list.insert(1, "&");
            stack.push(list);
        }

        sc.close();
        return stack;
    }

    /**
     * The function takes a string as an argument and convert it to a list
     * 
     * Variable Explanation:
     * list is used to store operands
     * leadingZero is a flag to indicate if the operand has leading zeros
     * allZero is a flag to indicate if the operand is all zeros
     * 
     * @param num The string to be converted
     *
     * @return The converted list(reversed)
     *
     */
    public LinkedList<String> toList(String num) {
        LinkedList<String> list = new LinkedList<String>();
        boolean leadingZero = true;
        boolean allZero = true;

        for (int i = 0; i < num.length(); i++) {
            String digit = num.substring(i, i + 1);
            if (digit.equals("0")) {
                if (!leadingZero) {
                    list.insert(1, digit);
                }
            } 
            else {
                leadingZero = false;
                list.insert(1, digit);
                allZero = false;
            }
        }
        if (allZero) {
            list.insert(1, "0");
        }

        return list;
    }

    /**
     * The function takes a list as an arugment and convert it to a string
     * 
     * Variable Explanation:
     * sb is used to build the string based on the given list
     * 
     * @param list The list to be converted
     * 
     * @return The converted string
     */
    public String toString(LinkedList<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = list.length(); i >= 1; i--) {
            sb.append(list.getEntry(i));
        }
        return sb.toString();
    }

    /**
     * The function takes a string as an arugment and reformat it
     * 
     * Variable Explanation:
     * sc is the Scanner object which will read and traverse the string
     * sb is used to rebuild the string based on the given string
     * 
     * @param str The string to be reformatted
     * 
     * @return The reformatted string
     */
    public String rebuild(String str) {
        Scanner sc = new Scanner(str);
        StringBuilder sb = new StringBuilder();

        while (sc.hasNext()) {
            sb.append(sc.next() + " ");
        }

        sc.close();
        return sb.toString();
    }

    /**
     * The function takes two strings as arguments and add them
     * 
     * Variable Explanation:
     * sb is used to build the string based on the result
     * i is the max index of chars in op1
     * j is the max index of chars in op2
     * remainder is the remainder of each operation
     * sum is the sum of each operation
     * 
     * @param op1 The first operands
     * @param op2 The second operands
     *
     * @return The string which contains the result
     *
     */
    public String add(String op1, String op2) {
        StringBuilder sb = new StringBuilder();
        int i = op1.length() - 1;
        int j = op2.length() - 1;
        int remainder = 0;
        int sum = 0;

        while (i >= 0 || j >= 0 || remainder > 0) {
            sum = remainder;
            if (i >= 0) {
                sum += op1.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += op2.charAt(j) - '0';
            }

            sb = sb.append(sum % 10);
            remainder = sum / 10;
            i--;
            j--;
        }

        return sb.reverse().toString();
    }

    /**
     * The function takes two strings as arguments and multiply them
     *
     * Variable Explanation:
     * arr is the array which stores the result of multiplication
     * sb is used to build the string based on the result
     * i is the max index of chars in op1
     * j is the max index of chars in op2
     * num is the result of each multiplication
     * sum is the sum of current multiplication and 
     * the reamainder of previous operation
     * 
     * @param op1 The first operands
     * @param op2 The second operands
     *
     * @return The string which contains the result
     *
     */
    public String multiply(String op1, String op2) {
        int[] arr = new int[op1.length() + op2.length()];
        StringBuilder sb = new StringBuilder();

        for (int i = op1.length() - 1; i >= 0; i--) {
            for (int j = op2.length() - 1; j >= 0; j--) {
                int num = (op1.charAt(i) - '0') * (op2.charAt(j) - '0');
                int sum = num + arr[i + j + 1];

                arr[i + j] += sum / 10;
                arr[i + j + 1] = (sum) % 10;
            }
        }
        for (int i : arr) {
            if (sb.length() != 0 || i != 0) {
                sb.append(i);
            }
        }

        return sb.length() != 0 ? sb.toString() : "0";
    }

    /**
     * The function takes a string and an integer 
     * as arguments and power them
     *
     * Variable Explanation:
     * half is the new exponent
     * 
     * @param op1 The first operands
     * @param op2 The second operands
     *
     * @return The string which contains the result
     */
    public String power(String op1, int op2) {
        if (op2 == 0) {
            return "1";
        }

        String half = power(op1, op2 / 2);

        if (op2 % 2 == 0) {
            return multiply(half, half);
        } 
        else {
            return multiply(multiply(half, half), op1);
        }
    }
}
