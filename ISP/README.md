### Introduction
The Interface Segregation Principle (ISP) states that:

"Clients should not be forced to depend on interfaces they do not use."

In simpler terms, ISP suggests that you should design your interfaces in such a way that clients (i.e., classes or components that use those interfaces) are only required to implement the methods they actually need. This helps to avoid situations where a class is forced to implement unnecessary methods that are irrelevant to its behavior.


#### Code (violates ISP)
```java
public interface Employee {
    void work();
    void receiveSalary();
    void logHours(); // Relevant to Part-Time employees, but not Full-Time
    void signContract(); // Relevant to Contract employees, but not Full-Time
}
```

```java
public class FullTimeEmployee implements Employee {
    @Override
    public void work() {
        System.out.println("Full-time employee is working 40 hours a week.");
    }

    @Override
    public void receiveSalary() {
        System.out.println("Full-time employee receives a fixed monthly salary.");
    }

    @Override
    public void logHours() {
        // Full-time employees don't need to log hours
        throw new UnsupportedOperationException("Full-time employees don't log hours.");
    }

    @Override
    public void signContract() {
        // Full-time employees don't need to sign contracts (could be irrelevant)
        throw new UnsupportedOperationException("Full-time employees don't sign contracts.");
    }
}
```

```java
public class PartTimeEmployee implements Employee {
    @Override
    public void work() {
        System.out.println("Part-time employee is working less than 40 hours a week.");
    }

    @Override
    public void receiveSalary() {
        System.out.println("Part-time employee receives hourly wages.");
    }

    @Override
    public void logHours() {
        System.out.println("Part-time employee logs their working hours.");
    }

    @Override
    public void signContract() {
        // Part-time employees don't necessarily sign contracts
        throw new UnsupportedOperationException("Part-time employees don't need to sign contracts.");
    }
}
```

```java
public class ContractEmployee implements Employee {
    @Override
    public void work() {
        System.out.println("Contract employee works on a project basis.");
    }

    @Override
    public void receiveSalary() {
        System.out.println("Contract employee receives a fixed payment for a project.");
    }

    @Override
    public void logHours() {
        // Contract employees don't log hours in the traditional way
        throw new UnsupportedOperationException("Contract employees don't log hours like full-time or part-time employees.");
    }

    @Override
    public void signContract() {
        System.out.println("Contract employee signs a contract for their specific project.");
    }
}
```

### Benefits of implementing ISP in This Example:
- No Unnecessary Methods: Now, FullTimeEmployee does not need to implement methods like logHours() or signContract(), which are irrelevant to their role.  
- Flexibility: If you need to add another type of employee, say InternEmployee, you can create a new class that implements only the relevant interfaces (e.g., Employee and perhaps HourlyEmployee for logging hours).  
- Single Responsibility: Each interface has a single responsibility, so classes that implement them only implement the methods that are meaningful and relevant to them.