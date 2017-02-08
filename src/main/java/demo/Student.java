package demo;

public class Student {
    private String name;
    private int id;
    private Address address;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Student() {
        System.out.println("def cons");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", address=" + address.toString() +
                '}';
    }

    public Student(String name, int id, Address address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public Student(int id) {
        this.id = id;
    }

    public Student(String name) {
        this.name = name;
    }

    public void displayInfo(){
        System.out.println("Hello: "+ name + " " + id);
    }
}
