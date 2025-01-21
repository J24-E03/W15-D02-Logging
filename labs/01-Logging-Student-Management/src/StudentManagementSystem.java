import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.*;
import java.util.stream.Stream;

public class StudentManagementSystem {
    private static final Logger logger = Logger.getLogger(StudentManagementSystem.class.getName());
    private final List<String> students;
    private static final Formatter formatter = new Formatter();

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
        logger.setLevel(Level.ALL);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(formatter);
        logger.addHandler(consoleHandler);

        try {
            FileHandler fileHandler = new FileHandler("students.log", true);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    public void addStudent(String studentName) {
        // TODO: Add the student to the list and log an INFO message.
        if (studentName == null) {
            logger.severe("Student name cannot be null");
        } else {
            students.add(studentName);
            logger.info(studentName + " was added to the list");
        }
    }

    public void removeStudent(String studentName) {
        // TODO: Remove the student from the list if they exist.
        // Log a WARNING message if the student does not exist.
        if (!students.remove(studentName)) {
            logger.warning("No such student is on the list named " + studentName);
        }
    }

    public int getStudentCount() {
        // TODO: Log a FINE message indicating the count is being fetched.
        // Return the current number of students in the system.
        logger.fine("The count is being fetched...");
        return students.size(); // Replace with the actual count.
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();

        // TODO: Add test cases to:
        // 1. Add students.
        // 2. Remove students.
        // 3. Print the total number of students.
        // Observe how logs are generated at different levels.
        sms.addStudent("Tom");
        sms.addStudent("Bob");
        sms.addStudent("Peter");
        sms.addStudent(null);

        sms.removeStudent("Tom");
        sms.removeStudent("Tom");

        sms.getStudentCount();
    }

    private static final class Formatter extends SimpleFormatter {
        @Override
        public String format(LogRecord record) {
            return new Date(record.getMillis()) + ": " + record.getLevel() + " -> " + record.getLoggerName() + ": " + record.getMessage() + "\n";
        }
    }
}
