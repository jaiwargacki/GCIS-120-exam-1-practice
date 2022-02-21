package solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Student {
    private static final String FILENAME = "Students.txt";
    private static int ID_COUNTER = 100000;

    private String name;
    private String username;
    private int idNumber;

    public Student(String name, String username){
        this.name = name;
        this.username = username;
        this.idNumber = ID_COUNTER++;
    }

    @Override
    public String toString() {
        return name + " (" + username + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Student) {
            Student other = (Student)o;
            return this.username.equals(other.username);
        }
        return false;
    }

    public static void printArrayOfStudents(Student[] students, int index) {
        if (index == students.length) {
            return;
        }
        System.out.println(students[index]);
        printArrayOfStudents(students, index + 1);
    }

    public static void main(String[] args) {
        FileReader fileReader;
        try {
            fileReader = new FileReader(FILENAME);
            BufferedReader reader = new BufferedReader(fileReader);
            Student[] array = new Student[Integer.parseInt(reader.readLine())];
            int index = 0;
            String nextLine = reader.readLine();
            while(nextLine != null) {
                String[] lineSplit = nextLine.split(":");
                array[index++] = new Student(lineSplit[1], lineSplit[0]);;
                nextLine = reader.readLine();
            }
            reader.close();

            printArrayOfStudents(array, 0);
        } catch (IOException e) {
            System.err.println("An error occured reading the file");
            System.err.println(e.getMessage());
        }
        
    }
}