import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс, представляющий базу данных сотрудников.
 */
public class EmployeeBase {
    private final List<Employee> employeeList;

    /**
     * Конструктор класса EmployeeBase.
     *
     * @param employeeList Список сотрудников, который будет использоваться в базе данных.
     */
    public EmployeeBase(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    /**
     * Находит сотрудника по его идентификатору.
     *
     * @param id Идентификатор сотрудника.
     * @return Сотрудник с указанным идентификатором или null, если сотрудник не найден.
     */
    public Employee findEmployeeByID(int id) {
        return employeeList.stream()
                .filter(employee -> employee.getEmployeeId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Находит всех сотрудников с указанным опытом.
     *
     * @param exp Опыт, по которому осуществляется поиск сотрудников.
     * @return Список сотрудников с указанным опытом.
     */
    public List<Employee> findEmployeesByExperience(int exp) {
        return employeeList.stream()
                .filter(employee -> employee.getExperience() == exp)
                .collect(Collectors.toList());
    }

    /**
     * Находит телефоны сотрудников по их имени (без учета регистра).
     *
     * @param name Имя сотрудника.
     * @return Список телефонов сотрудников с указанным именем.
     */
    public List<String> findPhonesByName(String name) {
        return employeeList.stream()
                .filter(employee -> employee.getName().equalsIgnoreCase(name))
                .map(Employee::getPhone)
                .collect(Collectors.toList());
    }

    /**
     * Добавляет нового сотрудника в базу данных.
     *
     * @param name Имя нового сотрудника.
     * @param phone Телефон нового сотрудника.
     * @param exp Опыт нового сотрудника.
     */
    public void addEmployee(String name, String phone, int exp) {
        int latestId = employeeList.stream()
                .mapToInt(Employee::getEmployeeId)
                .max()
                .orElse(0);
        employeeList.add(new Employee(latestId + 1, name, phone, exp));
    }

    /**
     * Переопределенный метод toString() для представления базы данных в виде строки.
     *
     * @return Строковое представление базы данных сотрудников.
     */
    @Override
    public String toString() {
        return "EmployeeBase{" +
                "employeeList=" + employeeList +
                '}';
    }
}
