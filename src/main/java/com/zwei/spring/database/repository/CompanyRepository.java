package com.zwei.spring.database.repository;

import com.zwei.spring.database.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface CompanyRepository extends CrudRepository<Company, Integer> {

    public Optional<Company> findById(Integer id);

    public void delete(Company entity);
}
