package demo;

import java.util.List;

public class Question {
    private int id;
    private String name;
    private List<Answer> answers;

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", answers=" + answers.toString() +
                '}';
    }

    public Question() {
    }

    public Question(int id, String name, List<Answer> answers) {

        this.id = id;
        this.name = name;
        this.answers = answers;
    }
}
