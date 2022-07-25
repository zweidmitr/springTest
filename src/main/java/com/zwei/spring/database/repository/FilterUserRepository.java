package com.zwei.spring.database.repository;

import com.zwei.spring.database.entity.Role;
import com.zwei.spring.database.entity.User;
import com.zwei.spring.dto.PersonalInfo;
import com.zwei.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {
    List<User> findAllByFilter(UserFilter userFilter);

    List<PersonalInfo> findAllByCompanyIdAndRole(Integer companyId, Role role);
}
