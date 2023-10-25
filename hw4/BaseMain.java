import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
 * Табельный номер
 * Номер телефона
 * Имя
 * Стаж
 * Добавить метод, который ищет сотрудника по стажу (может быть список)
 * Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
 * Добавить метод, который ищет сотрудника по табельному номеру
 * Добавить метод добавление нового сотрудника в справочник сотрудников
 */
public class BaseMain {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee(1, "Sam", "9113458754", 10),
                new Employee(2, "John", "9133452233", 50),
                new Employee(3, "Bill", "9884324567788", 60),
                new Employee(4, "Eugene", "9997771122", 125)
        ));

        EmployeeBase someBase = new EmployeeBase(employees);


        someBase.addEmployee("Jess", "7883267755", 6);


        System.out.println(someBase);

        System.out.println();

        System.out.println(someBase.findEmployeeByID(3));

        System.out.println();

        System.out.println(someBase.findEmployeesByExperience(125));

        System.out.println();

        System.out.println(someBase.findPhonesByName("Sam"));


    }

}
