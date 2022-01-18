package learning.micronaut.infrastructure.amqp;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import io.micronaut.rabbitmq.connect.ChannelInitializer;
import jakarta.inject.Singleton;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Singleton
public class AmqpConfig extends ChannelInitializer  {

    private Logger logger = Logger.getGlobal();

    @Override
    public void initialize(Channel channel, String name) throws IOException {

        logger.info("Iniciando rabbitmq");
        channel.exchangeDeclare("store-exchange", BuiltinExchangeType.DIRECT, true);
        channel.exchangeDeclare("type-store-exchange", BuiltinExchangeType.DIRECT, true);

        channel.queueDeclare("store-create-queue", true, false, false , null);
        channel.queueDeclare("type-story-queue", true, false, false, null);

        channel.queueBind("store-create-queue", "store-exchange", "store-create-routing-key");
        channel.queueBind("type-story-queue", "type-store-exchange", "type-store-routing-key");

//        Map<String, Object> argsDLQStore = new HashMap<String, Object>();
//        Map<String, Object> argsDLQStoreType = new HashMap<String, Object>();
//
//        argsDLQStore.put("x-dead-letter-routing-key","store-create-queue");
//        argsDLQStoreType.put("x-dead-letter-routing-key","type-story-queue");
//
//        channel.queueDeclare("store-create-dlq", true, false, false , argsDLQStore);
//        channel.queueDeclare("type-story-dlq", true, false, false, argsDLQStoreType);

        logger.info("Finalizando configuração do rabbitmq...");
    }
}
