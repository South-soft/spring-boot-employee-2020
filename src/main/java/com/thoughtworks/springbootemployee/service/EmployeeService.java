package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.dto.EmployeeDto;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    CompanyRepository companyRepository;

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeeByGender(String gender) {
        return employeeRepository.findByGender(gender);
    }

    public Page<Employee> getEmployeeByPage(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public void addEmployee(EmployeeDto employeeDto) {
        Company company = companyRepository.findById(employeeDto.getCompanyId()).get();
        Employee employee = employeeDto.to();
        employee.setCompany(company);
         employeeRepository.save(employee);
    }

    public void updateEmployee(EmployeeDto employeeDto) {
        Company company = companyRepository.findById(employeeDto.getCompanyId()).get();
        Employee employee = employeeDto.to();
        employee.setCompany(company);
        employeeRepository.save(employee);
    }

}
