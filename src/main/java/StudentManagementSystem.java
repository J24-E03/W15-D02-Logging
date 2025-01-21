import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.*;

public class StudentManagementSystem {
    private static final Logger logger = Logger.getLogger(StudentManagementSystem.class.getName());
    private List<String> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
        setupLogger();
    }

    private void setupLogger() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(consoleHandler);

        try {
            FileHandler fileHandler = new FileHandler("students.log", true);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to setup file handler", e);
        }
        try {
            FileHandler fileHandler = new FileHandler("students.log", true);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new CustomLogFormatter());  // Use custom formatter
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to setup file handler", e);
        }
    }


    public void addStudent(String studentName) {
        try {
            if (studentName == null || studentName.trim().isEmpty()) {
                throw new IllegalArgumentException("Student name cannot be null or empty.");
            }
            students.add(studentName);
            logger.log(Level.INFO, "Added student: {0}", studentName);
        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "Invalid operation: " + e.getMessage(), e);
        }
    }
    public void removeStudent(String studentName) {
        try {
            if (studentName == null || studentName.trim().isEmpty()) {
                throw new IllegalArgumentException("Student name cannot be null or empty.");
            }

            if (students.contains(studentName)) {
                students.remove(studentName);
                logger.log(Level.INFO, "Removed student: {0}", studentName);
            } else {
                logger.log(Level.WARNING, "Attempted to remove a non-existing student: {0}", studentName);
            }
        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "Invalid operation: " + e.getMessage(), e);
        }
    }

    public int getStudentCount() {
        logger.log(Level.FINE, "the count is being fetched");
        return students.size();
    }


    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.addStudent("Rob");
        sms.addStudent("Bob");
        sms.addStudent("Jenny");

        sms.removeStudent("Bob");
        sms.removeStudent("Andrew");

        int count = sms.getStudentCount();
        System.out.println("Total Students: " + count);

    }
}
