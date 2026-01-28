import java.util.*;

class Student {
    int id;
    String name;
    double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    int getId() { return id; }
    String getName() { return name; }
    double getCgpa() { return cgpa; }
}

public class Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            double cgpa = sc.nextDouble();
            students.add(new Student(id, name, cgpa));
        }
        sc.close();

        students.sort(Comparator
                .comparingDouble(Student::getCgpa).reversed()
                .thenComparing(Student::getName)
                .thenComparingInt(Student::getId));

        for (Student s : students) {
            System.out.println(s.getName());
        }
    }
}
