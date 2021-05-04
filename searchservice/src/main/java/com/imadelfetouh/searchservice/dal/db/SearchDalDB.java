package com.imadelfetouh.searchservice.dal.db;


import com.imadelfetouh.searchservice.dal.configuration.Executer;
import com.imadelfetouh.searchservice.dal.configuration.SessionType;
import com.imadelfetouh.searchservice.dal.queryexecuter.GetSearchExecuter;
import com.imadelfetouh.searchservice.dalinterface.SearchDal;
import com.imadelfetouh.searchservice.model.dto.SearchDTO;
import com.imadelfetouh.searchservice.model.response.ResponseModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SearchDalDB implements SearchDal {

    @Override
    public ResponseModel<List<SearchDTO>> search(String search) {
        Executer<List<SearchDTO>> executer = new Executer<>(SessionType.READ);
        return executer.execute(new GetSearchExecuter(search));
    }
}
