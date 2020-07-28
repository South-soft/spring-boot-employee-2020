package com.thoughtworks.springbootemployee.service.impl;

import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployee(int id) {
        return employees.stream().filter(employee -> employee.getId() == id).findFirst().get();
    }

    @Override
    public List<Employee> getEmployeesByPage(int page, int pageSize) {
        int count = employees.size();
        int pageCount;
        if (count % pageSize == 0) {
            pageCount = count / pageSize;
        } else {
            pageCount = count / pageSize + 1;
        }

        int fromIndex;
        int toIndex;

        if (page > pageCount) {
            page = pageCount;
        }
        if (page != pageCount) {
            fromIndex = (page - 1) * pageSize;
            toIndex = fromIndex + pageSize;
        } else {
            fromIndex = (page - 1) * pageSize;
            toIndex = count;
        }

        return employees.subList(fromIndex, toIndex);
    }

    @Override
    public List<Employee> getEmployeesByGender(String gender) {
        return employees.stream().filter(employee -> employee.getGender().equals(gender)).collect(Collectors.toList());
    }

    @Override
    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                e.setGender(employee.getGender());
            }
        }

    }

    @Override
    public void deleteEmployee(int id) {
        Employee employee = employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        if (employee != null) {
            employees.remove(employee);
        }
    }
}
