public class StudentManagementSystem {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Ravi", 85);
        s1.display();
    }

    static class Student {
        int id;
        String name;
        int marks;

        Student(int id, String name, int marks) {
            this.id = id;
            this.name = name;
            this.marks = marks;
        }

        void display() {
            System.out.println("Student Id: " + id);
            System.out.println("Student Name: " + name);
            System.out.println("Student Marks: " + marks);
        }
    }
}
