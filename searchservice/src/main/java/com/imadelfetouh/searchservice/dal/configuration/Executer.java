package com.imadelfetouh.searchservice.dal.configuration;

import com.imadelfetouh.searchservice.model.response.ResponseModel;
import com.imadelfetouh.searchservice.model.response.ResponseType;
import java.util.logging.Logger;

public class Executer<T> extends SessionHelper{

    private static final Logger logger = Logger.getLogger(Executer.class.getName());

    public Executer(SessionType sessionType) {
        super(sessionType);
    }

    public ResponseModel<T> execute(QueryExecuter<T> queryExecuter) {

        ResponseModel<T> responseModel = new ResponseModel<>();

        try {
            responseModel = queryExecuter.executeQuery(getSession());
        }
        catch (Exception e) {
            logger.severe(e.getMessage());
            rollback();
            responseModel.setResponseType(ResponseType.ERROR);
        }
        finally {
            closeSession();
        }

        return responseModel;
    }
}
