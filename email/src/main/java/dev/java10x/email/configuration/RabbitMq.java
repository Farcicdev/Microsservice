package dev.java10x.email.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMq {

    private final String queueName = "email-queue";

    @Bean
    public Queue queue() {
        return new Queue(queueName, true);
    }

    @Bean
    public MessageConverter converter() {
        return new JacksonJsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(converter());
        return template;
    }



//    @Bean
//    public Jackson2JsonMessageConverter messageConverter() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return new Jackson2JsonMessageConverter(objectMapper);
//    }

}
