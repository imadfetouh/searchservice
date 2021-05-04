package com.imadelfetouh.searchservice.dal.configuration;

import com.imadelfetouh.searchservice.model.response.ResponseModel;
import org.hibernate.Session;

public interface QueryExecuter<T> {

    ResponseModel<T> executeQuery(Session session);
}
