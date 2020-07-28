package com.thoughtworks.springbootemployee.controller;


import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class CompanyController {

    @Resource
    CompanyService companyService;

//    @GetMapping("/companies")
//    public List<Company> getAllCompany() {
//        return companyService.getAllCompanies();
//    }

    @GetMapping("/companies/{id}")
    public Company getCompany(@PathVariable int id) {
        return companyService.getCompany(id);
    }

    @GetMapping("/companies/{id}/employees")
    public List<Employee> getAllEmployeesUnderCompany(@PathVariable int id) {
        return companyService.getAllEmployeesUnderCompany(id);
    }

    @GetMapping("/companies")
    public List<Company> getCompaniesByPage(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "5") int pageSize) {
        if (page == 0) {
            return companyService.getAllCompanies();
        }
        return companyService.getCompaniesByPage(page, pageSize);
    }

    @PostMapping("/companies")
    public void addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
    }

    @PutMapping("/companies/{id}")
    public void updateCompany(@PathVariable int id, @RequestBody Company company) {
        companyService.updateCompany(id, company);
    }

    @DeleteMapping("/companies/{id}")
    public void deleteAllEmployeesUnderCompany(@PathVariable int id) {
        companyService.deleteAllEmployeesUnderCompany(id);
    }

}
