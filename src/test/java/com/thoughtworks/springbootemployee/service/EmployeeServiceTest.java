package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.exception.CompanyNotFoundException;
import com.thoughtworks.springbootemployee.exception.EmployeeNotFoundException;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    EmployeeRepository employeeRepository;
    @InjectMocks
    EmployeeService employeeService;

    @Test
    public void should_get_1_employee_when_get_employee_given_employee_id_1() {
        // given
        int employeeId = 1;
        Employee employee = new Employee();
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));

        // when
        Employee getEmployee = employeeService.getEmployee(employeeId);

        // then
        assertNotNull(getEmployee);
    }

    @Test
    public void should_throw_exception_when_get_employee_given_employee_id_1() {
        // given
        int employeeId = 1;
        Employee employee = new Employee();
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));

        // when

        // when
        EmployeeNotFoundException employeeNotFoundException
                = assertThrows(EmployeeNotFoundException.class, () -> employeeService.getEmployee(1), "companyNotFound");

        // then
        assertEquals("EmployeeNotFoundException", employeeNotFoundException.getMessage());
        Employee getEmployee = employeeService.getEmployee(employeeId);

        // then
        assertNotNull(getEmployee);
    }
}
