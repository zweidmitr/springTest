package com.zwei.spring.database.repository;

import com.zwei.spring.bpp.InjectBean;
import com.zwei.spring.database.pool.ConnectionPool;

public class CompanyRepository {

    @InjectBean
    private ConnectionPool connectionPool;
}
