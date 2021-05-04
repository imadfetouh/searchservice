package com.imadelfetouh.searchservice.dalinterface;

import com.imadelfetouh.searchservice.model.dto.SearchDTO;
import com.imadelfetouh.searchservice.model.response.ResponseModel;

import java.util.List;

public interface SearchDal {

    ResponseModel<List<SearchDTO>> search(String search);
}
