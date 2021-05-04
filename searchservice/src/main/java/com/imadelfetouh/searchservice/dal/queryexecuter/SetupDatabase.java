package com.imadelfetouh.searchservice.dal.queryexecuter;

import com.imadelfetouh.searchservice.dal.configuration.QueryExecuter;
import com.imadelfetouh.searchservice.model.response.ResponseModel;
import org.hibernate.Session;

public class SetupDatabase implements QueryExecuter<Void> {

    @Override
    public ResponseModel<Void> executeQuery(Session session) {
        return new ResponseModel<>();
    }
}
