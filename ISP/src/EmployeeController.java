public class EmployeeController {
    public static void main(String[] args) {
        // Creating Regular Employee
        IEmployee regularEmployee = new FullTimeEmployee("Bill");
        System.out.println(regularEmployee.getName());
        regularEmployee.work();
        regularEmployee.receiveSalary();

        // Creating Contractual Employee
        IEmployee contractualEmp = new ContractEmployee("Elon", "1 year");
        System.out.println(contractualEmp.getName());
        contractualEmp.work();
        contractualEmp.receiveSalary();
        ((IContractualEmployee) contractualEmp).signContract();
        System.out.println("Contract duration: " + ((IContractualEmployee) contractualEmp).getContractDuration());

        // Creating Hourly Employee
        IEmployee partTimeEmp = new PartTimeEmployee("Mukesh", 15.50);
        System.out.println(partTimeEmp.getName());
        partTimeEmp.work();
        partTimeEmp.receiveSalary();
        ((IHourlyEmployee) partTimeEmp).logHours();
        System.out.println("Hourly rate: $" + ((IHourlyEmployee) partTimeEmp).getHourlyRate());
        int hoursWorked = 20;
        System.out.println("Salary for " + hoursWorked + " hours: $" + ((IHourlyEmployee) partTimeEmp).calculateSalary(hoursWorked));
    }
}