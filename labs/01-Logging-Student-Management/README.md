### **Instructions with Starter Code in Markdown**

# Java Logging Lab: Student Management System

## Objective

In this lab, you will:
1. Set up and configure logging in a Java application.
2. Learn how to log messages at different levels.
3. Implement structured logs for a Student Management System.

---

## Instructions

### 1. Setup: Create a New Java Project
- Create a Maven project in your IDE (e.g., IntelliJ, Eclipse).
- Copy the following starter code into a class named `StudentManagementSystem`.

```java
package com.student.management;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class StudentManagementSystem {

    private static final Logger logger = Logger.getLogger(StudentManagementSystem.class.getName());
    private List<String> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
        setupLogger();
    }

    private static void setupLogger() {
        // TODO: Configure the logger
        // 1. Set the global logging level.
        // 2. Add a ConsoleHandler to log messages to the console.
        // 3. Add a FileHandler to log messages to a file named "students.log".
        // 4. Use SimpleFormatter to format the log messages.
    }

    public void addStudent(String studentName) {
        // TODO: Add the student to the list and log an INFO message.
    }

    public void removeStudent(String studentName) {
        // TODO: Remove the student from the list if they exist.
        // Log a WARNING message if the student does not exist.
    }

    public int getStudentCount() {
        // TODO: Log a FINE message indicating the count is being fetched.
        // Return the current number of students in the system.
        return 0; // Replace with the actual count.
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();

        // TODO: Add test cases to:
        // 1. Add students.
        // 2. Remove students.
        // 3. Print the total number of students.
        // Observe how logs are generated at different levels.
    }
}
```

### 2. Configure the Logger
- Inside the `setupLogger` method:
  1. Set the global logging level.
  2. Add a `ConsoleHandler` to log messages to the console.
  3. Add a `FileHandler` to log messages to a file named `students.log`.
  4. Use `SimpleFormatter` to format the log messages.

### 3. Implement Student Operations
- **addStudent(String studentName):**
  - Add the student to the `students` list.
  - Log an `INFO` message indicating the student has been added.
- **removeStudent(String studentName):**
  - Remove the student from the `students` list if they exist.
  - Log a `WARNING` message if the student does not exist.
- **getStudentCount():**
  - Log a `FINE` message indicating the count is being fetched.
  - Return the current number of students in the system.

### 4. Test the Application
- Add test cases to the `main` method to:
  1. Add a few students to the system.
  2. Attempt to remove both existing and non-existent students.
  3. Print the total number of students.

### 5. Change Logging Levels
- Modify the logger's global logging level to `Level.WARNING`.
- Run the application again and observe how only `WARNING` messages appear.

---

## Bonus Challenge
1. Create a custom log formatter:
   - Format logs to include timestamps, log levels, and messages.
2. Add exception handling:
   - Throw an exception for invalid operations (e.g., passing a `null` student name).
   - Catch the exception and log it as `SEVERE`.

---
