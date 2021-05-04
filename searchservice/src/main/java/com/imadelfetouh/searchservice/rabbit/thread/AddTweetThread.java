package com.imadelfetouh.searchservice.rabbit.thread;

import com.imadelfetouh.searchservice.rabbit.RabbitNonStopConsumer;
import com.imadelfetouh.searchservice.rabbit.consumer.DefaultConsumer;
import com.imadelfetouh.searchservice.rabbit.delivercallback.AddTweetDeliverCallback;
import com.rabbitmq.client.DeliverCallback;

import java.util.logging.Logger;

public class AddTweetThread implements Runnable {

    private Logger logger = Logger.getLogger(AddUserThread.class.getName());

    private final String queue_name;
    private final String exchange_name;
    private final DeliverCallback deliverCallback;

    public AddTweetThread() {
        queue_name = "searchservice_addtweetconsumer";
        exchange_name = "addtweetexchange";
        deliverCallback = new AddTweetDeliverCallback();
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
