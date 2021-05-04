package com.imadelfetouh.searchservice.rabbit.delivercallback;

import com.imadelfetouh.searchservice.dal.configuration.Executer;
import com.imadelfetouh.searchservice.dal.configuration.SessionType;
import com.imadelfetouh.searchservice.dal.queryexecuter.DeleteUserExecuter;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class DeleteUserDeliverCallback implements DeliverCallback {

    private static final Logger logger = Logger.getLogger(DeleteUserDeliverCallback.class.getName());

    @Override
    public void handle(String s, Delivery delivery) {
        try {
            logger.info("Message received delete user");
            String userId = new String(delivery.getBody(), StandardCharsets.UTF_8);

            Executer<Void> executer = new Executer<>(SessionType.WRITE);
            executer.execute(new DeleteUserExecuter(userId));
        }
        catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }
}
