import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.io.*;
import java.util.Scanner;

class Main {
    public static void main(String a[]) {
        Scanner scanner = new Scanner(System.in);
        School school = new School();

        school.loadData("students.txt");

        school.addStudent(new Student(new double[]{75, 80, 85, 90}, "kiru", "Et1234"));
        System.out.println("Welcome to Student grade managmetn");
        System.out.println("do want add student press 1");
        System.out.println("do want display all student press 2");
        System.out.println("do want find student press 3");
        System.out.println("do want delete  student press 4");
        System.out.println("do want update  student press 5");

        int chosse = -1;
        try {
            chosse = scanner.nextInt();
         } catch(InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number between 1 and 5.");
            scanner.nextLine();
            return;
         }
        scanner.nextLine();
        switch (chosse) {
        
        //     case 1:
        //     try{
        //     System.out.println("Enter Your name");
        //     String name = scanner.nextLine();
        //     System.out.println("Enter Your ID");
        //     String id = scanner.nextLine();
        //     System.out.println("Enter Your Grade");
        //     double grade = Double.parseDouble(scanner.nextLine());
        //     Student stud = new Student(grade, name, id);
        //     school.addStudent(stud);
        // } catch(NumberFormatException e) {
        //     System.out.println("Invalid input, pleas insert valid input");
        // }
        //         break;

            case 1:
            try {
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();

                System.out.print("Enter student ID: ");
                String id = scanner.nextLine();

                double[] grades = new double[4]; // Assuming 4 grades
                for (int i = 0; i < 4; i++) {
                    while(true){
                        try{
                            System.out.print("Enter grade " + (i + 1) + ": ");
                            grades[i] = Double.parseDouble(scanner.nextLine());

                            if(grades[i] < 0 || grades[i] > 100){
                                System.out.println("The grade should be between 0 to 100");
                            } else {
                                break; // Exit the inner loop if grade is valid
                            }
                        }catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a number.");
                        }

                    }

                }

                Student stud = new Student(grades, name, id); // Use the array
                school.addStudent(stud);
                System.out.println("Student added successfully.");

            } catch (NumberFormatException e) {
                System.out.println("Invalid grade input. Please enter valid numbers.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error adding student: " + e.getMessage()); // Catch potential errors from Student constructor
            }
            break;

            case 2:
                school.displayAllStudents();
                break;
            case 3:
                // System.out.println("what is the student id");
                // String newid = scanner.nextLine();
                // school.findStudentById(newid);
                // break;
                System.out.print("Enter student ID to search: ");
                String searchId = scanner.nextLine();
                Student foundStudent = school.findStudentById(searchId);
                if (foundStudent != null) {
                    System.out.println("Student found: " + foundStudent); // toString() will be called
                } else {
                    System.out.println("Student with ID " + searchId + " not found.");
                }
                break;
            case 4:
                System.out.println("what is the student id you want delete");
                String nid = scanner.nextLine();
                school.deleteStudent(nid);
                break;
            case 5:
                System.out.println("what is the student id you want Update");
                String nidw = scanner.nextLine();
                school.updateStudent(nidw);
                break;
            default:
                break;
        }
    }
}

