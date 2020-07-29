package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CompanyServiceImplTest {

    @Mock
    CompanyRepository companyRepository;
    @InjectMocks
    CompanyService companyService;

    @Test
    void should_return_5_companies_when_get_companies_by_page_given_page_1_and_pageSize_5_and_6_companies() {
        // given
        List<Company> companies = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Company company = new Company();
            company.setId(i);
            companies.add(company);
        }

        when(companyRepository.findAll()).thenReturn(companies);

        // when
        List<Company> companiesByPage = companyService.getCompaniesByPage(1, 5);

        // then
        assertEquals(5, companiesByPage.size());
    }

    @Test
    void should_return_1_company_when_get_companies_by_page_given_page_2_and_pageSize_5_and_6_companies() {
        // given
        List<Company> companies = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Company company = new Company();
            company.setId(i);
            companies.add(company);
        }

        when(companyRepository.findAll()).thenReturn(companies);

        // when
        List<Company> companiesByPage = companyService.getCompaniesByPage(2, 5);

        // then
        assertEquals(1, companiesByPage.size());
    }

    @Test
    void should_return_0_company_when_get_companies_by_page_given_page_0_and_pageSize_5_and_6_companies() {
        // given
        List<Company> companies = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Company company = new Company();
            company.setId(i);
            companies.add(company);
        }

        when(companyRepository.findAll()).thenReturn(companies);

        // when
        List<Company> companiesByPage = companyService.getCompaniesByPage(0, 5);

        // then
        assertEquals(0, companiesByPage.size());
    }
}
