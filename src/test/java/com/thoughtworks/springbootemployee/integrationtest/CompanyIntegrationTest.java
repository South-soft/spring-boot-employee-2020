package com.thoughtworks.springbootemployee.integrationtest;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CompanyIntegrationTest {

    @Resource
    MockMvc mockMvc;

    @Resource
    CompanyRepository companyRepository;

    @Resource
    EmployeeRepository employeeRepository;

    @AfterEach
    void clean() {
        employeeRepository.deleteAll();
        companyRepository.deleteAll();
    }

    @Test
    public void should_return_1_company_when_add_company_given_1company() throws Exception {
        String company = "{\"name\":\"oocl\"}";
        mockMvc.perform(post("/companies").contentType(MediaType.APPLICATION_JSON).content(company))
        .andExpect(status().isCreated());

        List<Company> companies = companyRepository.findAll();
        assertEquals(1, companies.size());
    }

    @Test
    public void should_return_1_company_when_get_company_given_company() throws Exception {
        Company company = new Company();
        company.setName("oocl");
        Company companyAdded = companyRepository.save(company);
        mockMvc.perform(get("/companies/" + companyAdded.getCompanyId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("oocl"));
    }

    @Test
    public void should_return_0_company_when_get_company_given_no_company() throws Exception {
        Company company = new Company();
        company.setCompanyId(1);
        mockMvc.perform(get("/companies/" + company.getCompanyId()))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void should_return_1_company_when_update_company_given_1_company() throws Exception {
        Company company = new Company();
        company.setName("oocl");
        Company companyAdded = companyRepository.save(company);
        String updateCompany = "{" +
                "    \"companyId\" : "+companyAdded.getCompanyId()+",\n" +
                "    \"name\" : \"tw\"\n" +
                "}";
        mockMvc.perform(put("/companies/" + companyAdded.getCompanyId())
                .contentType(MediaType.APPLICATION_JSON).content(updateCompany))
                .andExpect(status().isOk());
        List<Company> companies = companyRepository.findAll();
        assertEquals("tw", companies.get(0).getName());
    }

    @Test
    public void should_return_0_company_when_delete_company_given_1_company() throws Exception {
        Company company = new Company();
        company.setName("oocl");
        Company companyAdded = companyRepository.save(company);

        mockMvc.perform(delete("/companies/" + companyAdded.getCompanyId()))
                .andExpect(status().isOk());
        List<Company> companies = companyRepository.findAll();
        assertEquals(0, companies.size());
    }

    @Test
    public void should_return_1_employee_when_get_employee_by_company_id_given_1_company() throws Exception {
        Company company = new Company();
        company.setName("oocl");
        Company companyAdded = companyRepository.save(company);
        Employee employee = new Employee();
        employee.setName("Lester");
        employee.setAge(22);
        employee.setGender("male");
        employee.setCompany(company);
        employeeRepository.save(employee);
        mockMvc.perform(get("/companies/" + companyAdded.getCompanyId() + "/employees"))
                .andExpect(jsonPath("[0].name").value("Lester"));

    }
}
