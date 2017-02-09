package demo.factory;

public class PrintableFactory {
    public static Printable getPrintable(){
//        return new A();
        return new B();
    }

    public Printable getPrintable(String a){
        System.out.println("non static factory method : param passed = "+ a);
        return new A();
    }
}
