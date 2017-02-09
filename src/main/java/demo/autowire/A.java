package demo.autowire;

public class A {
    private B b;

    public A() {
        System.out.println("a created");
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public void print(){
        System.out.println("hello a");
    }

    public void display(){
        this.print();
        this.b.print();
    }
}
