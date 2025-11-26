// Scenario 1
public class Student {
    String name;
    int age;
    public void printStudentInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
    public Student() {
        name = "Unknown";
        age = 18;
    }
    
}
// Explanation: Java automatically provides a "default constructor" when no constructor is defined manually.Instance variables of reference types (like String) are initialized to 'null'.Instance variables of numeric types (like int) are initialized to 0.Therefore, no error occurs, and we see default values printed.

