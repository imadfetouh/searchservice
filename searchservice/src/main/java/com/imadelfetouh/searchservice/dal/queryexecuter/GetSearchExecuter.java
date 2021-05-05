package com.imadelfetouh.searchservice.dal.queryexecuter;

import com.imadelfetouh.searchservice.dal.configuration.QueryExecuter;
import com.imadelfetouh.searchservice.model.dto.SearchDTO;
import com.imadelfetouh.searchservice.model.response.ResponseModel;
import com.imadelfetouh.searchservice.model.response.ResponseType;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class GetSearchExecuter implements QueryExecuter<List<SearchDTO>> {

    private String search;

    public GetSearchExecuter(String search) {
        this.search = search;
    }

    @Override
    public ResponseModel<List<SearchDTO>> executeQuery(Session session) {
        ResponseModel<List<SearchDTO>> responseModel = new ResponseModel<>();

        Query query = session.createSQLQuery("SELECT `user`.userId, 'user', `user`.userphoto, `user`.username FROM `user` WHERE `user`.username LIKE :search ");
        query.setParameter("search", "%"+search+"%");

        List<Object[]> tuples = query.getResultList();
        List<SearchDTO> results = new ArrayList<>();

        for(Object[] tuple : tuples) {
            SearchDTO searchDTO = new SearchDTO((String) tuple[0], (String) tuple[1], (String) tuple[2], (String) tuple[3]);
            results.add(searchDTO);
        }

        responseModel.setData(results);

        responseModel.setResponseType((results.isEmpty()) ? ResponseType.EMPTY : ResponseType.CORRECT);

        return responseModel;
    }
}
