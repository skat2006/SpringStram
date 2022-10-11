package ru.spb.SpringStram.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.spb.SpringStram.services.EmployeeService;

@RestController
@RequestMapping("/departments")
public class EmployeeController {
    final private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("name") String name,
                              @RequestParam("salary") Integer salary,
                              @RequestParam("department") Integer department) {
        return employeeService.addEmployee(name, salary, department);
    }

    @GetMapping(path = "/all", params = {})
    public String getEmployees() {
        return employeeService.getEmployees().toString();
    }

    @GetMapping(path = "/all", params = {"department"})
    public String getEmployeesByDepartment(@RequestParam("department") Integer department) {
        return "Сотрудники отдела " + department + ":\n"
                + employeeService.getEmployeesByDepartment(department).toString();
    }

    @GetMapping("/max-salary")
    public String getMaxSalaryByDepartment(@RequestParam("department") Integer department) {
        return employeeService.getMaxSalaryByDepartment(department).toString();
    }

    @GetMapping("/min-salary")
    public String getMinSalaryByDepartment(@RequestParam("department") Integer department) {
        return employeeService.getMinSalaryByDepartment(department).toString();
    }
}
