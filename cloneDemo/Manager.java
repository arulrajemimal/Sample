import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Manager implements Cloneable {
    private String name;
    private BigDecimal salary;
    private List<String> skills; 

    public Manager(String name, BigDecimal salary, List<String> skills) {
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.salary = Objects.requireNonNull(salary, "salary must not be null");
        this.skills = (skills == null) ? new ArrayList<>() : new ArrayList<>(skills);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public List<String> getSkills() {
        return Collections.unmodifiableList(skills);
    }

    public void increaseSalaryByPercent(BigDecimal percent) {
        Objects.requireNonNull(percent, "percent must not be null");
        BigDecimal multiplier = percent.divide(BigDecimal.valueOf(100));
        this.salary = this.salary.add(this.salary.multiply(multiplier));
    }

    @Override
    public Manager clone() {
        try {
            Manager cloned = (Manager) super.clone();
            cloned.skills = new ArrayList<>(this.skills);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return "Manager{name=" + name + ", salary=" + salary.toPlainString() + ", skills=" + skills + "}";
    }
}