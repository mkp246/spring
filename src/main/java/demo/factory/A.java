package demo.factory;

public class A implements Printable{
    private static final A a = new A();

    protected A() {
        System.out.println("private constructor");
    }
    public static A getA() {
        System.out.println("factory method");
        return a;
    }
    public void msg(){
        System.out.println("hello user : class A");
    }

    @Override
    public void print() {
        System.out.println("hello a");
    }
}
