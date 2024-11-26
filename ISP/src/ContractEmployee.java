public class ContractEmployee implements IEmployee, IContractualEmployee {
    private String name;
    private String contractDuration;

    public ContractEmployee(String name, String contractDuration) {
        this.name = name;
        this.contractDuration = contractDuration;
    }

    @Override
    public void work() {
        System.out.println(name + " is working as a contractual employee.");
    }

    @Override
    public void receiveSalary() {
        System.out.println(name + " receives salary as a fixed payment for a project.");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void signContract() {
        System.out.println(name + " has signed a " + contractDuration + " contract.");
    }

    @Override
    public String getContractDuration() {
        return contractDuration;
    }
}
