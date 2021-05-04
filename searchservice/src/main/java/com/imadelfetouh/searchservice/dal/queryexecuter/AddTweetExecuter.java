package com.imadelfetouh.searchservice.dal.queryexecuter;

import com.imadelfetouh.searchservice.dal.configuration.QueryExecuter;
import com.imadelfetouh.searchservice.dal.ormmodel.Tweet;
import com.imadelfetouh.searchservice.dal.ormmodel.User;
import com.imadelfetouh.searchservice.model.dto.NewTweetDTO;
import com.imadelfetouh.searchservice.model.response.ResponseModel;
import com.imadelfetouh.searchservice.model.response.ResponseType;
import org.hibernate.Session;

import javax.persistence.Query;

public class AddTweetExecuter implements QueryExecuter<Void> {

    private NewTweetDTO newTweetDTO;

    public AddTweetExecuter(NewTweetDTO newTweetDTO) {
        this.newTweetDTO = newTweetDTO;
    }

    @Override
    public ResponseModel<Void> executeQuery(Session session) {
        ResponseModel<Void> responseModel = new ResponseModel<>();

        User user = getUser(session);

        Tweet tweet = new Tweet(newTweetDTO.getTweetId(), newTweetDTO.getContent(), newTweetDTO.getDate(), newTweetDTO.getTime(), 0, user);

        session.persist(tweet);

        session.getTransaction().commit();

        responseModel.setResponseType(ResponseType.CORRECT);

        return responseModel;
    }

    private User getUser(Session session) {
        Query query = session.createQuery("SELECT u FROM User u WHERE u.userId = :userId");
        query.setParameter("userId", newTweetDTO.getUserId());
        return (User) query.getSingleResult();
    }
}
