package com.imadelfetouh.searchservice;

import com.imadelfetouh.searchservice.dal.configuration.Executer;
import com.imadelfetouh.searchservice.dal.configuration.SessionType;
import com.imadelfetouh.searchservice.dal.db.SearchDalDB;
import com.imadelfetouh.searchservice.model.dto.SearchDTO;
import com.imadelfetouh.searchservice.model.response.ResponseModel;
import com.imadelfetouh.searchservice.model.response.ResponseType;
import org.junit.jupiter.api.*;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SearchTests {

    @BeforeAll
    static void setupDatabase() {
        Executer<Void> executer = new Executer<>(SessionType.WRITE);
        executer.execute(new SetupTestDatabase());
    }

    @Test
    @Order(2)
    void getUsersCorrectImad() {
        SearchDalDB searchDalDB = new SearchDalDB();

        ResponseModel<List<SearchDTO>> responseModel = searchDalDB.search("ma");

        Assertions.assertEquals(ResponseType.CORRECT, responseModel.getResponseType());
        Assertions.assertEquals(1, responseModel.getData().size());
        Assertions.assertEquals("u123", responseModel.getData().get(0).getItemId());

    }

    @Test
    @Order(2)
    void getUsersCorrectPeter() {
        SearchDalDB searchDalDB = new SearchDalDB();

        ResponseModel<List<SearchDTO>> responseModel = searchDalDB.search("et");

        Assertions.assertEquals(ResponseType.CORRECT, responseModel.getResponseType());
        Assertions.assertEquals(1, responseModel.getData().size());
        Assertions.assertEquals("u1234", responseModel.getData().get(0).getItemId());

    }

    @Test
    @Order(2)
    void getUsersEmpty() {
        SearchDalDB searchDalDB = new SearchDalDB();

        ResponseModel<List<SearchDTO>> responseModel = searchDalDB.search("test");

        Assertions.assertEquals(ResponseType.EMPTY, responseModel.getResponseType());
        Assertions.assertEquals(0, responseModel.getData().size());
    }
}
