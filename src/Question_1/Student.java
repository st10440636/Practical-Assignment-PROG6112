package Question_1;

import javax.swing.*;
import java.util.List;

public class Student {
	private String name;
	private int age;
	private String studentID;
	private String email;
	private String course;

	// Constructor
	public Student(String name, int age, String studentID, String email, String course) {
		this.name = name;
		this.age = age;
		this.studentID = studentID;
		this.email = email;
		this.course = course;
	}

	// Getters
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentID() {
		return studentID;
	}

	public String getEmail() {
		return email;
	}

	public String getCourse() {
		return course;
	}

	public String toString() {
		return "\nStudent ID: " + studentID + "\nName: " + name + "\nAge: " + age + "\nEmail: " + email + "\nCourse: "+ course;
	}
	
	//capture a student method
	public static void saveStudent(List<Student> studentDatabase) {
		String name = JOptionPane.showInputDialog("Enter student's name:");

		int age = 0;
		boolean validAge = false;
		while (!validAge) {
			String ageInput = JOptionPane.showInputDialog("Enter student's age (16 or older):");
			try {
				age = Integer.parseInt(ageInput);
				if (age >= 16) {
					validAge = true;
				} else {
					JOptionPane.showMessageDialog(null, "Age must be 16 or older. Please try again.");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for age.");
			}
		}

		String studentID = JOptionPane.showInputDialog("Enter student's ID:");

		String email = "";
		boolean validEmail = false;
		while (!validEmail) {
			email = JOptionPane.showInputDialog("Enter student's email:");
			if (email != null && !email.isEmpty() && email.contains("@") && email.contains(".")) {
				validEmail = true;
			} else {
				JOptionPane.showMessageDialog(null, "Please enter a valid email address.");
			}
		}

		String course = JOptionPane.showInputDialog("Enter student's course:");

		Student newStudent = new Student(name, age, studentID, email, course);
		studentDatabase.add(newStudent);

		JOptionPane.showMessageDialog(null, "Student details have been successfully saved.");
	}

	//search for a student method
	public static void searchStudent(List<Student> studentDatabase) {
		String studentID = JOptionPane.showInputDialog("Enter the student's ID to search:");

		for (Student student : studentDatabase) {
			if (student.getStudentID().equals(studentID)) {
				JOptionPane.showMessageDialog(null, "Student found:\n" + student.toString());
				return;
			}
		}

		JOptionPane.showMessageDialog(null, "Error: Student with ID " + studentID + " cannot be located.");
	}

	//delete a student method
	public static void deleteStudent(List<Student> studentDatabase) {
		String studentID = JOptionPane.showInputDialog("Enter the student's ID to delete:");

		for (Student student : studentDatabase) {
			if (student.getStudentID().equals(studentID)) {
				int confirm = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to delete the following student?\n" + student.toString(),
						"Confirm Deletion", JOptionPane.YES_NO_OPTION);

				if (confirm == JOptionPane.YES_OPTION) {
					studentDatabase.remove(student);
					JOptionPane.showMessageDialog(null, "Student deleted successfully.");
				} else {
					JOptionPane.showMessageDialog(null, "Deletion canceled.");
				}
				return;
			}
		}

		JOptionPane.showMessageDialog(null, "Error: Student with ID " + studentID + " cannot be located.");
	}

	//print student report method
	public static void printStudentReport(List<Student> studentDatabase) {
		for (Student student : studentDatabase) {
			JOptionPane.showMessageDialog(null, "Student Report:\n\n" + student.toString());
			return;
		}
	}

	//exit application
	public static void exitStudentApplication() {
		JOptionPane.showMessageDialog(null, "Exiting the application!\nGoodbye!");
		System.exit(0);
	}
}
