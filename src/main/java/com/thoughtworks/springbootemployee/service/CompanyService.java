package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    Company getCompany(int id);

    List<Employee> getAllEmployeesUnderCompany(int id);

    List<Company> getCompaniesByPage(int page, int pageSize);

    void addCompany(Company company);

    void updateCompany(int id, Company company);

    void deleteAllEmployeesUnderCompany(int id);

}
