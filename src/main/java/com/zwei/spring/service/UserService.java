package com.zwei.spring.service;

import com.zwei.spring.database.entity.Company;
import com.zwei.spring.database.repository.CompanyRepository;
import com.zwei.spring.database.repository.CrudRepository;
import com.zwei.spring.database.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;

    public UserService(UserRepository userRepository,
                       CrudRepository<Integer, Company> companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }
}
