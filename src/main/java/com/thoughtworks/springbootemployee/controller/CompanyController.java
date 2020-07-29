//package com.thoughtworks.springbootemployee.controller;
//
//
//import com.thoughtworks.springbootemployee.entity.Company;
//import com.thoughtworks.springbootemployee.entity.Employee;
//import com.thoughtworks.springbootemployee.service.CompanyService;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@RestController
//@RequestMapping("/companies")
public class CompanyController {
//
//    @Resource
//    CompanyService companyService;
//
//    @GetMapping
//    public List<Company> getAllCompany() {
//        return companyService.getAllCompanies();
//    }
//
//    @GetMapping("/{id}")
//    public Company getCompany(@PathVariable int id) {
//        return companyService.getCompany(id);
//    }
//
//    @GetMapping("/{id}/employees")
//    public List<Employee> getAllEmployeesUnderCompany(@PathVariable int id) {
//        return companyService.getAllEmployeesUnderCompany(id);
//    }
//
//    @GetMapping(params = {"page", "pageSize"})
//    public List<Company> getCompaniesByPage(
//            @RequestParam int page,
//            @RequestParam int pageSize) {
//        if (page == 0) {
//            return companyService.getAllCompanies();
//        }
//        return companyService.getCompaniesByPage(page, pageSize);
//    }
//
//    @PostMapping
//    public void addCompany(@RequestBody Company company) {
//        companyService.addCompany(company);
//    }
//
//    @PutMapping("/{id}")
//    public void updateCompany(@PathVariable int id, @RequestBody Company company) {
//        companyService.updateCompany(id, company);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteAllEmployeesUnderCompany(@PathVariable int id) {
//        companyService.deleteAllEmployeesUnderCompany(id);
//    }
//
}
