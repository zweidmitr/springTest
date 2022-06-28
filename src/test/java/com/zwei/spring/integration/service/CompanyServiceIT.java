package com.zwei.spring.integration.service;

import com.zwei.spring.ApplicationRunner;
import com.zwei.spring.database.entity.Company;
import com.zwei.spring.dto.CompanyReadDto;
import com.zwei.spring.listner.entity.EntityEvent;
import com.zwei.spring.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = ApplicationRunner.class,
//initializers = ConfigDataApplicationContextInitializer.class)
@SpringBootTest
public class CompanyServiceIT {
    @Autowired
    private CompanyService companyService;
    private static final Integer COMPANY_ID = 1;

    @Test
    void findById() {
        var result = companyService.findById(COMPANY_ID);
        assertTrue(result.isPresent());

        var expectedResult = new CompanyReadDto(COMPANY_ID);
        result.ifPresent(actual -> assertEquals(expectedResult, actual));
    }

}
