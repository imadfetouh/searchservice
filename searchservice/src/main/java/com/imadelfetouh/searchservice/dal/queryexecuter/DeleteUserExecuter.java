package com.imadelfetouh.searchservice.dal.queryexecuter;

import com.imadelfetouh.searchservice.dal.configuration.QueryExecuter;
import com.imadelfetouh.searchservice.dal.ormmodel.User;
import com.imadelfetouh.searchservice.model.response.ResponseModel;
import com.imadelfetouh.searchservice.model.response.ResponseType;
import org.hibernate.Session;

import javax.persistence.Query;

public class DeleteUserExecuter implements QueryExecuter<Void> {

    private String userId;

    public DeleteUserExecuter(String userId) {
        this.userId = userId;
    }

    @Override
    public ResponseModel<Void> executeQuery(Session session) {
        ResponseModel<Void> responseModel = new ResponseModel<>();

        Query query = session.createQuery("SELECT u FROM User u WHERE u.userId = :userId");
        query.setParameter("userId", userId);
        User user = (User) query.getSingleResult();

        session.delete(user);

        session.getTransaction().commit();

        responseModel.setResponseType(ResponseType.CORRECT);

        return responseModel;
    }
}
