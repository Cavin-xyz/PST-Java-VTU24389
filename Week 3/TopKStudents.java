
import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    String getName() {
        return name;
    }

    int getMarks() {
        return marks;
    }
}

public class TopKStudents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String name = parts[0];
            int marks = Integer.parseInt(parts[1]);
            students.add(new Student(name, marks));
        }

        int k = sc.nextInt();
        sc.close();

        String result = students.stream()
                .sorted(Comparator.comparingInt(Student::getMarks).reversed()
                        .thenComparing(Student::getName))
                .limit(k)
                .map(Student::getName)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}
