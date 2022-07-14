package com.zwei.spring.database.repository;

import com.zwei.spring.database.entity.User;
import com.zwei.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {
    List<User> findAllByFilter(UserFilter userFilter);
}
