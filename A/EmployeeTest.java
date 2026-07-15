abstract class Employee {

    int employeeId;
    String name;

    Employee(int employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }

    // Abstract method
    abstract double calculateSalary();

    // Display employee details
    void display() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + calculateSalary());
        System.out.println();
    }
}

// Full-Time Employee
class FullTimeEmployee extends Employee {

    double monthlySalary;

    FullTimeEmployee(int id, String name, double salary) {
        super(id, name);
        monthlySalary = salary;
    }

    @Override
    double calculateSalary() {
        return monthlySalary;
    }
}

// Part-Time Employee
class PartTimeEmployee extends Employee {

    int hoursWorked;
    double ratePerHour;

    PartTimeEmployee(int id, String name, int hours, double rate) {
        super(id, name);
        hoursWorked = hours;
        ratePerHour = rate;
    }

    @Override
    double calculateSalary() {
        return hoursWorked * ratePerHour;
    }
}

// Contract Employee
class ContractEmployee extends Employee {

    double contractAmount;

    ContractEmployee(int id, String name, double amount) {
        super(id, name);
        contractAmount = amount;
    }

    @Override
    double calculateSalary() {
        return contractAmount;
    }
}

// Main Class
public class EmployeeTest {

    public static void main(String[] args) {

        // Runtime Polymorphism
        Employee e1 = new FullTimeEmployee(101, "Ram", 50000);
        Employee e2 = new PartTimeEmployee(102, "Sita", 80, 500);
        Employee e3 = new ContractEmployee(103, "Hari", 30000);

        e1.display();
        e2.display();
        e3.display();
    }
}