import java.util.Objects;

public class Employee {

    static int idCounter = 1;

    private String name;
    private int departmentNumber;
    private int salary;
    private final int id;

    public Employee(String name, int departmentNumber, int salary) {
        this.id = idCounter++;
        this.name = name;
        this.departmentNumber = departmentNumber;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public int getDepartmentNumber() {
        return this.departmentNumber;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
        System.out.println("Для " + name + " установлен номер отдела - " + departmentNumber);
    }

    public void setSalary(int salary) {
        this.salary = salary;
        System.out.println("Для сотрудника - " + name + " установлен новый размер оклада = " + salary + " рублей");

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Employee employee = (Employee) o;
        return departmentNumber == employee.departmentNumber && salary == employee.salary && id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, departmentNumber, salary, id);
    }

    @Override
    public String toString() {
        return this.id + "." + " ФИО: " + name + ";" + " Отдел № " + departmentNumber + ";" + " Сумма заработной платы = " + salary;
    }

}
