package com.imadelfetouh.searchservice.dal.queryexecuter;

import com.imadelfetouh.searchservice.dal.configuration.QueryExecuter;
import com.imadelfetouh.searchservice.dal.ormmodel.User;
import com.imadelfetouh.searchservice.model.dto.NewUserDTO;
import com.imadelfetouh.searchservice.model.response.ResponseModel;
import com.imadelfetouh.searchservice.model.response.ResponseType;
import org.hibernate.Session;

public class AddUserExecuter implements QueryExecuter<Void> {

    private NewUserDTO newUserDTO;

    public AddUserExecuter(NewUserDTO newUserDTO) {
        this.newUserDTO = newUserDTO;
    }

    @Override
    public ResponseModel<Void> executeQuery(Session session) {
        ResponseModel<Void> responseModel = new ResponseModel<>();

        User user = new User(newUserDTO.getUserId(), newUserDTO.getUsername(), newUserDTO.getPhoto());

        session.persist(user);

        session.getTransaction().commit();

        responseModel.setResponseType(ResponseType.CORRECT);

        return responseModel;
    }
}
