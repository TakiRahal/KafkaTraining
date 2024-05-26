package com.producer.service;

import com.common.SharedData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProducerService<T>{

    @Autowired
    private KafkaTemplate<String, T> kafkaTemplate;

    public void sendGenericMessage(T input) {
        log.info("#### -> Publishing message :: {}", input);
        kafkaTemplate.send(SharedData.topicName, input);
    }
}
