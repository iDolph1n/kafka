package com.example.creditprocessor.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfig {
    public static final String DECISIONS_QUEUE = "credit-decisions";

    @Bean
    public Queue decisionsQueue() {
        return new Queue(DECISIONS_QUEUE, true);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
