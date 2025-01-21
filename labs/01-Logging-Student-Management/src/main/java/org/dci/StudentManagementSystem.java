package org.dci;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class StudentManagementSystem {

    private static final Logger logger =
            Logger.getLogger(StudentManagementSystem.class.getName());
    private List<String> students;

    public StudentManagementSystem() throws IOException {
        this.students = new ArrayList<>();
        setupLogger();
    }

    private static void setupLogger() throws IOException {
        // TODO: Configure the logger
        // 1. Set the global logging level.
        // 2. Add a ConsoleHandler to log messages to the console.
        // 3. Add a FileHandler to log messages to a file named "students.log".
        // 4. Use SimpleFormatter to format the log messages.
        logger.setLevel(Level.WARNING);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.WARNING);
        consoleHandler.setFormatter(new CustomFormatter());

        logger.addHandler(consoleHandler);

        FileHandler fileHandler = new FileHandler("students.log", true);
        fileHandler.setLevel(Level.ALL);
        fileHandler.setFormatter(new CustomFormatter());
        logger.addHandler(fileHandler);
    }

    public void addStudent(String studentName) {
        // TODO: Add the student to the list and log an INFO message.
        try {
            if (studentName == null || studentName.isBlank()) {
                throw new IllegalArgumentException("Student name cannot be null or empty");
            }

            if (students.contains(studentName)) {
                logger.log(Level.WARNING, "Student: {0} already exists in the list", studentName);
                return;
            }

            students.add(studentName);
            logger.log(Level.INFO, "Student: {0} successfully added to the list", studentName);

        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "Error adding student: {0}", e.getMessage());
        }
    }

    public void removeStudent(String studentName) {
        // TODO: Remove the student from the list if they exist.
        // Log a WARNING message if the student does not exist.
        try {
            if (studentName == null || studentName.isBlank()) {
                throw new IllegalArgumentException("Student name cannot be null or empty");
            }

            if (!students.contains(studentName)) {
                logger.log(Level.WARNING, "Student: {0} does not exist in the list", studentName);
                return;
            }

            students.remove(studentName);
            logger.log(Level.INFO, "Student: {0} successfully removed from the list", studentName);

        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "Error removing student: {0}", e.getMessage());
        }
    }

    public int getStudentCount() {
        // TODO: Log a FINE message indicating the count is being fetched.
        logger.log(Level.FINE, "Fetching the count of students");
        // Return the current number of students in the system.
        return students.size(); // Replace with the actual count.
    }

    public static void main(String[] args) throws IOException {
        StudentManagementSystem sms = new StudentManagementSystem();

        // TODO: Add test cases to:
        logger.log(Level.INFO, "Starting Student Management System tests");

        // 1. Add students.
        sms.addStudent("Maryam");
        sms.addStudent("John");
        sms.addStudent("Amir");
        sms.addStudent("Amir");
        sms.addStudent("");
        sms.addStudent(null);

        // 2. Remove students.
        sms.removeStudent("John");
        sms.removeStudent("Alice");
        sms.removeStudent("Maryam");
        sms.removeStudent(null);

        // 3. Print the total number of students.
        System.out.println("Total students: " + sms.getStudentCount());
        logger.log(Level.INFO, "Total students in the system: {0}", sms.getStudentCount());
    }
}