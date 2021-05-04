package com.imadelfetouh.searchservice.endpoint;


import com.imadelfetouh.searchservice.dalinterface.SearchDal;
import com.imadelfetouh.searchservice.model.dto.SearchDTO;
import com.imadelfetouh.searchservice.model.response.ResponseModel;
import com.imadelfetouh.searchservice.model.response.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("search")
public class SearchResource {

    private static final Logger logger = Logger.getLogger(SearchResource.class.getName());

    @Autowired
    private SearchDal searchDal;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SearchDTO>> getFollowingUsers(@RequestParam("search") String search) {

        logger.info("search request made searching for: " + search);

        ResponseModel<List<SearchDTO>> responseModel = searchDal.search(search);

        if(responseModel.getResponseType().equals(ResponseType.EMPTY)) {
            return ResponseEntity.noContent().build();
        }
        else if(responseModel.getResponseType().equals(ResponseType.CORRECT)) {
            return ResponseEntity.ok().body(responseModel.getData());
        }

        return ResponseEntity.status(500).build();
    }
}
