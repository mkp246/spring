package spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Test {
    public static void main(String args[]){
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'hello SPEL'.concat('!!')");
        String message = (String) expression.getValue();
        System.out.println(message);
        byte[] bytes = (byte[])parser.parseExpression("'hello world'.bytes").getValue();
        for (byte b : bytes){
            System.out.print(b + " ");
        }
        System.out.println();
        System.out.println(parser.parseExpression("'hello world'.bytes.length").getValue());
        System.out.println(parser.parseExpression("new String('hello world').toUpperCase()").getValue(String.class));

        System.out.println(parser.parseExpression("'hello world ' + 'to you'").getValue(String.class));
        System.out.println(parser.parseExpression("10*5/2+3").getValue());
        System.out.println(parser.parseExpression("'today is: ' + new java.util.Date()").getValue());

        System.out.println(parser.parseExpression("true or false").getValue());
        System.out.println(parser.parseExpression("'snoo'.length()==4").getValue());

        System.out.println("===========================");

        Calculation calculation = new Calculation();
        StandardEvaluationContext context = new StandardEvaluationContext(calculation);
        parser.parseExpression("number").setValue(context, 5);
        System.out.println(calculation.cube());
    }
}
