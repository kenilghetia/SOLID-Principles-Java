public class FullTimeEmployee implements IEmployee {
    private String name;

    public FullTimeEmployee(String name) {
        this.name = name;
    }

    @Override
    public void work() {
        System.out.println(name + " is working as a regular employee.");
    }

    @Override
    public void receiveSalary() {
        System.out.println(name + " receives a fixed monthly salary.");
    }

    @Override
    public String getName() {
        return name;
    }
}
