package stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Student {

    private Integer marks;
    private String name;

    public Student(Integer marks, String name) {
        this.marks = marks;
        this.name = name;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Student> getStudentList(int size) {
        return IntStream.range(0, size)
                .mapToObj(value -> new Student(value, "Demo" + value))
                .collect(Collectors.toList());
    }

}
