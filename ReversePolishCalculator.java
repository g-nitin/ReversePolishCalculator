/*
Nitin Gupta
Lab 04

Reverse Polish Calculator!
 */

public class ReversePolishCalculator{

    LLStack<Integer> valueStack;

    public ReversePolishCalculator()
    {
        this.valueStack = new LLStack<Integer>();
    }

    public int calculate(String expression)
    {
        valueStack = new LLStack<>(); // reset the stack

        String[] expArray = expression.split(""); // make the input into an array

        for (int i = 0; i<expArray.length; i++) // loop through the array
        {
            try
            {
                // if an operator at the index
                if (expArray[i].equals("+") || expArray[i].equals("-") ||
                        expArray[i].equals("*") || expArray[i].equals("/"))
                {
                    if (valueStack.size() >= 2) // if operation can be performed...
                        valueStack.push( performCalculation(expArray[i]) );

                    else // not enough values in the stack...
                    {
                        System.out.println("This was not properly formatted. " +
                                "There were too many operators and not enough numbers");
                        return 0;
                    }
                }

                // else if just a spacing then do nothing
                else if (expArray[i].contains(" ") || expArray[i].equals("\t"))
                {
                    continue;
                }

                // else it is a number
                else
                {
                    Integer anExpression = Integer.parseInt( expArray[i] );
                    valueStack.push(anExpression); // add to the stack
                }
            }

            // if Integer.parseInt() throws an error
            catch (NumberFormatException n)
            {
                System.out.println("The expression was not formatted correctly." +
                        " It contains a character that is not numeric and " +
                        "is not one of the math operators named.");
                return 0;
            }
        }

        if (valueStack.size() == 1)
            return valueStack.peek();

        else
        {
            System.out.println("The expression was not formatted properly." +
                    " There were too many operators and not enough numbers");
            return 0;
        }

    }

    /**
     * Performs calculation on the last 2 numbers in the valueStack
     * @param operation the operation to be performed
     * @return the result of the operation
     */
    private int performCalculation(String operation)
    {
        int expression3 = 0;

        int expression2 = valueStack.pop();
        int expression1 = valueStack.pop();

        switch (operation)
        {
            case "+":
                expression3 = expression1 + expression2;
                break;

            case "-":
                expression3 = expression1 - expression2;
                break;

            case "*":
                expression3 = expression1 * expression2;
                break;

            case "/":
                if (expression2 == 0)
                {
                    System.out.println("Division by 0 is not possible!");
                    return 0;
                }

                else
                    expression3 = expression1 / expression2;
                break;
        }

        return expression3;
    }

}
