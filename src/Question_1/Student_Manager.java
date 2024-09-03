package Question_1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Student_Manager {

    public static void main(String[] args) {
        List<Student> studentDatabase = new ArrayList<>();

        // Prompt the user to press 1 to launch the menu
        String startOption = JOptionPane.showInputDialog("Press 1 to launch the menu or any other key to exit:");

        if ("1".equals(startOption)) {
            launchMenu(studentDatabase);
        } else {
            Student.exitStudentApplication();
        }
    }
    //Main Menu method
    public static void launchMenu(List<Student> studentDatabase) {
        while (true) {
            String[] options = {"1. Capture new Student", "2. Search for a student", "3. Delete a student", "4. Print student report", "5. Exit Application"};

            String selectedOption = (String) JOptionPane.showInputDialog(null,"Select an option:","Student Application System",JOptionPane.PLAIN_MESSAGE,null,options,options[0]
            );

            // If the user clicks the "X" button (selectedOption is null), exit the application
            if (selectedOption == null) {
                int exitChoice = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to exit the application?",
                        "Confirm Exit",
                        JOptionPane.YES_NO_OPTION);

                if (exitChoice == JOptionPane.YES_OPTION) {
                    Student.exitStudentApplication();
                    return; // Exit the loop after exiting the application
                } else {
                    continue; // Return to the main menu if not exiting
                }
            }
            
            if (selectedOption != null) {
            	
                switch (selectedOption) {
                    case "1. Capture new Student":
                        Student.saveStudent(studentDatabase);
                        break;
                    case "2. Search for a student":
                        Student.searchStudent(studentDatabase);
                        break;
                    case "3. Delete a student":
                        Student.deleteStudent(studentDatabase);
                        break;
                    case "4. Print student report":
                        Student.printStudentReport(studentDatabase);
                        break;
                    case "5. Exit Application":
                        Student.exitStudentApplication();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option selected.");
                        break;
                }
            } else {
                Student.exitStudentApplication();
            }
        }
    }
}

