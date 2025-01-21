package org.dcistudent;

import lombok.NonNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.*;

@NonNull
public class StudentManagementSystem {
  private static final Logger logger = Logger.getLogger(StudentManagementSystem.class.getName());
  private final List<String> students;

  public StudentManagementSystem() throws IOException {
    this.students = new ArrayList<>();
    StudentManagementSystem.setupLogger();
  }

  private static void setupLogger() throws IOException {
    // 1. Set the global logging level.
    // 2. Add a ConsoleHandler to log messages to the console.
    // 3. Add a FileHandler to log messages to a file named "students.log".
    // 4. Use SimpleFormatter to format the log messages.
    StudentManagementSystem.logger.setLevel(Level.ALL);

    ConsoleHandler consoleHandler = new ConsoleHandler();
    consoleHandler.setLevel(Level.ALL);
    consoleHandler.setFormatter(new SimpleFormatter());
    StudentManagementSystem.logger.addHandler(consoleHandler);

    FileHandler fileHandler = new FileHandler("students.log");
    fileHandler.setLevel(Level.ALL);
    fileHandler.setFormatter(new SimpleFormatter());
    StudentManagementSystem.logger.addHandler(fileHandler);

    ConsoleHandler consoleHandler2 = new ConsoleHandler();
    consoleHandler2.setLevel(Level.ALL);
    consoleHandler2.setFormatter(new CustomLogger());
    StudentManagementSystem.logger.addHandler(consoleHandler2);
  }

  public void addStudent(String studentName) {
    Optional.ofNullable(studentName).orElseThrow(() -> {
      StudentManagementSystem.logger.log(Level.SEVERE, "addStudent(): Student name cannot be null.");
      return new IllegalArgumentException("addStudent(): Student name cannot be null.");
    });

    this.students.add(studentName);
    StudentManagementSystem.logger.log(Level.INFO, "Added student: {}", studentName);
  }

  public void removeStudent(String studentName) {
    Optional.ofNullable(studentName).orElseThrow(() -> {
      StudentManagementSystem.logger.log(Level.SEVERE, "removeStudent(): Student name cannot be null.");
      return new IllegalArgumentException("removeStudent(): Student name cannot be null.");
    });

    // Log a WARNING message if the student does not exist.
    this.students.remove(studentName);
    StudentManagementSystem.logger.log(Level.WARNING, "Removed student: {}", studentName);
  }

  public int getStudentCount() {
    StudentManagementSystem.logger.log(Level.FINE, "Fetching student count.");
    // Return the current number of students in the system.
    return this.students.size(); // Replace with the actual count.
  }

  public static void main(String[] args) throws IOException {
    StudentManagementSystem sms = new StudentManagementSystem();

    // 1. Add students.
    // 2. Remove students.
    // 3. Print the total number of students.
    // Observe how logs are generated at different levels.
    sms.addStudent("Alice");
    sms.addStudent("Bob");
    sms.addStudent("Charlie");
    sms.removeStudent("Bob");
    sms.getStudentCount();
    sms.removeStudent(null);
  }
}