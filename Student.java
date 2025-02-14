
public class Student {

    private double grade;
    private String name;
    private  String id;

    public Student(double grade, String name, String id) {
        this.grade = grade;
        this.name = name;
        this.id = id;
    }

    public double setGrade(double grade) {
       this.grade = grade;
       return grade;
    }

    public double getGrade() {
        return this.grade;
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

    @Override 
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", grade=" + grade +
                '}';
    }

}
