package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.*;

public class StudentManagementSystem extends Student{

    private static final Logger logger = Logger.getLogger(StudentManagementSystem.class.getName());
    private final ArrayList<String> students;

    public StudentManagementSystem() {
        super(logger.getName());
        this.students = new ArrayList<>();
        setupLogger();

        students.add("Maryam");
        students.add("Aron");
        students.add("Marcel");
        students.add("Kai");

        logger.config("Students added.");

    }
    private static void setupLogger() {
        // TODO: Configure the logger
        // 1. Set the global logging level.
        // 2. Add a ConsoleHandler to log messages to the console.
        // 3. Add a FileHandler to log messages to a file named "students.log".
        // 4. Use SimpleFormatter to format the log messages.

        // 1.:
        logger.setLevel(Level.ALL);

        // 2.:
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new CustomLogFormatter());
        logger.addHandler(consoleHandler);


        // 3.:
        try {
            FileHandler fileHandler = new FileHandler("students.log");
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new CustomLogFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();

        }

        // 4.:
        SimpleFormatter formatter = new SimpleFormatter();
    }

    public ArrayList<String> addStudents(String studentName) {
        // TODO: Add the student to the list and log an INFO message.
        students.add(studentName);
        logger.log(Level.INFO, "Student added: {0}", studentName);
        return students;

    }

    public void removeStudent(String studentName) {
        // TODO: Remove the student from the list if they exist.
        // Log a WARNING message if the student does not exist.
        if (students.remove(studentName)) {
            logger.log(Level.INFO, "Student removed: {0}", studentName);
        } else {
            logger.log(Level.WARNING, "Student does not exist: {0}", studentName);
        }
    }

    public int getStudentCount() {
            // TODO: Log a FINE message indicating the count is being fetched.
            // Return the current number of students in the system.
            logger.log(Level.FINE, "Fetching the student count.");
            return students.size();
        }

        public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();

        // TODO: Add test cases to:
        // 1. Add students.
        // 2. Remove students.
        // 3. Print the total number of students.
        // Observe how logs are generated at different levels.

            sms.addStudents("Emily");
            sms.addStudents("Jack");
            sms.removeStudent("Jack");
            System.out.println("Total students: " + sms.getStudentCount());


        }
}