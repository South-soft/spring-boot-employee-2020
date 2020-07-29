//package com.thoughtworks.springbootemployee.controller;
//
//import com.thoughtworks.springbootemployee.entity.Employee;
//import com.thoughtworks.springbootemployee.service.EmployeeService;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@RestController
//@RequestMapping("/employees")
public class EmployeeController {
//
//    @Resource
//    EmployeeService employeeService;
//
//    @GetMapping
//    public List<Employee> getAllEmployees() {
//        return employeeService.getAllEmployees();
//    }
//
//    @GetMapping(params = "gender")
//    public List<Employee> getEmployeesByGender(@RequestParam String gender) {
//        return employeeService.getEmployeesByGender(gender);
//    }
//
//    @GetMapping("/{id}")
//    public Employee getEmployee(@PathVariable int id) {
//        return employeeService.getEmployee(id);
//    }
//
//    @GetMapping(params = {"page", "pageSize"})
//    public List<Employee> getCompaniesByPage(
//            @RequestParam int page,
//            @RequestParam int pageSize) {
//        return employeeService.getEmployeesByPage(page, pageSize);
//    }
//
//    @PostMapping
//    public void addEmployee(@RequestBody Employee employee) {
//        employeeService.addEmployee(employee);
//    }
//
//    @PutMapping("/{id}")
//    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
//        employeeService.updateEmployee(id, employee);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteEmployee(@PathVariable int id) {
//        employeeService.deleteEmployee(id);
//    }
//
}
