import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Student {
    private static int ID_TRACKER = 100000;

    private String name;
    private String username;
    private int id;

    public Student(String name, String username) {
        this.name = name;
        this.username = username;
        this.id = ID_TRACKER;
        ID_TRACKER += 1;
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof Student) {
            Student otherStudent = (Student)other;
            return this.username.equals(otherStudent.username);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.name + " (" + this.username + ")";
    }

    public static void recursivePrint(Student[] students, int index) {
        if(index == students.length) {
            return;
        } else {
            System.out.println(students[index]);
            recursivePrint(students, index + 1);
        }
    }

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("Students.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String sizeLine = bufferedReader.readLine();
            int size = Integer.parseInt(sizeLine);

            Student[] students = new Student[size];

            /* int index = 0;
            String nextLine = bufferedReader.readLine();
            while(nextLine != null) {
                String[] lineBreakdown = nextLine.split(":");
                students[index] = new Student(lineBreakdown[1], lineBreakdown[0]);
                index++;
                nextLine = bufferedReader.readLine();
            } */

            for(int index = 0; index < size; index++) {
                String nextLine = bufferedReader.readLine();
                String[] lineBreakdown = nextLine.split(":");
                students[index] = new Student(lineBreakdown[1], lineBreakdown[0]);
            }

            bufferedReader.close();

            recursivePrint(students, 0);

            Student student1 = new Student("Bob", "bb123");
            Student student2 = new Student("Billy", "bb123");

            System.out.println("True?" + student1.equals(student2));
            System.out.println("False?" + student1.equals("bb123"));

        } catch (IOException e) {
            System.out.println("File Exception This is standard output");
            System.err.println("This is error output");
        }
        
    }
}