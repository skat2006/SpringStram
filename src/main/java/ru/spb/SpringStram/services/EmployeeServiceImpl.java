package ru.spb.SpringStram.services;

import org.springframework.stereotype.Service;
import ru.spb.SpringStram.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();

    public EmployeeServiceImpl() {
        employees.put("Andrey", new Employee("Andrey", 10000, 3));
        employees.put("Ivan", new Employee("Ivan", 10001, 1));
        employees.put("Pavel", new Employee("Pavel", 10002, 2));
        employees.put("Sergey", new Employee("Sergey", 10003, 3));
        employees.put("Oleg", new Employee("Oleg", 10004, 4));
        employees.put("Igor", new Employee("Igor", 10005, 5));
        employees.put("Mike", new Employee("Mike", 10006, 1));
        employees.put("Olga", new Employee("Olga", 10007, 5));
        employees.put("Sveta", new Employee("Sveta", 10008, 2));
        employees.put("Lena", new Employee("Lena", 10009, 3));
    }

    public String addEmployee(String name, Integer salary, Integer department) {
        employees.put(name, new Employee(name, salary, department));
        return "Done for " + name;
    }

    public List<Employee> getEmployees() {
        return employees.values().stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .toList();
    }

    public List<Employee> getEmployeesByDepartment(Integer department) {
        return employees.values().stream()
                .filter(e -> Objects.equals(e.getDepartment(), department))
                .toList();
    }

    public Employee getMinSalaryByDepartment(Integer department) {
        return getEmployeesByDepartment(department).stream()
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(new Employee("Не найден", 0, 0));
    }

    public Employee getMaxSalaryByDepartment(Integer department) {
        return getEmployeesByDepartment(department).stream()
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(new Employee("Не найден", 0, 0));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeServiceImpl that)) return false;
        return Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employees);
    }
}
