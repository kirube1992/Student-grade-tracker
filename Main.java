import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;

class Main {
    public static void main(String a[]) {
        Scanner scanner = new Scanner(System.in);
        School school = new School();
       System.out.println("Enter Your name");
       String name = scanner.nextLine();
       System.out.println("Enter Your ID");
       String id = scanner.nextLine();
       System.out.println("Enter Your Grade");
       double grade = scanner.nextDouble();
       Student stud = new Student(grade, name, id);
       school.addStudent(stud);
    //    school.addStudent(new Student(45, "kiru", "Et1234"));
       school.displayAllStudents();
    //    System.out.println(school.findStudentById("Et1234"));

    }
}

