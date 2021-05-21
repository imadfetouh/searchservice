package com.imadelfetouh.searchservice;

import com.imadelfetouh.searchservice.dal.configuration.QueryExecuter;
import com.imadelfetouh.searchservice.dal.ormmodel.User;
import com.imadelfetouh.searchservice.model.response.ResponseModel;
import com.imadelfetouh.searchservice.model.response.ResponseType;
import org.hibernate.Session;

public class SetupTestDatabase implements QueryExecuter<Void> {
    @Override
    public ResponseModel<Void> executeQuery(Session session) {
        ResponseModel<Void> responseModel = new ResponseModel<>();

        User user1 = new User("u123", "imad", "imad.jpg");
        User user2 = new User("u1234", "peter", "peter.jpg");

        session.persist(user1);
        session.persist(user2);

        session.getTransaction().commit();

        responseModel.setResponseType(ResponseType.CORRECT);

        return responseModel;
    }
}
