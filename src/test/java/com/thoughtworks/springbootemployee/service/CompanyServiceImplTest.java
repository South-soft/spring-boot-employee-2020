package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.exception.CompanyNotFoundException;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CompanyServiceImplTest {

    @Mock
    CompanyRepository companyRepository;
    @InjectMocks
    CompanyService companyService;

    @Test
    public void should_be_return_2_employees_when_get_employees_under_company_given_2_employees_and_1_company() {
        //given
        Company company = new Company();
        company.setCompanyId(1);
        company.setEmployees(new ArrayList<>());
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        employee1.setCompany(company);
        employee2.setCompany(company);
        company.getEmployees().add(employee1);
        company.getEmployees().add(employee2);
        when(companyRepository.findById(1)).thenReturn(java.util.Optional.of(company));
        //when
        List<Employee> employees = companyService.getEmployeeUnderCompany(company.getCompanyId());
        //then
        assertEquals(2, employees.size());
    }

    @Test
    public void should_be_return_0_employees_when_get_employees_under_company_given_1_company() {
        //given
        Company company = new Company();
        company.setCompanyId(1);
        company.setEmployees(new ArrayList<>());
        when(companyRepository.findById(1)).thenReturn(java.util.Optional.of(company));
        //when
        List<Employee> employees = companyService.getEmployeeUnderCompany(company.getCompanyId());
        //then
        assertEquals(0, employees.size());
    }

    @Test
    public void should_be_return_exception_employees_when_get_employees_under_company_given_no_company() {
        //given
        Company company = null;
        when(companyRepository.findById(1)).thenReturn(Optional.empty());
        //when
        CompanyNotFoundException companyNotFoundException = assertThrows(CompanyNotFoundException.class, () -> companyService.getEmployeeUnderCompany(1), "companyNotFound");
        //then
        assertEquals("CompanyNotFoundException", companyNotFoundException.getMessage());
    }

}
