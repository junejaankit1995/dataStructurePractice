package stream;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class MainClass {

    /*
    Question : Group Students by range of marks Consider List<Student> * class.
    Class Student{Integer mark, String name} Result should be group * students based on marks range.
    Group name generation needs to be done by * using below pattern/logic.
    Marks range start to end(inclusive)->Group name * 90 to 99 = G9 80 to 89 = G8 70 to 79 = G7 60 to 69 = G6 50 to 59 = G5 40 to * 49 = G4 30 to 39 = G3 20 to 29 = G2 10 to 19 = G1 0 to 9 = G0 Ex. List of * students are [["S1",99],["S2",94],["S3",84],["S4",85]]
    Result - * Map<GroupName,List<StudentNames>>=Map<String,List<String>> G9=>["S1","S2"] * G8=>["S3","S4"]
 */Map<String, List<String>> getMapFromList(List<Student> list) {
        return list.stream()
                .collect(Collectors.groupingBy(MainClass::getGroupName,
                        Collectors.mapping(Student::getName, Collectors.toList())));
    }

    static String getGroupName(Student student) {
        return "G" + ((int) student.getMarks() / 10);
    }

    /*
     Find all employees by salary : Given List<Employee> objects,
     where each employee has salary and name Convert this List into some data structure in JAVA,
     using that we can query or find all employees who are having some salary=X efficiently.
     Efficiently means here you should not be iterating this List every time we give new input,
     instead convert List to some another format/data-structure which has less retrieval time
     or say O(1), use this new data-structure to query employee names for salary 'X'.
     */
    Map<Long, List<Employee>> getEmployeeMapFromList(List<Employee> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Employee::getSalary));
    }

    Collection<List<Employee>> subList(List<Employee> input) {
        return input.stream().collect(
                Collectors.groupingBy(
                        this::getGroupKey
                )).values();
    }

    private String getGroupKey(Employee input) {
        Integer integer = Integer.valueOf(input.getName().replace("Demo", ""));
        int n = integer.intValue();
        int val = n / 10;
        return String.valueOf(val);

    }

    public static void main(String[] args) {
        MainClass obj = new MainClass();
        Map<String, List<String>> result = obj.getMapFromList(Student.getStudentList(100));
        List<Employee> employeeList = Employee.getEmployeeList(100);
        System.out.println(result);
        Map<Long, List<Employee>> result2 = obj.getEmployeeMapFromList(employeeList);
        System.out.println(result2);
        Collection<List<Employee>> result3 = obj.subList(employeeList);
        System.out.println(result3);
    }
}
