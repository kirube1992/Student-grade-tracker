import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;
import java.io.*;

public class School {
    private final List<Student>  students = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

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

    // public void deleteStudent(String id) {

    //     boolean found = false;
    //     for(Student student: students) {
    //         if(student.getId().equals(id)) {
    //             students.remove(student);
    //             System.out.println("The student with ID " + id + " has been removed.");
    //             found = true;
    //             break;
    //         }
    //     }

    //     if(!found){
    //         System.out.println("there is no student with suach" + id );
    //     }
    // }

    public void deleteStudent(String id) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId().equals(id)) {
                iterator.remove(); // Safe removal during iteration
                System.out.println("The student with ID " + id + " has been removed.");
                return; // Exit after removing
            }
        }
        System.out.println("There is no student with such ID: " + id);
    }


    // public void updateStudent(String id) {
    //     boolean found = false;
    //     for(int i=0;i<students.size();i++) {
    //         if(students.get(i).equals(id)) {
    //             try{
    //             System.out.println("Enter Your  new name");
    //             String name = scanner.nextLine();
    //             System.out.println("Enter Your ID");
    //             String newId = scanner.nextLine();
    //             System.out.println("Enter Your Grade");
    //             double grade = scanner.nextDouble(); 
    //             students.get(i).setName(name);
    //             students.get(i).setId(newId);
    //             students.get(i).setGrade(grade);
    //             found = true;
    //             System.out.println("Student with ID " + id + " updated.");
    //             return;
    //             }catch (NumberFormatException e) {
    //                 System.out.println("Invalid grade input.  Please enter a valid number.");
    //                 return;
    //             } finally {
    //                 scanner.close();
    //             }
    //         }
    //     }
    //         if(!found) {
    //             System.out.println("there is no student with suach" + id );
    //         }
    // }
    public void updateStudent(String id) {
        Scanner scanner = new Scanner(System.in); // Create Scanner locally
        try{
            Student studentToUpdate = findStudentById(id); // Use findStudentById!
            if (studentToUpdate == null) {
                System.out.println("There is no student with such ID: " + id);
                return;
            }

            System.out.print("Enter new name (leave blank to keep current): ");
            String newName = scanner.nextLine();
            if (!newName.trim().isEmpty()) { // Only update if not blank
                studentToUpdate.setName(newName);
            }

            System.out.print("Enter new ID (leave blank to keep current): ");
            String newId = scanner.nextLine();
            if (!newId.trim().isEmpty()) { // Only update if not blank
                studentToUpdate.setId(newId);
            }

            System.out.println("Enter new grades (or leave blank to keep current):");
            double[] newGrades = new double[4]; // Assuming 4 grades
            boolean gradesChanged = false;
            for (int i = 0; i < 4; i++) {
                while(true){
                    try {
                        System.out.print("Enter new grade for subject " + (i + 1) + " (or leave blank): ");
                        String gradeInput = scanner.nextLine();

                        if (gradeInput.trim().isEmpty()) {
                            newGrades[i] = studentToUpdate.getGrade(i); // Keep the current grade
                            break;

                        } else {
                            newGrades[i] = Double.parseDouble(gradeInput);
                            if (newGrades[i] < 0 || newGrades[i] > 100){
                                 System.out.println("The grade should be between 0 to 100");
                            }else {
                                gradesChanged = true;
                                break;
                            }

                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number or leave blank.");
                    }
                }
            }

            if(gradesChanged){
                studentToUpdate.setGrades(newGrades); // Update with the new grades array
            }


            System.out.println("Student updated successfully.");
        }finally {
            scanner.close();
        }
    }

    public void saveData(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student student : students) {
                // Format: name,id,grade1,grade2,grade3,grade4
                writer.print(student.getName() + ",");
                writer.print(student.getId() + ",");
                double[] grades = student.getGrades();
                for (int i = 0; i < grades.length; i++) {
                    writer.print(grades[i]);
                    if (i < grades.length - 1) {
                        writer.print(","); // Add comma between grades
                    }
                }
                writer.println(); // Newline for next student
            }
        } catch (IOException e) {
            System.err.println("Error saving data to file: " + e.getMessage());
        }
    }

    public void loadData(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Split the line by commas
                if (parts.length >= 6) { // Ensure enough parts (name, id, 4 grades)
                    String name = parts[0];
                    String id = parts[1];
                    double[] grades = new double[4];
                    try {
                        for (int i = 0; i < 4; i++) {
                            grades[i] = Double.parseDouble(parts[i + 2]); // Parse grades
                        }
                        Student student = new Student(grades, name, id); // Create Student object
                        students.add(student); // Add to the list
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping invalid line: " + line);
                        // Or, you might choose to throw an exception or terminate
                    }
                } else {
                     System.err.println("Skipping invalid line: " + line);
                }
            }
        } catch (FileNotFoundException e){
              System.err.println("File not found: " + e.getMessage() + ". It's OK if this is the first run.");
        }catch (IOException e) {
            System.err.println("Error reading data from file: " + e.getMessage());
        }
    }
}
