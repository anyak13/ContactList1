// Anya Kothari
public class Student extends Person {
    private int grade;

    // Constructor that calls the super constructor and sets grade
    public Student(String firstName, String lastName, String phoneNumber, int grade) {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    // ToString method that overrides the Person toString method
    @Override
    public String toString() {
        return super.toString() + " Grade: " + grade;
    }
}
