public class EmployeeSalaryCalculator {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Aman", 25000);
        e1.display();
        System.out.println("Annual Salary: " + e1.annualSalary());
    }

    static class Employee {
        int id;
        String name;
        double salary;

        Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        double annualSalary() {
            return salary * 12;
        }

        void display() {
            System.out.println("Employee Id: " + id);
            System.out.println("Employee Name: " + name);
            System.out.println("Employee Salary: " + salary);
        }
    }
}
