public class Department implements Cloneable {
    private String name;
    private Manager manager; 

    public Department(String name, Manager manager) {
        this.name = java.util.Objects.requireNonNull(name, "name must not be null");
        this.manager = java.util.Objects.requireNonNull(manager, "manager must not be null");
    }

    public String getName() {
        return name;
    }

    public Manager getManager() {
        return manager;
    }

    @Override
    public Department clone() {
        try {
            Department cloned = (Department) super.clone();
            cloned.manager = this.manager.clone();
            cloned.manager.increaseSalaryByPercent(java.math.BigDecimal.valueOf(10));
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return "Department{name=" + name + ", manager=" + manager + "}";
    }
}