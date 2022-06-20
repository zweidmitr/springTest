package com.zwei.spring.service;

import com.zwei.spring.database.repository.CompanyRepository;
import com.zwei.spring.database.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private CompanyService companyService;

    public UserService(UserRepository userRepository, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }
}
