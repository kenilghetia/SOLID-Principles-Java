public class PartTimeEmployee implements IEmployee, IHourlyEmployee {
    private String name;
    private double hourlyRate;

    public PartTimeEmployee(String name, double hourlyRate) {
        this.name = name;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public void work() {
        System.out.println(name + " is working less than 40 hours a week.");
    }

    @Override
    public void receiveSalary() {
        System.out.println(name + " receives salary based on hours worked.");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void logHours() {
        System.out.println(name + " is logging hours worked everyday.");
    }

    @Override
    public double getHourlyRate() {
        return hourlyRate;
    }

    @Override
    public double calculateSalary(int hoursWorked) {
        return hourlyRate * hoursWorked;
    }
}
