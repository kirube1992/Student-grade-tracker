import java.util.ArrayList;
import java.util.List;

public class School {
        private final List<Student>  students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the school.");
            return;
        }

        for (Student student : students) {
            System.out.println(student); 
        }
    }

    public Student findStudentById(String id) {
        for(Student student:students) {
            if(student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
}
