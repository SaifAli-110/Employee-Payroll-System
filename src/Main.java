//Employee Payroll System.

import java.awt.*;
import java.util.ArrayList;

abstract class Employee {

    private String Name;
    private int ID;

    public Employee(String Name, int ID) {
        this.ID = ID;
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public int getID() {
        return ID;
    }

    public abstract double CalculateSalary();

    @Override
    public String toString() {
        return ("Employee Name : " + Name + " ID : " + ID + " , Salary : " + CalculateSalary());
    }
}
class FullTimeEmployee extends Employee{
    private double MonthlySalary;

    public FullTimeEmployee(String Name, int ID, double MonthlySalary){
        super(Name,ID);
        this.MonthlySalary = MonthlySalary;
    }

    @Override
    public double CalculateSalary(){
        return MonthlySalary;
    }
}
class PartTimeEmployee extends Employee{

    private int HoursWorked;
    private double HoursRate;

    public PartTimeEmployee(String Name, int ID, int HoursWorked,double HoursRate){
        super(Name,ID);
        this.HoursWorked = HoursWorked;
        this.HoursRate = HoursRate;
    }

    public double CalculateSalary(){
        return HoursWorked * HoursRate;
    }
}
class PayRollSystem{

    private ArrayList<Employee> employeeList;

    PayRollSystem(){
        employeeList = new ArrayList<>();
    }

    public void AddEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void RemoveEmployee(int ID){
        Employee removeToEmployee = null;
        for (Employee employee : employeeList){
            if(employee.getID() == ID){
                removeToEmployee = employee;
                break;
            }
        }
        if (removeToEmployee != null){
            employeeList.remove(removeToEmployee);
        }
    }

    public void DisplayEmployee(){
        for (Employee emp : employeeList){
            System.out.println(emp);
        }
    }
}
public class Main {
    public static void main(String[] args) {

        PayRollSystem PRS = new PayRollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Saif Ali",25,5000);
        PartTimeEmployee emp2 = new PartTimeEmployee("Danish Ali",13,48,100);

//        Add Employee
        PRS.AddEmployee(emp1);
        PRS.AddEmployee(emp2);

        Toolkit.getDefaultToolkit().beep();
        System.out.println("Add Employee Details : \n");
        PRS.DisplayEmployee();
        System.out.println();

//        Delete Employee
        System.out.println("Removing Employee Details : ");
        PRS.RemoveEmployee(13);
        PRS.DisplayEmployee();
        System.out.println();

        System.out.println("Initialize Employee");
        PRS.DisplayEmployee();
        System.out.println();
    }
}