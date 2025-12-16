package SampleExcercise.cloneDemo;
import java.math.BigDecimal;
import java.util.Arrays;

public class CloneDemo {
    public static void main(String[] args) {
        Manager originalManager = new Manager("Alice", new BigDecimal("1000.00"), Arrays.asList("Budgeting", "Hiring"));
        Department originalDept = new Department("Engineering", originalManager);

        // Clone the department (deep clone). The cloned manager gets +10% salary.
        Department clonedDept = originalDept.clone();

        System.out.println("Original Department: " + originalDept);
        System.out.println("Cloned Department:   " + clonedDept);

        
        clonedDept.getManager().getSkills().forEach(s -> {});
        System.out.println("\nSalaries:");
        System.out.println("Original Manager salary: " + originalDept.getManager().getSalary());
        System.out.println("Cloned Manager salary:   " + clonedDept.getManager().getSalary());
    }
}