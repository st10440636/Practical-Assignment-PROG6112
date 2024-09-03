package Question_1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class Student_Tests {

    private List<Student> studentDatabase;
    private Student student;

    @Before
    public void setUp() {
        studentDatabase = new ArrayList<>();
        student = new Student("John Doe", 20, "S123", "john.doe@example.com", "Computer Science");
        studentDatabase.add(student);
    }

    @Test
    public void TestSaveStudent() {
        // Simulating the addition of a new student directly
        Student newStudent = new Student("Jane Doe", 22, "S124", "jane.doe@example.com", "Mathematics");
        studentDatabase.add(newStudent);

        // Verify that the student has been added to the database
        assertEquals(2, studentDatabase.size());
        assertEquals("Jane Doe", studentDatabase.get(1).getName());
    }

    @Test
    public void TestSearchStudent() {
        // Searching for an existing student
        Student foundStudent = findStudent(studentDatabase, "S123");
        assertNotNull(foundStudent);
        assertEquals("S123", foundStudent.getStudentID());
    }

    @Test
    public void TestSearchStudent_StudentNotFound() {
        // Attempt to search for a non-existent student
        Student foundStudent = findStudent(studentDatabase, "S999");
        assertNull(foundStudent);
    }

    @Test
    public void TestDeleteStudent() {
        // Deleting an existing student
        Student studentToDelete = findStudent(studentDatabase, "S123");
        assertNotNull(studentToDelete);
        studentDatabase.remove(studentToDelete);

        // Verify that the student has been removed from the database
        assertEquals(0, studentDatabase.size());
    }

    @Test
    public void TestDeleteStudent_StudentNotFound() {
        // Attempt to delete a non-existent student
        int initialSize = studentDatabase.size();
        Student studentToDelete = findStudent(studentDatabase, "S999");
        if (studentToDelete != null) {
            studentDatabase.remove(studentToDelete);
        }

        // Verify that the database size has not changed
        assertEquals(initialSize, studentDatabase.size());
    }

    @Test
    public void TestStudentAge_StudentAgeValid() {
        // Validate age for a valid input
        boolean validAge = validateAge(20);
        assertTrue(validAge);
    }

    @Test
    public void TestStudentAge_StudentAgeInvalid() {
        // Validate age for an invalid input (younger than 16)
        boolean validAge = validateAge(15);
        assertFalse(validAge);
    }

    @Test
    public void TestStudentAge_StudentAgeInvalidCharacter() {
        // Test that a NumberFormatException is caught for invalid age input
        boolean caughtException = false;
        try {
            Integer.parseInt("InvalidAge");
        } catch (NumberFormatException e) {
            caughtException = true;
        }
        assertTrue(caughtException);
    }

    // Helper method to find a student by ID in the list
    private Student findStudent(List<Student> studentDatabase, String studentID) {
        for (Student student : studentDatabase) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    // Helper method to validate age
    private boolean validateAge(int age) {
        return age >= 16;
    }
}
