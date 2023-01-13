package org.codewars.mathevaluator;


public class MathEvaluator {
    public double calculate(String expression) {
        expression = expression.replaceAll(" ", "").replaceAll("--", "+");
        String[] array = expression.split("");
        if(expression.contains("(")) {
            for(int i = 0; i < array.length; i++) {
                //Search for begin parenthesis
                if (array[i].equals("(")) {
                    int indexStart = i;
                    int indexEnd = 0;
                    //Search for last parenthesis, but if find new beginning parenthesis change indexStart
                    for (int j = i; j < array.length; j++) {
                        if (array[j].equals("(")) {
                            indexStart = j;
                        } else if (array[j].equals(")")) {
                            indexEnd = j;
                            break;
                        }
                    }
                    String insideExpression = expression.substring(indexStart + 1, indexEnd);
                    double insideResult = calculate(insideExpression);
                    expression = stringReplacer(expression, indexStart, indexEnd, String.valueOf(insideResult))
                            .replaceAll("--", "+")
                            .replaceAll("\\+\\+", "+")
                            .replaceAll("/\\+", "/")
                            .replaceAll("\\*\\+", "*")
                            .replaceAll("-\\+", "-");
                    array = expression.split("");
                    i = -1;
                }
            }
        }
        //First reduce all multiplying and divisions
        expression = commonExpressionReducer(expression, true);
        //Second reduce all substractions and additions
        expression = commonExpressionReducer(expression, false);

        //Cast result
        return Double.parseDouble(expression);
    }

    public String commonExpressionReducer(String expression, boolean isMultiplication) {
        String operator1 = "+";
        String operator2 = "-";
        if(isMultiplication) {
            operator1 = "*";
            operator2 = "/";
        }
        String[] array = expression.split("");
        for(int i = 0; i < array.length; i++) {
            if(i==0 && array[i].equals("-") && !isMultiplication) continue;
            if(array[i].equals(operator1) || array[i].equals(operator2)) {
                String operator = array[i];
                //find first number
                String firstNumber = "";
                int j = i-1;
                while( j >= 0 && (isNumeric(array[j]) || array[j].equals("."))) {
                    firstNumber = array[j] + firstNumber;
                    j--;
                }
                //check if character j have minus
                if(j >= 0 && array[j].equals("-") && (j == 0 || isNumeric(array[j-1]))) {
                    firstNumber = array[j] + firstNumber;
                    j--;
                }
                //Correcting j
                j = j + 1;

                //find second number
                String secondNumber = "";
                int q = i+1;
                while(q < array.length
                        && (array[q].equals(".") || isNumeric(array[q]) || (q == i+1 && array[q].equals("-")))) {
                    secondNumber += array[q];
                    q++;
                }

                //Correcting q
                q = q -1;

                //Calculate expression, but if one string is empty for example expression +4, change to 0.0 value
                if(secondNumber.isEmpty()) secondNumber = "0.0";
                if(firstNumber.isEmpty()) firstNumber = "0.0";
                //System.out.println("firstNumber: "+ firstNumber + ", secondNumber: " + secondNumber + ", operator: " + operator +
                //        ", result: " + "res" + ", j: " + j + ", q: " + q + ", expression: " + expression);

                double result = trivialCalculate(Double.parseDouble(firstNumber), operator, Double.parseDouble(secondNumber));
                String reducedExpression = stringReplacer(expression, j, q, String.valueOf(result));
                expression = reducedExpression;
                array = expression.split("");
                i = -1;
            }
        }

        return expression;
    }
    public String stringReplacer(String expression, int index1, int index2, String replacer) {
        String part1 = expression.substring(0, index1);
        String part2 = expression.substring(index2 + 1);
        return part1 + replacer + part2;
    }

    public String reverseString(String str) {
        String[] array = str.split("");
        for(int i = 0; i < array.length / 2.0; i++) {
            String temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return String.join("", array);
    }

    public double trivialCalculate(double firstNumber,
                                   String operator,
                                   double secondNumber) throws ArithmeticException{
        switch(operator) {
            case "*": return firstNumber * secondNumber;
            case "/": return firstNumber / secondNumber;
            case "+": return firstNumber + secondNumber;
            case "-": return firstNumber - secondNumber;
        }
        throw new ArithmeticException();
    }

    public boolean isNumeric(String str) {
        String[] array = str.split("");
        int index = -1;
        for(String s : array) {
            index++;
            if(index == 0 && s.equals("-") && array.length > 1)
                continue;
            if(!(s.codePointAt(0) >= 48 && s.codePointAt(0) <= 57))
                return false;
        }
        return true;
    }


}
