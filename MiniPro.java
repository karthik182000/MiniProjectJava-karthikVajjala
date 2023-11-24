package com.kar;
import java.util.*;
import java.io.*;
class Student {
    private String name;
    private int rollNumber;
    private int marks ;
    private String grade;
    // Step 1: Class Definitions.
    public Student(String name,int rollNumber,int marks){
        this.name=name;
        this.rollNumber=rollNumber;
        this.marks=marks;
        calculateGrade();
    }
    // Step 4: Encapsulation - Getter and Setter methods
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Method to calculate the grade based on marks
    public void calculateGrade(){
        if (marks >= 90 && marks<=100) {
            grade = "A";
        } else if (marks >=80 && marks<90) {
            grade = "B";
        } else if (marks >=70 && marks<80) {
            grade = "C";
        } else {
            grade = "Good, improve yourselves to be in C, B, or A grades.";
        }
    }
    // Method to display Student information
    public void displayStudentInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println();
    }
}

// Step 2: Inheritance - GraduateStudent inherits from Student class
class GraduateStudent extends Student {
    public GraduateStudent(String name, int rollNumber, int marks) {
        super(name, rollNumber, marks);
    }
    //Step 3: Polymorphism - Overriding CalculateGrade method in GraduateStudent class
    public void calculateGrade() {
        if (getMarks() >=90 && getMarks()<=100) {
            setGrade("High Distinction");
        } else if (getMarks() >= 70 && getMarks()<90) {
            setGrade("Distinction");
        } else {
            setGrade("Pass");
        }
    }
}


public class MiniPro {
    public static void main(String[] args) {
        // Step 5: File I/O - Reading and displaying Student information from a file
        readAndDisplayStudentsFromFile("C:\\Users\\ASUS\\IdeaProjects\\kar_java\\input_student_data.txt");
        // Step 5: File I/O - Writing Student information to a file
        writeStudentInfoToFile("C:\\Users\\ASUS\\IdeaProjects\\kar_java\\output_student_data.txt");
        //For Student Class
        //  Hard coded values for student and GraduateStudent instance classes
        /*Student student1 = new Student("Nandu", 1, 95);
        Student student2 = new Student("kishan", 2, 60);
        Student student3 = new Student("Charan", 3, 75);
        Student student4 = new Student("Karthik", 4, 85);
        Student student5 = new Student("Harika", 5, 70);
        //To print / display information for each student
        student1.displayStudentInfo();
        student2.displayStudentInfo();
        student3.displayStudentInfo();
        student4.displayStudentInfo();
        student5.displayStudentInfo();
        //For GraduateStudent Class
        GraduateStudent gradStudent1 = new GraduateStudent("Kishore", 101, 90);
        GraduateStudent gradStudent2 = new GraduateStudent("Vamshi", 102, 65);
        //To print /display information according to GraduateStudent Class
        System.out.println("Graduate Students:");
        gradStudent1.displayStudentInfo();
        gradStudent2.displayStudentInfo();*/
    }
    public static void readAndDisplayStudentsFromFile(String fileName) {
        File file = new File(fileName);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(","); // Assuming CSV format (name, rollNumber, marks)
                String name = data[0];
                int rollNumber = Integer.parseInt(data[1]);
                int marks = Integer.parseInt(data[2]);

                Student student = new Student(name, rollNumber, marks);
                student.displayStudentInfo();
            }
        } catch (IOException e) {
            e.printStackTrace(); // Step 6: Handle or log the exception as needed
        }
    }

    public static void writeStudentInfoToFile(String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            // Sample student data to write (modify as needed)
            String studentData = "Kishore,101,90\n" +
                    "Vamshi,102,65\n";

            bufferedWriter.write(studentData);
        } catch (IOException e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }
    }


}