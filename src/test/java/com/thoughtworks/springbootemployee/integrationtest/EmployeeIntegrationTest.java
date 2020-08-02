package com.thoughtworks.springbootemployee.integrationtest;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeIntegrationTest {

    @Resource
    MockMvc mockMvc;

    @Resource
    EmployeeRepository employeeRepository;

    @Resource
    CompanyRepository companyRepository;

    @AfterEach
    void clean() {
        employeeRepository.deleteAll();
        companyRepository.deleteAll();
    }

    @Test
    public void should_return_1_employee_when_get_employee_given_1_employee() throws Exception {
        Company company = new Company();
        company.setName("oocl");
        Company companyAdded = companyRepository.save(company);
        Employee employee = new Employee();
        employee.setName("Lester");
        employee.setGender("male");
        employee.setAge(22);
        employee.setCompany(companyAdded);
        Employee employeeAdded = employeeRepository.save(employee);
        mockMvc.perform(get("/employees/" + employeeAdded.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("Lester"));
    }
}
