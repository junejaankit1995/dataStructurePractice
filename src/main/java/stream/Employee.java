package stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Employee {

    private String name;
    private long salary;


    public Employee(Integer salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long marks) {
        this.salary = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Employee> getEmployeeList(int size) {
        return IntStream.range(0, size)
                .mapToObj(value -> new Employee(((value % 10) * 1000), "Demo" + value))
                .collect(Collectors.toList());
    }

}
