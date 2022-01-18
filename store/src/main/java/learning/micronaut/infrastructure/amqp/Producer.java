package learning.micronaut.infrastructure.amqp;

import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;
import learning.micronaut.domain.Store;

@RabbitClient("store-exchange")
public interface Producer {

    @Binding("store-create-queue")
    void sendStoryUpdates(Store store);

}
