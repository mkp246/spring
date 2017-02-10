package demo.aop;

public class Validator {
    public void validate(int age){
        if(age<18)throw new ArithmeticException("under age");
        else System.out.println("vote confirmed");
    }
}
