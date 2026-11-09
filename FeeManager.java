import java.util.ArrayList;

public class FeeManager {

    private ArrayList<Student> students = new ArrayList<>();

    // Add student
    public boolean addStudent(Student student) {
        if (findStudent(student.getId()) != null) {
            return false;
        }

        students.add(student);
        return true;
    }

    // Find student using ID
    public Student findStudent(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }

        return null;
    }

    // Display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    // Search student by name or ID
    public void searchStudent(String keyword) {
        boolean found = false;

        for (Student s : students) {
            if (s.getName().toLowerCase()
                    .contains(keyword.toLowerCase())
                    || s.getId().equalsIgnoreCase(keyword)) {

                s.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }

    // Filter students by payment status
    public void filterByStatus(String status) {
        boolean found = false;

        for (Student s : students) {
            if (s.getPaymentStatus().equalsIgnoreCase(status)) {
                s.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students found with this status.");
        }
    }

    // Record payment
    public void recordPayment(String id, double amount) {
        Student s = findStudent(id);

        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        if (s.addPayment(amount)) {
            System.out.println("Payment recorded successfully!");
            System.out.println("Remaining Balance: Rs." + s.getBalance());
            System.out.println("Payment Status: " + s.getPaymentStatus());
        } else {
            System.out.println("Invalid amount! Check the payment and remaining balance.");
        }
    }
}
