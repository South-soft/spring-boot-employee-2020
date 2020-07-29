package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.exception.PageException;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getCompaniesByPage(int page, int pageSize) {
        if (page < 1) {
            throw new PageException("IndexOutOfBoundsException");
        }
        return companyRepository.findAll().stream().skip((page -1) * pageSize).limit(pageSize).collect(Collectors.toList());
    }
}
