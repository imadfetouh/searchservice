package com.imadelfetouh.searchservice.rabbit.thread;

import com.imadelfetouh.searchservice.rabbit.RabbitNonStopConsumer;
import com.imadelfetouh.searchservice.rabbit.consumer.DefaultConsumer;
import com.imadelfetouh.searchservice.rabbit.delivercallback.AddUserDeliverCallback;
import com.rabbitmq.client.DeliverCallback;
import java.util.logging.Logger;

public class AddUserThread implements Runnable {

    private Logger logger = Logger.getLogger(AddUserThread.class.getName());

    private final String queue_name;
    private final String exchange_name;
    private final DeliverCallback deliverCallback;

    public AddUserThread() {
        queue_name = "searchservice_adduserconsumer";
        exchange_name = "adduserexchange";
        deliverCallback = new AddUserDeliverCallback();
    }

    @Override
    public void run() {
        while(true) {
            try {
                RabbitNonStopConsumer rabbitNonStopConsumer = new RabbitNonStopConsumer();
                DefaultConsumer defaultConsumer = new DefaultConsumer(queue_name, exchange_name, deliverCallback);

                rabbitNonStopConsumer.consume(defaultConsumer);
            } catch (Exception e) {
                logger.severe(e.getMessage());
            }
        }
    }
}
