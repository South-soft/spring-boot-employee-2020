package com.thoughtworks.springbootemployee.service.impl;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    List<Company> companies = new ArrayList<>();

    @Override
    public List<Company> getAllCompanies() {
        return companies;
    }

    @Override
    public Company getCompany(int id) {
        return companies.stream().filter(company -> company.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Employee> getAllEmployeesUnderCompany(int id) {
        Company company = companies.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
        return company == null ? null : company.getEmployees();
    }

    @Override
    public List<Company> getCompaniesByPage(int page, int pageSize) {
        int count = companies.size();
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

        return companies.subList(fromIndex, toIndex);
    }

    @Override
    public void addCompany(Company company) {
        companies.add(company);
    }

    @Override
    public void updateCompany(int id, Company company) {
        for (Company c : companies) {
            if (c.getId() == id) {
                c.setEmployees(company.getEmployees());
            }
        }
    }

    @Override
    public void deleteAllEmployeesUnderCompany(int id) {
        Company company = companies.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
        if (company != null) {
            company.getEmployees().clear();
        }
    }
}
