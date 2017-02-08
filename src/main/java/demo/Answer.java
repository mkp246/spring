package demo;

public class Answer {
    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", by='" + by + '\'' +
                '}';
    }

    public Answer() {
    }

    public Answer(int id, String name, String by) {

        this.id = id;
        this.name = name;
        this.by = by;
    }

    private int id;
    private String name;
    private String by;
}
