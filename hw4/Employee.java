import java.math.BigInteger;

public class Employee {
    private int employeeId;
    private String name;
    private String phone;
    private int experience;

    public Employee(int employeeId, String name, String phone, int experience) {
        this.employeeId = employeeId;
        this.name = name;
        this.phone = phone;
        this.experience = experience;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Сотрудник {" +
                "Id=" + employeeId +
                ", имя='" + name + '\'' +
                ", телефон=" + phone +
                ", стаж=" + experience +
                '}';
    }
}
