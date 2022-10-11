package ru.spb.SpringStram.services;

import ru.spb.SpringStram.Employee;
import java.util.List;

public interface EmployeeService {
    String addEmployee(String name, Integer salary, Integer department);
    List<Employee> getEmployees();
    List<Employee> getEmployeesByDepartment(Integer department);
    Employee getMinSalaryByDepartment(Integer department);
    Employee getMaxSalaryByDepartment(Integer department);
}
