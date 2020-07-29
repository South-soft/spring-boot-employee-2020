package com.thoughtworks.springbootemployee.repository;

import com.thoughtworks.springbootemployee.entity.Company;

import java.util.List;

public interface CompanyRepository {

    List<Company> findAll();

}
