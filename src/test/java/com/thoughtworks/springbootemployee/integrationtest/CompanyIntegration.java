package com.thoughtworks.springbootemployee.integrationtest;

import com.thoughtworks.springbootemployee.entity.Company;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CompanyIntegration {

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

}