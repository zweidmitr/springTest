package com.zwei.spring.service;

import com.zwei.spring.database.repository.CompanyRepository;
import com.zwei.spring.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // final field
public class UserService {
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
}
