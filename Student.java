import java.util.Arrays;

public class Student {

    private double[] grade;
    private String name;
    private  String id;

    

    public Student(double[] grade, String name, String id) {
            if (grade == null) {
            throw new IllegalArgumentException("Grades array cannot be null.");
        }
        if (grade.length != 4) { // Or use a constant like NUM_GRADES
            throw new IllegalArgumentException("Grades array must have exactly 4 elements.");
        }
        this.grade = Arrays.copyOf(grade, grade.length); // Deep copy
        this.grade = grade;
        this.name = name;
        this.id = id;
    }

    public void setGrades(double[] newGrades) {
        if (newGrades == null) {
            throw new IllegalArgumentException("Grades array cannot be null.");
        }
        if (newGrades.length != 4) {
            throw new IllegalArgumentException("Grades array must have exactly 4 elements.");
        }
        this.grade = Arrays.copyOf(newGrades, newGrades.length); // Deep copy
    }

    public double[] getGrades() {
        return Arrays.copyOf(this.grade, this.grade.length); // Return a copy
    }

    public double getGrade(int index) {
        if (index < 0 || index >= this.grade.length) {
            throw new IndexOutOfBoundsException("Invalid grade index: " + index);
        }
        return this.grade[index];
    }

    public void setGrade(int index, double newGrade) {
        if (index < 0 || index >= this.grade.length) {
            throw new IndexOutOfBoundsException("Invalid grade index: " + index);
        }
        this.grade[index] = newGrade;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String getName() {
        return name;
    }

    public String setId(String id) {
       this.id = id;
       return id;
    }

    public String getId() {
        return id;
    }

    public double averageGrade(double[] arr) {
        double x=0;
        for(int i=0;i<arr.length;i++) {
            x += arr[i];
        }
        return x/arr.length;
    }

    public String result(double averageGrade) {
        if(averageGrade > 50) {
            return "Pass";
        } else {
            return "fall";
        }
    }

    // @Override 
    // public String toString() {
    //     return "Student{" +
    //             "name='" + name + '\'' +
    //             ", id=" + id +
    //             ", grade=" + grade +
    //             '}';
    // }
    @Override
    public String toString() {
        return "Student{name='" + name + "', id='" + id + "', grades=" + Arrays.toString(grade) + '}';
    }

}
